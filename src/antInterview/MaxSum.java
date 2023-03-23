package antInterview;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSum {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//           int n = in.nextInt();
//           int k = in.nextInt();
//            System.out.println(getMaxSum(n,k));
//        }
//    }
//
//    private static int getMaxSum(int n, int k) {
//        // 将n的数位打乱，转换为字符数组，然后排序
//        char[] digits = Integer.toString(n).toCharArray();
//        Arrays.sort(digits);
//        // 从后往前取k-1个分割点，切分n成k块
//        int sum = 0;
//        int pos = digits.length - 1;
//        for (int i = 0; i < k - 1; i++) {
//            int nextPos = pos;
//            while (nextPos > 0 && digits[nextPos - 1] == digits[pos]) {
//                nextPos--;
//            }
//            int num = Integer.parseInt(new String(digits, nextPos, pos - nextPos + 1));
//            sum += num;
//            pos = nextPos - 1;
//        }
//        // 剩余部分为最后一块
//        int num = Integer.parseInt(new String(digits, 0, pos + 1));
//        sum += num;
//        return sum;
//    }
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
