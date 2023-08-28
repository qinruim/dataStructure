package leetcode.editor.cn;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 绝对差不超过限制的最长连续子数组
 * @author qr
 * @date 2023-08-28 23:34:32
 */
class P1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubarray(int[] nums, int limit) {
		int left = 0,right = 0;
		int res = 0;
		//记录最大和最小的两个元素 只要这两个满足限制 其他一定满足
		//要更新最大和最小值  判断限制用来缩窗口
//		int[] maxAndMin = new int[2];
//		maxAndMin[0] = Integer.MIN_VALUE;  //用来保存最大值
//		maxAndMin[1] = Integer.MAX_VALUE;  //用来保存最小值
//		TreeSet<Integer> window = new TreeSet<>(); //TreeSet保证天然顺序 第一个元素最小 最后一个最大
		//但是set不能重复 而数组中可能存在重复元素  所以用treemap(根据treemap排序)
		TreeMap<Integer,Integer> window = new TreeMap<>();

		while (right < nums.length){
			//扩
			int key = nums[right];
			window.put(key,window.getOrDefault(key,0) + 1);
			right++;

			//不满足就缩
			while (Math.abs(window.firstKey() - window.lastKey()) > limit){
				int d = nums[left];
				window.put(d,window.get(d) - 1);
				if (window.get(d) <= 0){
					window.remove(d);
				}
				left++;
			}
			res = Math.max(res,right - left);
		}

		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
