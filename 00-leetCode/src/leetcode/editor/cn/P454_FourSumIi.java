//给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足： 
//
// 
// 0 <= i, j, k, l < n 
// nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
//输出：2
//解释：
//两个元组如下：
//1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1)
// + 2 = 0
//2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1)
// + 0 = 0
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length 
// n == nums2.length 
// n == nums3.length 
// n == nums4.length 
// 1 <= n <= 200 
// -2²⁸ <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2²⁸ 
// 
//
// Related Topics 数组 哈希表 👍 773 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 四数相加 II
 * @author mqinrui
 * @date 2023-03-29 10:22:22
 */
public class P454_FourSumIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P454_FourSumIi().new Solution();
	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		/**
		 * 定义一个hashmap，key为两数之和，value为这个和出现的次数
		 * 		遍历前两个数组，统计两个数组元素之和以及出现次数，放到map
		 * 		遍历后两个数组，去map中找匹配的
		 * 		统计四数之和为0的次数，返回之
		 */
		Map<Integer, Integer> map = new HashMap<>();
		int sum; //记录两个元素之和
		int count = 0; //记录四元素值和为0的出现次数
		//前两个数组
		for (int num1 : nums1) {
			for (int num2 : nums2) {
				sum = num1 + num2;
				if (map.containsKey(sum)){
					//map中存在,次数+1
					map.put(sum,map.get(sum) + 1);
				}
				else {
					//map中不存在，存入
					map.put(sum, 1);
				}
			}
		}
		//后两个数组元素之和，在map中找是否存在相加为0的情况，同时记录次数
		for (int num3 : nums3) {
			for (int num4 : nums4) {
				sum = num3 + num4;
				if (map.containsKey(0 - sum)){
					//map中有匹配的值,o和的次数加上匹配值的个数
					count += map.get(0 - sum);
				}
			}
		}
		return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
