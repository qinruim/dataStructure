package com.hust.hwnewcoder;

import java.util.*;

/**
 * @Package： com.hust.hwnewcoder
 * @Title: HJ19错误记录
 * @Author： qrpop
 * @Date： 2023-09-13 15:43
 * @description: 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 */
public class HJ19错误记录 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> map = new LinkedHashMap<>();
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            if (s == null || s.length() == 0){break;}
            String[] ss = s.split(" ");

            String[] file = ss[0].split("\\\\");
            String fileName = file[file.length - 1];
            int n = fileName.length();
            if (n > 16){
                fileName = fileName.substring(n - 16,n);
            }
            //处理后的错误记录
            String errorLog = fileName + " " + ss[1];

            map.put(errorLog, map.getOrDefault(errorLog,0) + 1);



        }

        //输出最后八条
        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
        for (int i = 0; i < map.size() - 8; i++) {
            iterator.next();
        }
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey() + " " + next.getValue());
        }

    }
}
