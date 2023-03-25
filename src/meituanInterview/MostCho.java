package meituanInterview;

import java.util.Arrays;
import java.util.Scanner;

public class MostCho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] q = new int[m];
        for (int i = 0; i < m; i++) {
            q[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(q);

        int ans = 0;
        int j = 0;
        for (int i = n - 1; i >= 0 && j < m; i--) {
            if (a[i] <= q[j]) {
                ans++;
            } else {
                i++;
                j++;
            }
        }
        System.out.println(ans);
    }

}
