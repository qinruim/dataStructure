package practice.realQuestions.xiaomi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Package： com.hust.xiaomi
 * @Title: Demo1
 * @Author： qrpop
 * @Date： 2023-09-22 16:20
 * @description:
 *                  手机系统中注册了若干组空闲任务，每个任务有各自的耗电量以及允许任务运行的最低初始电量，
 *                  我们需要计算手机能够串行完成全部任务的最低初始电量。
 * 注意点1: 所有电量以mAh(毫安时)计，电池容量是4800mAh。
 * 注意点2:本题目假设手机在运行空闲任务期间，不处于充电状态，也没有额外耗电行为。
 * 注意点3:智能应用引擎会以最合适的顺序串行运行任务。
 * 输入描述
 * 一个描述了所有任务的长字符串。任务与任务之间用逗号阳开，每组任务由耗电量及最低初始电量组成，用冒号限开。
 * 输出描述
 * 一个数字，代表依次完成全部任务的最低初始电量，如果最低初始电量超过手机电池容量，则返回-1。
 * 样例输入
 * 1:10,2:12,3:10
 * 样例输出
 * 13
 * 提示
 * 在样例中，手机至少需要有13mah的初始电量，在运行任务2后剩余电量11mAh、运行任务1后剩余电量10mah、运行任务3后剩余7mah。
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String[] tasks = s.split(",");

        List<int[]> taskList = new ArrayList<>();
        for (String task : tasks) {
            String[] ele = task.split(":");
            int cost = Integer.parseInt(ele[0]); //任务耗电量
            int needMin = Integer.parseInt(ele[1]); //需要最低电量
            int[] temp = new int[]{cost,needMin};
            taskList.add(temp);
        }

        //按照需要最低电量从高到低排序 需要电量相同则按耗电量从低到高（默认）
        taskList.sort((o1, o2) -> {
//            if (o2[1] == o1[1]){
//                return o1[0] - o2[0];
//            }
            return o2[1] - o1[1];
        });
//        for (int[] ints : taskList) {
//            System.out.print(ints[0] + "  ");
//            System.out.println(ints[1]);
//        }
        //
        int n = tasks.length;
        int ans = taskList.get(n - 1)[1];
        for (int i = n - 2; i >= 0; i--) {
            int needI = taskList.get(i)[1];
            int costI = taskList.get(i)[0];
            //从后往前倒推
            //如果需要的 《 提供的  那就更新
            if (ans < needI -costI){
                ans = needI;
            }else {
                //否则 为了保证最终结果最小 更新为需要的
                ans = ans + costI;
            }

            if (ans > 4800){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(ans);
    }
}
