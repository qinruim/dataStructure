package pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class Array4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0){
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }


            int max = Arrays.stream(a).max().getAsInt();
            int[] cnt = new int[max + 1];
            for (int i = 0; i < n; i++) {
                cnt[a[i]]++;
            }
            int ans = 0;
            int sum = 0;
            for (int i = 0; i <= max; i++) {
                ans += cnt[i];
                sum += cnt[i];
                if (sum > n - sum){
                    break;
                }
            }
            System.out.println(ans);

        }
        scanner.close();



    }

}