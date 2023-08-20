package leetcode.editor.cn;

/**
 * 一和零
 * ones-and-zeroes
 * @author mqinrui
 * @date 2023-08-20 14:56:29
 */
class P474_OnesAndZeroes{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P474_OnesAndZeroes().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
		// 01背包 但是背包有两个维度m、n，而不同长度的字符串就是不同大小的待装物品
		//即装满容量为m、n的背包的物品的个数；其中每个物品的0和1的个数就是重量weight[i],每个字符串的价值都是它的个数1

		//dp[i][j]：装满i个0，j个1的字符串的个数;要求的就是dp[m][n]
		// 若dp[i][j]最后一个元素中有zeroNum个0，oneNum个1:
		//纯01递推：dp[j] = max(dp[j], dp[j - weight[i]] + value[i])
		// dp[i][j] = max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1)

		int[][] dp = new int[m + 1][n + 1];

		//初始化 都初始为0即可

		//先遍历物品，再遍历背包
		for (String str : strs) {
			int zeroNum = 0,oneNum = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '0'){
					zeroNum++;
				}else {
					oneNum++;
				}
			}

			//倒序遍历背包容量
			for (int i = m; i >= zeroNum; i--) {
				for (int j = n; j >= oneNum; j--) {
					dp[i][j] = Math.max(dp[i][j],dp[i - zeroNum][j - oneNum] + 1);
				}
			}
		}

		//打印dp数组
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.print(dp[i][j] + "\t");
			}
			System.out.println('\t');
		}

		return dp[m][n];

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
