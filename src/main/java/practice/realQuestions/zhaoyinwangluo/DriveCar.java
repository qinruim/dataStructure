package practice.realQuestions.zhaoyinwangluo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Package： practice.realQuestions.zhaoyinwangluo
 * @Title: DriveCar
 * @Author： qrpop
 * @Date： 2023-09-04 16:19
 * @description: 练车
 */
public class DriveCar {

    static int res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[][] time = new int[count][2];
        for (int[] row : time) {
                row[0] = scanner.nextInt();
                row[1] = scanner.nextInt();
        }

        Arrays.sort(time,(o1,o2) -> {
            return o1[0] - o2[0];
        });

        LinkedList<int[]> list = new LinkedList<>();
        backTrack(time,list,0);
        System.out.println(res);
    }

    private static void backTrack(int[][] time, LinkedList<int[]> list, int startIndex) {
        for (int i = startIndex; i < time.length; i++) {
            if (i > 0 && time[i][0] < time[i - 1][1]){
                continue;
            }
            list.add(time[i]);
            res = Math.max(res,list.size());
            backTrack(time,list,i + 1);
            list.removeLast();
        }
    }
}
