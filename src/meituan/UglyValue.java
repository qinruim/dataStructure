package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class UglyValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = scanner.nextInt();
        }
        System.out.println(n + Arrays.toString(h));

        //排序
        int[] sortedH = Arrays.stream(h).sorted().toArray();
        System.out.println(Arrays.toString(sortedH));
        int result = 0;
        for (int i = 0; i < sortedH.length - 1; i++) {
            result += sortedH[i + 1] - sortedH[i];
        }
        System.out.println(result);
    }
}
