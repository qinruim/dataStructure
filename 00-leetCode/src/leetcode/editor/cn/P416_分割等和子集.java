package leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 分割等和子集
 * @author qr
 * @date 2023-08-14 11:39:47
 */
class P416_PartitionEqualSubsetSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P416_PartitionEqualSubsetSum().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {

		//个人思路：回溯找出所有可能的子集，判断两个子集之和是否相等
		//结果对 但是超时
//		return backTracking(nums);

		//动态规划-背包
		return bag(nums);
    }

	/**
	 * 动规：1.数组和的一半——背包容量
	 * 		2.数组元素——物品
	 * 		问题：能否将背包装满
	 *
	 * @param nums
	 * @return
	 */
	private boolean bag(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		//奇数肯定不行
		if (sum % 2 == 1){
			return false;
		}
		//偶数才可以
		int target = sum / 2;
		//因为 dp[target] 不可能比target大，大的话说明有物品的价值大于容量  但是这个题中物品的价值始终等于容量
		//也就是说 dp[i]顶多等于i  或者没装满 就小于i
		//dp[j]:容量为j的背包能装的最大价值（nums数组，既是物品重量，又是物品价值）
		//递推公式： dp[j] = max( dp[j], dp[j - nums[i]] + nums[i])
		//背包容量：target
		int[] dp = new int[target + 1];


		for (int i = 0; i < nums.length; i++) {
			//背包容量target   如果j < nums[i],说明放不下物品i
			for (int j = target; j >= nums[i]; j--) {
				dp[j] = Math.max(dp[j],dp[j - nums[i]] + nums[i]);
			}

			//小小剪枝
			if (dp[target] == target){
				return true;
			}
		}

		//dp[target] == target ,背包装满
		//因为 dp[target] 不可能比target大，大的话说明有物品的价值大于容量  但是这个题中物品的价值始终等于容量
		//也就是说 dp[i]顶多等于i  或者没装满 就小于i
		return dp[target] == target;
	}




	LinkedList<Integer> path = new LinkedList<>();
	int sum = 0;
	int subSum = 0;
	boolean flag = false;
	/**
	 * 回溯
	 * @param nums
	 * @return
	 */
	private boolean backTracking(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		getSubset(nums,0);
		return flag;
	}

	private void getSubset(int[] nums, int startIndex) {
		if (startIndex >= nums.length){
			return;
		}
//		int subSum = 0;
//		for (int i = 0; i < path.size(); i++) {
//			subSum += path.get(i);
//		}
		if (subSum == sum - subSum){
			flag = true;
			return;
		}

		for (int i = startIndex; i < nums.length; i++) {
			if (flag){
				break;
			}
			path.add(nums[i]);
			subSum += nums[i];
			getSubset(nums,i + 1);
			subSum -= nums[i];
			path.removeLast();
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
