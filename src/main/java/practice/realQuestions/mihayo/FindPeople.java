package practice.realQuestions.mihayo;

import java.util.Scanner;

/**
 * @Package： practice.mihayou
 * @Title: FindPeople
 * @Author： qrpop
 * @Date： 2023-08-13 20:58
 * @description: 矩阵，找人
 */
public class FindPeople {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        //三人坐标
        int[][] locations = new int[3][2];
        for (int i = 0; i < 3; i++) {
            locations[i][0] = scanner.nextInt();
            locations[i][1] = scanner.nextInt();
        }

        //米跟月下的距离
        int dis1 = Math.min(Math.abs(locations[0][0] - locations[1][0]),n - Math.abs(locations[0][0] - locations[1][0]))
                + Math.min(Math.abs(locations[0][1] - locations[1][1]),m -Math.abs(locations[0][1] - locations[1][1]) );
        //月下跟教主距离
        int dis2 = Math.min(Math.abs(locations[2][0] - locations[1][0]),n - Math.abs(locations[2][0] - locations[1][0]))
                + Math.min(Math.abs(locations[2][1] - locations[1][1]),m -Math.abs(locations[2][1] - locations[1][1]) );

        System.out.println(dis1);
        System.out.println(dis2);
        System.out.println(dis1 + dis2);
    }
}
