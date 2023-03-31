package pinduoduo;

import java.util.Scanner;
import java.util.jar.JarEntry;

public class Array3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }


        int maxSum = Integer.MIN_VALUE;
        int start = -1;
        int end = -1;

//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                int sum = 0;
//                for (int k = i; k <= j; k++) {
//                    sum += nums[k];
//                }
//                if (sum > maxSum) {
//                    maxSum = sum;
//                    start = i;
//                    end = j;
//                }
//            }
//        }


        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum *= nums[j];
                if (sum >= maxSum){
                    maxSum = sum;
                    start = i;
                    end = j;
                }
            }

        }




        if (maxSum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(start + " " + end);
        }




    }

}