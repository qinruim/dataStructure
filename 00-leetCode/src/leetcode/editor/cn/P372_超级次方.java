package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 超级次方
 * super-pow
 * @author mqinrui
 * @date 2023-10-10 14:42:02
 */
class P372_SuperPow{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P372_SuperPow().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
		 static final long MOD = 1337;
    public int superPow(int a, int[] b) {
		//递归
		if (b.length == 0) return 1;

		//取出最后一个数
		int last = b[b.length - 1];
		int[] newB = Arrays.copyOfRange(b,0,b.length - 1);
		//原问题拆分  且为了避免溢出 可以先求模 ：(a * b) % k = (a % k) * (b % k) % k
		int part1 = myPow(a,last);
		int part2 = myPow(superPow(a,newB),10);
		return (int) ((part1 * part2) % MOD);
    }

	/**
	 * /求 a的k次方求模的结果
	 * @param a
	 * @param k
	 * @return
	 */
	private int myPow(int a, int k) {
		a %= MOD;
		int res = 1;
		for (int i = 0; i < k; i++) {
			res *= a; //潜在溢出点（乘法）
			res %= MOD; //防止溢出
		}
		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
