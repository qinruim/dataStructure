package mihayo;

import java.util.Scanner;

public class NewArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int bLen = n - 1;
        int[] b = new int[bLen];
        for (int i = 0; i < bLen; i++) {
            b[i] = scanner.nextInt();
        }

        int[] a = new int[n];
        a[0] = b[0];
        for (int i = 1; i < bLen; i++) {
            a[i] = b[i - 1] - a[i - 1];
        }
        a[n - 1] = b[n - 2];

        int c = 1;
        for (int i = 0; i < n; i++) {
            int tmp = i;
            while (tmp < n && a[tmp] == a[i]){
                tmp++;
            }
            c *= tmp - i;
            i = tmp - 1;
        }

        //生成a
//        int[] a = new int[n];
////        a[0] = b[0] - a[1];
//        a[0] = b[0];
//        for (int i = 1; i < bLen; i++) {
//            a[i] = b[i - 1] - a[i - 1];
//        }
////        a[n - 1] = b[n - 2] - a[n - 2];
//        a[n - 1] = b[n - 2];
////        a[0] = b[0] - a[1];
//
//        }
//        for (int i = 0; i < n; i++) {
//            boolean flag = true;
//            for (int j = 0; j < bLen; j++) {
//                if (a[j] + a[j + 1] != b[j]){
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag){
//                c++;
//            }
//            if (i == n - 1){
//                break;
//            }
//            int temp = a[i];
//            a[i] = a[i + 1];
//            a[i + 1] = temp;
//
//        }
        System.out.println(c);



    }
}
