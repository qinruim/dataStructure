package practice.realQuestions.huawei;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 1 4 2 5 5 1 6
 * 1 7 8 8 10 2 4 9
 */
public class Limit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //上游系统调用量
        String[] s = scanner.nextLine().split(" ");
        int n = s.length;
        int[] R = new int[n];
        int sum = 0; //上游调用量之和
        for (int i = 0; i < n; i++) {
            R[i] = Integer.parseInt(s[i]);
            sum += R[i];
        }
//        System.out.println(Arrays.toString(R));

        int cnt = scanner.nextInt(); //核心系统最大调用量

        //处理逻辑
        int limit = 0; //阈值
        //sum<=cnt 正常调用  返回-1
        if (sum <= cnt){
            limit = Integer.MAX_VALUE;
//            System.out.println(-1);
        }
        //sum>cnt 设置阈值
        else {
            //二分法
            int left = 1,right = cnt;
            while (left <= right){
                int mid = (left + right) >> 1;
                int temp = 0;
                for (int i = 0; i < n; i++) {
                    temp += Math.min(R[i],mid);
                }
                //limit大了
                if (temp > cnt){
                    right = mid - 1;
                }
                else {
                    limit = mid;
                    left = mid + 1;
                }
            }
        }
        System.out.println(limit);

//        int limit;
//        if (cnt < n){
//            //全为1都会超过
//            limit = 0;
//        }
//        else if (cnt >= sum){
//            limit = -1;
//        }
//        else {
//            limit = 0;
//            int tempLimit = cnt / n;
//            while (true){
//                for (int i = 0; i < R.length; i++) {
//                    limit += Math.min(R[i],tempLimit);
//                }
//                if (limit > cnt){
//                    limit = tempLimit;
//                    break;
//                }
//                tempLimit++;
//            }
//        }
//
//        System.out.println(limit);
    }
}
