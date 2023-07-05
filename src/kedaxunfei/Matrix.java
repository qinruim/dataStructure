package kedaxunfei;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] myMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                myMatrix[i][j] = scanner.nextInt();
            }
        }

        int[][] transMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transMatrix[i][j] = myMatrix[j][i];
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = res + Math.abs(transMatrix[i][j] - myMatrix[i][j]);
            }
        }
        System.out.println(res);

    }
}
