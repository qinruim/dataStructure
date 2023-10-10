package com.hust.baidu;

import java.util.*;

/**
 * @Package： com.hust.baidu
 * @Title: Demo2
 * @Author： qrpop
 * @Date： 2023-10-10 19:40
 * @description:
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String oriOrder = scanner.nextLine();
        HashMap<Character,char[]> oriMap = new HashMap<>();
        oriMap.put('u',oriOrder.substring(0,3).toCharArray());
        oriMap.put('g',oriOrder.substring(3,6).toCharArray());
        oriMap.put('o',oriOrder.substring(6,9).toCharArray());

        int n = scanner.nextInt(); //命令个数[1,9]
        scanner.nextLine();
        String[] orders = new String[n];
        for (int i = 0; i < n; i++) {
            orders[i] = scanner.nextLine();
        }

        List<Character> ugoaList = new ArrayList<>();
        List<Character> changeList = new ArrayList<>();

        for (String order : orders) {
            String rwx = order.split(" ")[1]; //权限变动
            //记录改变对象列表
            int len = rwx.length();
            int i = 0;
//            List<Character> ugoaList = new ArrayList<>();
            while (rwx.charAt(i) == '+' || rwx.charAt(i) == '-' || rwx.charAt(i) == '='){
                char ugoa = rwx.charAt(i);
                ugoaList.add(ugoa);
                i++;
            }
            //记录+—=
            char pde = rwx.charAt(i++);
            //记录权限
//            List<Character> changeList = new ArrayList<>();
            while (i < len){
                changeList.add(rwx.charAt(i));
                i++;
            }

            //开始改权限
            if (ugoaList.size() == 1 && ugoaList.get(0) == 'a'){
                //全部修改
                if (pde == '+' || pde == '='){
                    char[] us = oriMap.get('u');
                    char[] gs = oriMap.get('g');
                    char[] os = oriMap.get('o');
                    for (Character ch : changeList) {
                        if (ch == 'r'){
                           us[0] = 'r';
                           gs[0] = 'r';
                           os[0] = 'r';
                        }
                        if (ch == 'w'){
                            us[1] = 'w';
                            gs[1] = 'w';
                            os[1] = 'w';
                        }
                        if (ch == 'x'){
                            us[2] = 'x';
                            gs[2] = 'x';
                            os[2] = 'x';
                        }
                    }
                    oriMap.put('u',us);
                    oriMap.put('g',gs);
                    oriMap.put('o',os);
                }
                if (pde == '-'){
                    char[] us = oriMap.get('u');
                    char[] gs = oriMap.get('g');
                    char[] os = oriMap.get('o');
                    for (Character ch : changeList) {
                        if (ch == 'r'){
                            us[0] = '-';
                            gs[0] = '-';
                            os[0] = '-';
                        }
                        if (ch == 'w'){
                            us[1] = '-';
                            gs[1] = '-';
                            os[1] = '-';
                        }
                        if (ch == 'x'){
                            us[2] = '-';
                            gs[2] = '-';
                            os[2] = '-';
                        }
                    }
                    oriMap.put('u',us);
                    oriMap.put('g',gs);
                    oriMap.put('o',os);
                }

            }else {
                //不全部修改
                for (Character ugo : ugoaList) {
                    //拿到新权限并修改原始权限
                    char[] oris = oriMap.get(ugo);
                    if (pde == '+' || pde == '='){
                        for (Character ch : changeList) {
                            if (ch == 'r'){
                               oris[0] = 'r';
                            }
                            if (ch == 'w'){
                                oris[1] = 'w';
                            }
                            if (ch == 'x'){
                                oris[2] = 'x';
                            }
                        }
                    }
                    if (pde == '-'){
                        for (Character ch : changeList) {
                            if (ch == 'r'){
                                oris[0] = '-';
                            }
                            if (ch == 'w'){
                                oris[1] = '-';
                            }
                            if (ch == 'x'){
                               oris[2] = '-';
                            }
                        }
                    }
                    oriMap.put(ugo,oris);
                }
            }

        }


        StringBuilder sb = new StringBuilder();
        for (char c : oriMap.get('u')) {
            sb.append(c);
        } for (char c : oriMap.get('g')) {
            sb.append(c);
        } for (char c : oriMap.get('o')) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
