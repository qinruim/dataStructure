package leetcode.editor.cn;

import java.util.*;

/**
 * 带因子的二叉树
 * binary-trees-with-factors
 * @author mqinrui
 * @date 2023-08-29 17:22:24
 */
class P823_BinaryTreesWithFactors{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P823_BinaryTreesWithFactors().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
		//1.会超时的递归 然后 加备忘录进行优化
//		return method1(arr);

		//2.自底向上
		return method2(arr);




    }

	/**
	 * 自底向上 dp[]
	 * @param arr
	 * @return
	 */
	private int method2(int[] arr) {
		final long MOD = (long) 1e9 + 7;
		Arrays.sort(arr);
		int n = arr.length;
		Map<Integer,Integer> arrMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			arrMap.put(arr[i],i);
		}

		//dp[i] :根节点值为arr[i]的二叉树的个数。
		long[] dp = new long[n];
//		dp[0] = 1;
		//初始值：所有 dp[i] 都初始化成 1
		Arrays.fill(dp,1);

		long res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				//因子
				int key = arr[i] / arr[j];
				if (arr[i] % arr[j] == 0 && arrMap.containsKey(key)){
					dp[i] += dp[j] * dp[arrMap.get(key)];
				}
			}
			res += dp[i];

		}
		return (int) (res % MOD);
	}

	/**
	 * 分解出子问题  ： dfs(val) = dfs(x) * dfs(val/x)  前提是这几个值都在arr中
	 * 		由于越分解越小，先排序，这样遍历判断时就只需要遍历下标比val小的即可
	 * 		最终结果就是 遍历arr中所有元素 加起来
	 *
	 * 		只有一个元素也算一种  递归终止条件：元素值=2或者是质数 无法再分解
	 *
	 * 		优化： 会重复递归 因此加备忘录存储递归结果进行优化
	 * @param arr
	 * @return
	 */
	Map<Integer,Long> memo;
	private int method1(int[] arr) {
		final long MOD = (long) 1e9 + 7;
		Arrays.sort(arr);
//		Set<Integer> arrSet = new HashSet<>();
		Map<Integer,Integer> arrMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			arrMap.put(arr[i],i);
		}

		memo = new HashMap<>();
		long res = 0;
		for (int i = 0; i < arr.length; i++) {
			//传入下标
			if (!memo.containsKey(i)){
				memo.put(i,dfs(arr,arrMap,i));
			}
			res += memo.get(i);
//			res += dfs(arr,arrMap,i);
		}

		return (int) (res % MOD);
	}

	/**
	 * 递归函数
	 * @param arr
	 * @param arrMap
	 * @param i
	 * @return
	 */
	private long dfs(int[] arr, Map<Integer,Integer> arrMap, int i) {
		//终止条件：等于2或者是质数无法再分解  或者是最小的数
		if (arr[i] == 2 || isPrimeNum(arr[i]) || i == 0){
			return 1;
		}

		// 递归边界：如果无法分解出两个在arr 中的因子，就无法继续递归了，此时只有1个方案 上面终止条件不必显示写出
		long res = 1; //到此为止不再分解也是1种 要加上
		//遍历比arr[i]小的数 找因子
		for (int j = 0; j < i; j++) {
			//有两个因子
			if(arr[i] % arr[j] == 0 && arrMap.containsKey(arr[i]/arr[j])){
				if (!memo.containsKey(j)){
					memo.put(j,dfs(arr,arrMap,j));
				}
				if (!memo.containsKey(arrMap.get(arr[i]/arr[j]))){
					memo.put(arrMap.get(arr[i]/arr[j]),dfs(arr,arrMap,arrMap.get(arr[i]/arr[j])));
				}
//				res +=  dfs(arr,arrMap,j) * dfs(arr,arrMap,arrMap.get(arr[i]/arr[j]));
				res += memo.get(j) * memo.get(arrMap.get(arr[i]/arr[j]));
			}
			//不能要这个else 因为这是在遍历因子 后面可能有满足条件的因子
//			else {
//				return 1;
//			}

		}
		return res;
	}

	private boolean isPrimeNum(int i) {
		boolean res = true;
		for (int j = 2; j < i; j++) {
			if (i % j == 0){
				res = false;
			}
		}

		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
