package com.hust.hwnewcoder;

import java.io.*;

/**
 * @Package： com.hust.hwnewcoder
 * @Title: HJ18ANS
 * @Author： qrpop
 * @Date： 2023-09-12 15:55
 * @description:
 */
public class HJ18ANS {
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numA = 0, numB = 0, numC = 0, numD = 0, numE = 0, numErr = 0, numP = 0;
        String line;
        String[] ip;
        int ip0;
        int ip1;
        String[] mask;
        MaskNum maskNum = new MaskNum();
        while ((line = br.readLine()) != null) {
            String[] arr = line.split("~");
            ip = arr[0].split("\\.");
            mask = arr[1].split("\\.");
            if ("0".equals(ip[0]) || "127".equals(ip[0])) {
                continue;
            }
            // 检查ip
            if (ip.length > 4) {
                numErr++;
                continue;
            }
            boolean errIP = false;
            for(int i = 0; i < ip.length; i++){
                if (ip[i] == null || "".equals(ip[i])) {
                    numErr++;
                    errIP = true;
                    break;
                }
            }
            if (errIP) continue;

            // 检查掩码
            if (!maskNum.check(mask)) {
                numErr++;
                continue;
            }


            ip0 = Integer.parseInt(ip[0]);
            if (ip0 <= 126) {
                numA++;
            } else if (ip0 <= 191) {
                numB++;
            } else if (ip0 <= 223) {
                numC++;
            } else if (ip0 <= 239) {
                numD++;
            } else if (ip0 <= 255) {
                numE++;
            }

            ip1 = Integer.parseInt(ip[1]);
            if (ip0 == 10 || (ip0 == 192 && ip1 > 15 && ip1 < 32) || (ip0 == 192 && ip1 == 168)) {
                numP++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(numA).append(" ");
        sb.append(numB).append(" ");
        sb.append(numC).append(" ");
        sb.append(numD).append(" ");
        sb.append(numE).append(" ");
        sb.append(numErr).append(" ");
        sb.append(numP);

        System.out.print(sb);
    }

    static class MaskNum {
        boolean[] numFlag = new boolean[256];
        MaskNum() {
            int num = 0;
            for (int i = 7; i > 0; i--){
                num += 1 << i;
                numFlag[num] = true;
            }
        }

        boolean check(String[] mask){
            boolean must0 = false;
            int num;
            if (mask.length > 4) {
                return false;
            }

            String mask0 = mask[0];
            boolean allEquals = true;
            for(int i = 1; i < mask.length; i++){
                if (!mask0.equals(mask[i])) {
                    allEquals = false;
                    break;
                }
            }
            if(allEquals) return false;

            for(int i = 0; i < mask.length; i++){
                if (mask[i] == null) {
                    return false;
                }
                num = Integer.parseInt(mask[i]);
                if (num < 0 || num > 255) {
                    return false;
                }
                if (!must0) {
                    if (num == 255) {
                        continue;
                    }
                    if (num == 0 || numFlag[num]) {
                        must0 = true;
                    } else {
                        return false;
                    }
                } else {
                    if (num == 0) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }

    }
}
