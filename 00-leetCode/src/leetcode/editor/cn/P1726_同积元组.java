package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 同积元组
 * tuple-with-same-product
 * @author mqinrui
 * @date 2023-10-19 16:15:55
 */
class P1726_TupleWithSameProduct{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1726_TupleWithSameProduct().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int tupleSameProduct(int[] nums) {
		int res = 0;
		int n = nums.length;
		Map<Integer,Integer> map = new HashMap<>();
		//记录乘积出现的次数
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int pos = nums[i] * nums[j]; //乘积
				map.put(pos,map.getOrDefault(pos,0) + 1);
			}
		}
		//计算符合的元组数
		for (Integer count : map.values()) {
			res += count * (count - 1) / 2 * 8;
		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
