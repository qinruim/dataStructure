package practice.dajiang;

/**
 * @Package： practice.dajiang
 * @Title: CrcleRoad
 * @Author： qrpop
 * @Date： 2023-08-13 19:25
 * @description: 无人机环路 贪心
 *                 解决下面无人机飞行规划问题：
 * 给定一个环形路线实施无人机作业，在路线上有n个充电站，编号0, … n-1，
 * i号充电站可以给无人机提供charge[i] 单位的电量。
 * 无人机从i号充电站出发完成作业，并飞往i+1号充电站需要消耗 cost[i] 单位的电量。
 * 假设无人机可以无限量充电。无人机从其中一个充电站完成充电出发（充电前初始电量为空），
 * 给定正整数数组charge和cost, 如果无人机可以顺时针绕环形路线一周完成作业并返回出发充电站，则返回出发时充电站的编号i，否则返回-1.
 *
 * 注：为简化问题，如果存在解，输入数据可保证解唯一。测试用例输入格式为 (length of charge, charge, length of cost, cost).
 *
 * 示例1.
 * 输入: length of charge = 5,  charge = [1,2,3,4,5],  length of cost = 5, cost = [3,4,5,1,2]
 * 输出: 3
 * 解析：从3号充电站出发，电量为4；飞到4号充电站，电量为4-1+5=8；
 * 飞到0号充电站，电量为8-2+1=7;飞到1号充电站，电量为7-3+2=6；飞到2号充电站，电量为6-4+3=5；
 * 飞回到3号充电站，电量5正好满足cost[2].
 *
 * 示例2.
 * 输入: length of charge = 3, charge = [2,3,4], length of cost = 3, cost = [3,4,3]
 * 输出: -1
 * 解析：从0号或者1号充电站出发，得到的电量都不能满足飞到下一站的电量。
 * 从2号充电站出发，电量为4；飞到0号充电站，电量为4-3+2=3；飞
 * 到1号充电站，电量为3-3+3=3；但是无法返回2号充电站，cost[1]>3.
 */
public class CrcleRoad {
    public static void main(String[] args) {
        int lengthOfCharge = 5;
        int[] charge = {1,2,3,4,5};
        int lengthOfCost = 5;
        int[] cost = {3,4,5,1,2};


        System.out.println(completeCycle(charge, cost));

    }

    private static int completeCycle(int[] charge, int[] cost) {
        int sum = 0,min = 0;
        for (int i = 0; i < charge.length; i++) {
            sum = sum + charge[i] - cost[i];
            min = Math.min(sum,min);
        }

        if (sum < 0){
            return -1;
        }
        if (min >= 0){
            return 0;
        }

        for (int i = charge.length - 1; i > 0; i--) {
            min = min + charge[i] - cost[i];
            if (min >= 0){
                return i;
            }

        }

        return -1;
    }
}
