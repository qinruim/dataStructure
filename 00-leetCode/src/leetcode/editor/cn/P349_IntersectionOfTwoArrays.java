//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 738 👎 0


package leetcode.editor.cn;

import java.util.HashSet;

/**
 * 两个数组的交集
 * @author mqinrui
 * @date 2023-03-28 16:03:46
 */
public class P349_IntersectionOfTwoArrays{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P349_IntersectionOfTwoArrays().new Solution();
	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
//		//法一：暴力 遍历一个数组 嵌套循环遍历另一个数组  有相同元素放入一个集合
//		HashSet<Integer> set = new HashSet<>();  //set不重复（题目要求去重 ）
//		for (int i = 0; i < nums1.length; i++) {
//			for (int j = 0; j < nums2.length; j++) {
//				if (nums1[i] == nums2[j]){
//					set.add(nums1[i]);
//				}
//			}
//		}
//		return set.stream().mapToInt(Integer::intValue).toArray();

		//法二:  处理nums1 转变为hash表   再遍历nums2,查看nums1里是否出现过  出现过就存入一个result集合
		HashSet<Integer> nums1Set = new HashSet<>();
		HashSet<Integer> result = new HashSet<>();
		//数组1转为hashSet
		for (int num1 : nums1) {
			nums1Set.add(num1);
		}
		//遍历nums2,查看nums1里是否出现过,出现过就存入一个result集合
		for (int num2 : nums2) {
			if (nums1Set.contains(num2)){
				result.add(num2);
			}
		}
		//stream将结果集合转为数组(或者遍历集合，放到数组)
		return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
