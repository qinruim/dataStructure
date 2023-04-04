package meituan;

import java.util.Scanner;

public class Collector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        //记录满足感
        int[] record = new int[n];

        int[] opNums = new int[m];
        for (int i = 0; i < m; i++) {
            opNums[i] = scanner.nextInt();
        }
        int[] xNums = new int[m];
        for (int i = 0; i < m; i++) {
            xNums[i] = scanner.nextInt();
        }
        int[] yNums = new int[m];
        for (int i = 0; i < m; i++) {
            yNums[i] = scanner.nextInt();
        }


        for (int i = 0; i < m; i++) {
            if (opNums[i] == 0){
                record[xNums[i] - 1] = yNums[i];
            }else {
                int left = xNums[i],right = yNums[i];
                int temp = 0;
                for (int j = left - 1; j < right; j++) {
                    temp += record[j];
                }
                System.out.print(temp + " ");
            }
        }
    }
}
