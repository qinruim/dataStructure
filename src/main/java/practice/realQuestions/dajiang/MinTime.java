package practice.realQuestions.dajiang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Package： practice.dajiang
 * @Title: MinTime
 * @Author： qrpop
 * @Date： 2023-08-13 19:27
 * @description: 动归：周末放假了，小疆计划骑着自己的电动车去航拍。小疆打开DjiFly上的去哪拍，找到了多个航拍点。
 * 为了规划路线，小疆提前了解了不同的航拍点之间的连通性和距离，同时还确认了每个航拍点充电桩的充电速率。
 * 小疆的电动车满电电量可行驶的距离为dis，单位km，该电动车每行驶1km消耗1单位电量，且耗费1min，
 * 一共N个航拍点，每个航拍点都有充电桩，使用二维数组paths标识两个航拍点的双向连通性和距离：
 * [[航拍点编号，相邻航拍点编号，两个航拍点的距离]]，示例：[[0,1,3],[0,2,2]...]，
 * 其中[0,1,3]就表示编号为0的航拍点和编号为1的航拍点相距3km，所有航拍点间的距离都小于dis，
 * 数组charge表示在每个航拍点充1单位电的花费的分钟数，
 * 示例：[2, 10]，2表示编号为0的航拍点充电1单位耗时2分钟，10表示编号为1的航拍点充电1单位耗时10分钟。
 * 小疆当前在航拍点a，且电动车无电，请问小疆最少花费多少分钟数从所在的航拍点a抵达航拍点b。
 */
public class MinTime {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int paths_rows = 0;
        int paths_cols = 0;
        paths_rows = in.nextInt();
        paths_cols = in.nextInt();

        int[][] paths = new int[paths_rows][paths_cols];
        for(int paths_i=0; paths_i<paths_rows; paths_i++) {
            for(int paths_j=0; paths_j<paths_cols; paths_j++) {
                paths[paths_i][paths_j] = in.nextInt();
            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }


        int dis;
        dis = Integer.parseInt(in.nextLine().trim());

        int a;
        a = Integer.parseInt(in.nextLine().trim());

        int b;
        b = Integer.parseInt(in.nextLine().trim());

        int charge_size = 0;
        charge_size = in.nextInt();
        int[] charge = new int[charge_size];
        for(int charge_i = 0; charge_i < charge_size; charge_i++) {
            charge[charge_i] = in.nextInt();
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = car_plan(paths, dis, a, b, charge);
        System.out.println(String.valueOf(res));

    }

    /* Write Code Here */
    public static int car_plan(int[][] paths, int dis, int a, int b, int[] charge) {
        int n = charge.length;
        //dp[i]:a到点i的最短时间
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[a] = 0;

        for (int i = 1; i <= dis; i++) {
            int[] temp = Arrays.copyOf(dp,n);
            for (int[] path : paths) {
                int point1 = path[0];
                int point2 = path[1];
                int distance = path[2];

                if (dp[point1] != Integer.MAX_VALUE && distance <= i){
                    //两点距离不超过续航dis，更新最短时间
                    temp[point2] = Math.min(temp[point2],dp[point1] + charge[point2] + distance);
                }
            }
            dp = temp;

        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < paths.length; j++) {
//                int point1 = paths[i][0];
//                int point2 = paths[i][1];
//                int distance = paths[i][2];
//
//                if (dp[point1] != Integer.MAX_VALUE && dp[point1] + distance <= dis){
//                    //两点距离不超过续航dis，更新最短时间
//                    dp[point2] = Math.min(dp[point2],dp[point1] + distance);
//                }
//            }
//            //加充电时间
//            dp[i] += charge[i];
//        }

        return dp[b];

    }
}
