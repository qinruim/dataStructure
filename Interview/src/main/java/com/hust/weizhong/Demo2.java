package com.hust.weizhong;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Package： com.hust.weizhong
 * @Title: Demo2
 * @Author： qrpop
 * @Date： 2023-09-13 20:41
 * @description: 听歌
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//歌曲数量
//        int[] songs = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
//            songs[i] = scanner.nextInt();
            int songId = scanner.nextInt();
            deque.addLast(songId);
        }

       while (!deque.isEmpty()){
           if (deque.size() == 1){
               System.out.println(deque.pollFirst());
               break;
           }
           int first = deque.pollFirst();
           System.out.print(first + " ");
           int newFirst = deque.pollFirst();
           deque.offerLast(newFirst);
       }










    }
}
