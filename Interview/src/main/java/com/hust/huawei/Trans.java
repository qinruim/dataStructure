package com.hust.huawei;

import java.util.*;

/**
 * @Package： com.hust.huawei
 * @Title: Trans
 * @Author： qrpop
 * @Date： 2023-09-27 19:38
 * @description: 货物运输
 *
 *
3 3 1 2
3 4 6
1 1 4
 */
public class Trans {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(); //货物数量
        int n = scanner.nextInt();  //卡车数量
        int x = scanner.nextInt(); //拖斗数量
        int y = scanner.nextInt();  //拖斗容量

//        int[] goods = new int[m];
        LinkedList<Integer> goods = new LinkedList<>();
        int[] tracks = new int[n];
        for (int i = 0; i < m; i++) {
//            goods[i] = scanner.nextInt();
            goods.add(scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            tracks[i] = scanner.nextInt();
        }

//        Arrays.sort(goods);
        Collections.sort(goods);
        Arrays.sort(tracks);

        if (goods.get(0) > tracks[n - 1] + y){
            System.out.println(0);
            return;
        }


        int count = 0;

        LinkedList<Integer> trackStack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            trackStack.push(tracks[i]);
        }
        while (trackStack.peek() >= goods.get(0)){
            int i = 0;
            while (trackStack.peek() >= goods.get(i)){
                i++;
            }
            trackStack.pop();
            goods.remove(i - 1);
            count++;
        }

//        System.out.println("count1" + count);

        for (int j = 0; j < x; j++) {
            int sz = trackStack.size();

            int k = trackStack.get(sz - 1 - j) + y;
            trackStack.set(sz - 1 - j,k);
        }

        for (Integer i : trackStack) {
            System.out.print(i + " ====");
        }


        System.out.println(trackStack.peek());

        while (trackStack.peek() >= goods.get(0)){
            int i = 0;
            while (trackStack.peek() >= goods.get(i)){
                i++;
            }
            trackStack.pop();
            goods.remove(i - 1);
            count++;
        }

        System.out.println(count);



    }
}
