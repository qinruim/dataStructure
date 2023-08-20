package leetcode.editor.cn;

import java.lang.annotation.Target;

/**
 * 最后一块石头的重量 II
 * @author qr
 * @date 2023-08-14 15:00:18
 */
class P1049_LastStoneWeightIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1049_LastStoneWeightIi().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	 * 尽量将石头分成最接近的两部分   二者之差的绝对值就是结果
	 * 即让容量为总重量一半时，尽可能多装，这样包里的和剩下的才最接近
	 * @param stones
	 * @return
	 */
	public int lastStoneWeightII(int[] stones) {
		//dp[j]:容量为j的包，能装的最大价值
		//让bagSize为sum的一半，并尽量多装


		//一维数组
//		return oneDimension(stones);

		//二维数组
		return twoDimension(stones);


    }

	private int twoDimension(int[] stones) {
		int sum = 0;
		for (int i = 0; i < stones.length; i++) {
			sum += stones[i];
		}

		int bagSize = sum / 2;

		//i是物品 j是背包容量
		int[][] dp = new int[stones.length][bagSize + 1];
		//初始化
		for (int j = stones[0]; j < bagSize + 1; j++) {
			dp[0][j] = stones[0];
		}

		//遍历
		for (int i = 1; i < stones.length; i++) {
			for (int j = 1; j < bagSize + 1; j++) {
				if (j < stones[i]){
					dp[i][j] = dp[i - 1][j];
				}else {
					dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - stones[i]] + stones[i]);
				}
			}
		}

		return Math.abs(dp[stones.length - 1][bagSize] - (sum - dp[stones.length - 1][bagSize]));
	}

	/**
	 * 一维数组
	 * @param stones
	 * @return
	 */
	private int oneDimension(int[] stones) {
		int sum = 0;
		for (int i = 0; i < stones.length; i++) {
			sum += stones[i];
		}

		int bagSize = sum / 2;

		int[] dp = new int[bagSize + 1];

		for (int i = 0; i < stones.length; i++) {
			for (int j = bagSize; j >= stones[i]; j--) {
				dp[j] = Math.max(dp[j],dp[j - stones[i]] + stones[i]);
			}
		}


		return Math.abs(dp[bagSize] - (sum -dp[bagSize]));
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
