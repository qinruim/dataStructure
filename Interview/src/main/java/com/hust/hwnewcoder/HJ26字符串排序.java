package com.hust.hwnewcoder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @Package: com.hust.hwnewcoder
 * @Title: HJ26字符串排序
 * @Author: qinrui
 * @Date 2023-09-17 15:44
 * @description:
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 * 如，输入： Type 输出： epTy
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 * 如，输入： BabA 输出： aABb
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 * 如，输入： By?e 输出： Be?y
 */
public class HJ26字符串排序 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();

        List<Character> chList = new ArrayList<>();
        //收集英文字母 并排序
        for (char ch :chars){
            if (Character.isLetter(ch)){
                chList.add(ch);
            }
        }
        chList.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Character.toLowerCase(o1) - Character.toLowerCase(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0,j = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])){
                sb.append(chList.get(j));
                j++;
            }else {
                sb.append(chars[i]);
            }
        }

        System.out.println(sb.toString());
    }
}
