package com.hust.hwnewcoder;

import java.util.Scanner;

/**
 * @Package： com.hust.hwnewcoder
 * @Title: HJ18识别IP
 * @Author： qrpop
 * @Date： 2023-09-12 10:20
 * @description:
 */
public class HJ18识别IP {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] res = new int[7]; //ABCDE，错误，私有
        while (in.hasNextInt()) {
            String[] im = in.nextLine().split("~");

            String ip = im[0];
            String mask = im[1];



            //掩码错误
            if (!validMask(mask)){
                res[5]++;
                continue;
            }

            //ip  0 或者127开头 直接忽略
            int ipv = validIP(ip);
            if(ipv == 2){//ip错误
                res[5]++;
                continue;
            }

            //都合法
            //定义判断ip地址类别的函数 返回ABCDE P 对应五类和私有
            char ipClass = getIPClass(ip,mask);
            switch (ipClass){
                case 'A':res[0]++;
                case 'B':res[1]++;
                case 'C':res[2]++;
                case 'D':res[3]++;
                case 'E':res[4]++;
                case 'P':res[6]++;
            }

            for (int re : res) {
                System.out.println(re + " ");
            }
        }
    }

    /**
     * 判断ip类型
     * @param ip
     * @param mask
     * @return
     */
    private static char getIPClass(String ip, String mask) {
        String[] ips = ip.split(".");
        int ip1 = Integer.parseInt(ips[0]);
        int ip2 = Integer.parseInt(ips[1]);

        if (ip1 == 10 || (ip1 == 172 && ip2 >= 16 && ip2 <= 31) || (ip1 == 192 && ip2 == 168)){
            return 'P';
        }

        if (ip1 >= 1 && ip1 <= 126){
            return 'A';
        }
        if (ip1 >= 128 && ip1 <= 191) {
            return 'B';
        }
        if (ip1 >= 192 && ip1 <= 223) {
            return 'C';
        }
        if (ip1 >= 224 && ip1 <= 239) {
            return 'D';
        }else {
            return 'E';
        }

    }

    private static boolean validMask(String mask) {
        if (mask.equals("0.0.0.0") || mask.equals("255.255.255.255")){
            return false;
        }
        String[] masks = mask.split("\\.");
        String trueMask = masks[0] + masks[1] + masks[2] + masks[3];
        //在一堆1的中间出现0 即第一个0的后面只能是0
        String bs = Long.toBinaryString(Long.parseLong(trueMask));
        boolean flag = false;
        for (int i = 0; i < bs.length(); i++) {
            //第一个0
            if (bs.charAt(i) == '0'){
                for (int j = i + 1; j < bs.length(); j++) {
                    if (bs.charAt(j) == '1'){
                        return false;
                    }

                }
                break;
            }
        }

        return true;
    }

    //返回0 代表忽略 1合法 2不合法
    private static int validIP(String ip) {
        String[] ips = ip.split(".");
        int ip1 = Integer.parseInt(ips[0]);
        int ip2 = Integer.parseInt(ips[1]);
        int ip3 = Integer.parseInt(ips[2]);
        int ip4 = Integer.parseInt(ips[3]);
        if (ip1 == 0 || ip1 == 127){
            return 0;
        }
        //已经排除了0，127
        if (ip1 >= 1 && ip1 <= 255 && ip2 >= 1 && ip2 <= 255 &&ip3 >= 1 && ip3 <= 255 &&ip4 >= 1 && ip4 <= 255){
            return 1;
        }
        return 2;
    }
}
