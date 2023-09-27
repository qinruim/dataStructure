package com.hust.shein;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Package： com.hust.shein
 * @Title: Demo1
 * @Author： qrpop
 * @Date： 2023-09-27 09:46
 * @description:
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        List<Integer> time = new ArrayList<>();
        List<Integer> requests = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            time.add(scanner.nextInt());
            requests.add(scanner.nextInt());
        }

        int bucket = 100;
        int limit = 0;

        for (int i = 0; i < row; i++) {
            if (i == 0){
                bucket = bucket + time.get(i) / 10;
            }else {
                bucket = bucket + (time.get(i) - time.get(i - 1)) / 10;
            }

            if (bucket > 150){
                bucket = 150;
            }
            if (bucket < requests.get(i)){
                limit += requests.get(i) - bucket;
                bucket = 0;
            }
            else {
                bucket -= requests.get(i);
            }
        }

        System.out.println(limit);
    }
}
