package leetcode.editor.cn;

/**
 * 不同的二叉搜索树
 * @author qr
 * @date 2023-08-11 23:36:54
 */
class P96_UniqueBinarySearchTrees{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P96_UniqueBinarySearchTrees().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
		//要储存 dp[0]到dp[n]   n+1 个元素
		int[] dp = new int[n + 1];

		dp[0] = 1; //空树 一种
		//dp[i]表示有i个节点时，不同二叉树的个数
		for (int i = 1; i <= n; i++) {
			//对任意i，以j为头结点，左子树有j-1个节点，右子树有i-j个节点
			for (int j = 1; j <= i; j++) {
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}
		return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
