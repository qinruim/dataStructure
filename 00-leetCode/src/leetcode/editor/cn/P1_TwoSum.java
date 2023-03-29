//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
//
// Related Topics 数组 哈希表 👍 16681 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 两数之和
 * @author mqinrui
 * @date 2023-03-28 17:02:30
 */
public class P1_TwoSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1_TwoSum().new Solution();
	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
//		//暴力  两层循环  枚举数组中的每一个数 x，寻找数组中是否存在 target - x
//		//（有多组和为target的话，返回一组即可）
//		for (int i = 0; i < nums.length; i++) {
//			for (int j = i + 1; j < nums.length; j++) {
//				if (nums[i] + nums[j] == target){
//					return new int[]{i,j};
//				}
//			}
//		}
//		return new int[0];

		//哈希  map存放遍历过的元素（元素值为key，下标作为value）
		//遇到新的数x，去hashmap里面查看是否遍历过，是否存在匹配的 target - x
		int[] result = new int[2];
		if (nums == null || nums.length == 0){
			return result;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			//遍历数组，并在map中寻找是否存在匹配的值
			int temp = target - nums[i];
			if (map.containsKey(temp)){
				//map中有匹配的值时，存入匹配值的下标和当前值的下标
				result[0] = map.get(temp);
				result[1] = i;
				break;
			}
			//map没有匹配的值，将当前遍历到的值放入map中
			map.put(nums[i],i);
		}
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
