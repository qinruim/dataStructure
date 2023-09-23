package com.hust.xiaomi;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Package： com.hust.xiaomi
 * @Title: MI1
 * @Author： qrpop
 * @Date： 2023-09-23 15:50
 * @description:
 */
public class MI1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numAndR = scanner.nextLine();
        String[] s = numAndR.split(",");
        int towerNum = Integer.parseInt(s[0]);
        int radius = Integer.parseInt(s[1]);
        int[][] towers = new int[towerNum][3];
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int i = 0; i < towerNum; i++) {
            String s1 = scanner.nextLine();
            String[] ss = s1.split(",");
            int[] towerI = new int[3];
            towerI[0] = Integer.parseInt(ss[0]);
            towerI[1] = Integer.parseInt(ss[1]);
            towerI[2] = Integer.parseInt(ss[2]);
            towers[i] = towerI;
            minX = Math.min(towerI[0],minX);
            maxX = Math.max(towerI[0],maxX);
            minY = Math.min(towerI[1],minY);
            maxY = Math.max(towerI[1],maxY);
        }

        int xLeft = minX - radius;
        int xRight = maxX + radius;
        int yLeft = minY - radius;
        int yRight = maxY + radius;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
                return o2[2] - o1[2];
        });
        for (int x = xLeft; x <= xRight; x++) {
            for (int y = yLeft; y <= yRight; y++) {
                int Q = 0; //x,y处的信号强度
                for (int[] tower : towers) {
                    double d = Math.sqrt(Math.pow(x - tower[0],2) + Math.pow(y - tower[1],2));
                    if (d > radius){continue;}
                    double q = tower[2] / (1 + d);
                    Q += (int) q;
                }

               int[] pqEle = new int[3];
                pqEle[0] = x;
                pqEle[1] = y;
                pqEle[2] = Q;
                pq.add(pqEle);
            }

        }

        int[] poll = pq.poll();
        int x = poll[0];
        int y = poll[1];
        System.out.println(x + "," + y);


    }
}
