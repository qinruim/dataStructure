package practice.dajiang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Package： practice.dajiang
 * @Title: SubThreadIndex
 * @Author： qrpop
 * @Date： 2023-08-13 16:55
 * @description:
 *               给定几个线程的开始时间和结束时间，求不重叠的时间内，权重最高的子线程的索引
 *               给定几个1*3的一维数组，对应线程的 [权重，开始时间，结束时间]
 *               例如：[1,2,3] 代表权重为1的线程，开始时间为2，结束时间为3
 *                     [1,2,4] 跟上面的线程重叠，所以不考虑
 *                     [5,5,6]
 *                     假设上面三个线程为一组，求从0开始执行，哪些不重叠进程能组成最大的权重，返回这几个线程的索引
 */
public class SubThreadIndex {
    static int maxWeight = Integer.MIN_VALUE;
    static LinkedList<List<Integer>> maxWeightThreadList = new LinkedList<>();
    static LinkedList<List<Integer>> track = new LinkedList<>(); //记录线程组合

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取线程数
        int n = scanner.nextInt();
        // 读取线程信息
//        int[][] threads = new int[n][3];
        List<List<Integer>> threadList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
//            threads[i][0] = scanner.nextInt();
//            threads[i][1] = scanner.nextInt();
//            threads[i][2] = scanner.nextInt();
            List<Integer> thread = new ArrayList<>();
            thread.add(scanner.nextInt());
            thread.add(scanner.nextInt());
            thread.add(scanner.nextInt());
            //维护索引
            thread.add(i);
            threadList.add(thread);
        }

//        int maxWeight = Integer.MIN_VALUE;
        // 按照开始时间排序
        threadList.sort((o1, o2) -> {
            if (o1.get(1) == o2.get(1)) {
                return o1.get(2) - o2.get(2);
            }
            return o1.get(1) - o2.get(1);
        });

//

        //回溯穷举所有不重叠的线程组合
        backtrack(threadList, 0);

        System.out.println(maxWeight);
        for (List<Integer> list : maxWeightThreadList) {
            System.out.print(list.get(3) + " ");
        }


    }

    private static void backtrack(List<List<Integer>> threadList, int startIndex) {
        //结束条件
        if (startIndex == threadList.size()) {
            //计算权重
            int weight = 0;
            for (List<Integer> list : track) {
                weight += list.get(0);
            }
            if (weight > maxWeight) {
                maxWeight = weight;
                maxWeightThreadList.clear();
                maxWeightThreadList.addAll(track);
            }
            return;
        }

        //选择列表
        for (int i = startIndex; i < threadList.size(); i++) {
            //判断是否重叠 重叠则跳过 不重叠则加入
            if (track.size() > 0 && isOverLap(track.get(track.size() - 1), threadList.get(i))) {
                continue;
            }

            //做选择
            track.add(threadList.get(i));
            //递归
            backtrack(threadList, i + 1);
            //撤销选择
            track.removeLast();
        }





    }

    private static boolean isOverLap(List<Integer> lastThreadOfMaxList, List<Integer> nextThread) {
        if (lastThreadOfMaxList.get(1) >= nextThread.get(2) || lastThreadOfMaxList.get(2) <= nextThread.get(1)){
            return false;
        }
        return true;
    }


}
