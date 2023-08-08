package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 分发饼干
 * assign-cookies
 * @author mqinrui
 * @date 2023-08-08 16:38:43
 */
class P455_AssignCookies{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P455_AssignCookies().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	 * 思路：为了满足更多的小孩，就不要造成饼干尺寸的浪费。
	 *	 大尺寸的饼干既可以满足胃口大的孩子也可以满足胃口小的孩子，那么就应该优先满足胃口大的。
	 *	 这里的局部最优就是大饼干喂给胃口大的，充分利用饼干尺寸喂饱一个，全局最优就是喂饱尽可能多的小孩。
	 * 	 可以尝试使用贪心策略，先将饼干数组和小孩数组排序。
	 * 	 然后从后向前遍历小孩数组，用大饼干优先满足胃口大的，并统计满足小孩数量。
	 * @param g  小孩胃口
	 * @param s  饼干尺寸
	 * @return
	 */
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
//		Integer[] G = Arrays.stream(g).boxed().toArray(Integer[]::new);

//
//		Arrays.sort(G,(o1,o2) -> o2.compareTo(o1)); // 降序

		int childCount = 0;
		int flag = g.length;

		for (int j = s.length - 1; j >= 0; j--) {

			for (int i = flag - 1; i >= 0; i--) {
				if (s[j] >= g[i] && flag > i ){
					childCount++;
					flag = i;
					break;
				}
			}

		}


		return childCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
