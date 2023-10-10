package leetcode.editor.cn;

import java.time.MonthDay;
import java.util.Arrays;

/**
 * 移动机器人
 * movement-of-robots
 * @author mqinrui
 * @date 2023-10-10 11:03:47
 */
class P2731_MovementOfRobots{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P2731_MovementOfRobots().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		 static final int MOD = 1000000007;
    public int sumDistance(int[] nums, String s, int d) {
		//所有机器人视为相同，那么把碰撞视为直接穿越无事发生，等价于二者方向改变 速度不变
		int n = nums.length;
		long[] longs = new long[n];
		for (int i = 0; i < n; i++) {
			char dire = s.charAt(i); //方向
			if (dire == 'R'){
				longs[i] = (long) nums[i] + d;
			}
			if (dire == 'L'){
				longs[i] = (long) nums[i] - d;

			}
		}
		long res = 0;
		//找一个数组中两两元素和暴力二次循环会超时
//		for (int i = 0; i < n - 1; i++) {
//			for (int j = i + 1; j < n; j++) {
//				res = (res % MOD +  Math.abs(longs[i] % MOD - longs[j] % MOD) % MOD) % MOD;
//			}
//		}

		//排序后从小到大枚举 a[i]，此时左边有i个数都不超过 a[i]，
		// 那么 a[i] 与其左侧机器人的距离之和为:
		//(a[i]−a[0])+(a[i]−a[1])+⋯+(a[i]−a[i−1])
		//= i⋅a[i]−(a[0]+a[1]+⋯+a[i−1])

		Arrays.sort(longs);
		long sum = 0;
		for (int i = 0; i < n; i++) {
			res = (res + i * longs[i] - sum) % MOD;
			sum += longs[i];
		}
		return (int) res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
