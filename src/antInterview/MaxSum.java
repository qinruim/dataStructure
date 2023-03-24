package antInterview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目：
 * 有一个整数n，将n的数位从大到小排列，然后把n切成k块，再求和，使这个和最大。用java代码给出答案
 */
public class MaxSum {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number n: ");
    String n = sc.nextLine();
    System.out.print("Enter the number of chunks k: ");
    int k = sc.nextInt();

    // Convert the string to an array of integers and sort it in descending order
    int[] digits = new int[n.length()];
    for (int i = 0; i < n.length(); i++) {
        digits[i] = n.charAt(i) - '0';
    }
    Arrays.sort(digits);
    for (int i = 0; i < digits.length / 2; i++) {
        int temp = digits[i];
        digits[i] = digits[digits.length - 1 - i];
        digits[digits.length - 1 - i] = temp;
    }

    // Divide the sorted array into k chunks and sum them
    int sum = 0;
    int chunkSize = digits.length / k;
    int remaining = digits.length % k;
    int index = 0;
    for (int i = 0; i < k; i++) {
        int chunkLength = chunkSize + (i < remaining ? 1 : 0);
        int chunkSum = 0;
        for (int j = 0; j < chunkLength; j++) {
            chunkSum = chunkSum * 10 + digits[index++];
        }
        sum += chunkSum;
    }

    System.out.println("Maximum sum: " + sum);
}
}
