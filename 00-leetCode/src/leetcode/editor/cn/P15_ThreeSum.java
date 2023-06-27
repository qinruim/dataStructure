//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 5841 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * @author mqinrui
 * @date 2023-04-10 11:21:25
 */
public class P15_ThreeSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P15_ThreeSum().new Solution();
	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		//哈希法去重比较复杂，建议双指针法
		//先把数组排好序
		//a+b+c=0，一个for循环，遍历的i对应数为a，两个指针left，right分别指向除a以外的头和尾
		//因为已经排好序，当三者相加>0，左移right指针即可；反之右移left指针
		//注意abc都要去重
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			//排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
			if (nums[i] > 0){
				return result;
			}

			//a去重 不能用nums[i] == nums[i + 1]，这相当于判断三元组内部有无重复元素
			if (i > 0 && nums[i] == nums[i - 1]){
				continue;
			}

			//确定一个数之后  相当于两数和，newTarget=target-a
			int left = i + 1;
			int right = nums.length - 1;

			while (right > left){
				int sum = nums[i] + nums[left] + nums[right];
				if (sum > 0){
					right--;
				}else if (sum < 0){
					left++;
				}else {
					result.add(Arrays.asList(nums[i],nums[left],nums[right]));
					//去重逻辑应该放在找到一个三元组之后，对b和c去重
					//当right或left有重复，就持续左移或者右移，直至没有重复为止
					while (right > left && nums[right] == nums[right - 1]){
						right--;
					}
					while (right > left && nums[left] == nums[left + 1]){
						left++;
					}

					//找到一个三元组之后再移动指针
					left++;
					right--;
				}

			}
		}
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
