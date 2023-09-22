package com.hust;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        String s = "./home/qr/document/../qq";
        String s = "/home/qrpop/../../";
        String[] split = s.split("/");
//        System.out.println(split.length);
//        System.out.println(split[0]);
//        System.out.println(split[0].equals(""));
        String first = split[0];
        Deque<String> deque = new LinkedList<>(); //存储路径
        if (first.equals("")){
            deque.add("/");
        }
        if (first.equals("~")){
            deque.add("/");
            deque.add("home");
            deque.add("user");
        }


        for (int i = 0; i < split.length; i++) {
            String path = split[i];
            if (split[i].equals(".")){
                continue;
            }
            if (path.equals("..")){
                if (deque.size() < 1){
                    System.out.println(-1);
                    return;
                }
                deque.removeLast();
                continue;
            }
            deque.addLast(path);
        }

        String last = deque.getLast();
        if (last == null){
            System.out.println("/");
        }
        System.out.println(last);

    }
}
