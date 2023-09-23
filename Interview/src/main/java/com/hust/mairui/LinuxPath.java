package com.hust.mairui;

import com.hust.Main;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Package： com.hust.mairui
 * @Title: LinuxPath
 * @Author： qrpop
 * @Date： 2023-09-23 07:52
 * @description:
 */
public class LinuxPath {
    public static void main(String[] args) {
//        String s = "./home/qr/document/../qq";
        String s = "/";
//        String s = "/home/qrpop/../../";
        String[] split = s.split("/");
        System.out.println(split.length);
//        System.out.println(split[0]);
        String first = split[0];
        Deque<String> deque = new LinkedList<>(); //存储路径
        if (first.equals("")){
            deque.add("/");
        }
        if (first.equals("~")){
            deque.add("~");
        }
        if (first.equals(".")){
            deque.add("currentPath");
        }
//        String property = System.getProperty("user.dir");
//        System.out.println(property);
        int n = split.length;
        if (n < 2){
            System.out.println(deque.getLast());
            return;
        }
        for (int i = 1; i < split.length; i++) {
            String dir = split[i];
            if (dir.equals("")){
                if (i == split.length - 1){
                    continue;
                }else {
                    System.out.println(-1);
                    return;
                }
            }
            if (dir.equals(".")){
                continue;
            }
            if (dir.equals("..")){
                if (deque.size() < 1){
                    System.out.println(-1);
                    return;
                }
                deque.removeLast();
                continue;
            }
            deque.addLast(dir);
        }

        String last = deque.getLast();
        System.out.println(last);

    }

}
