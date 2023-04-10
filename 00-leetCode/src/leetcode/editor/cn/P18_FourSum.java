//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 1562 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * @author mqinrui
 * @date 2023-04-10 16:10:13
 */
public class P18_FourSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P18_FourSum().new Solution();
	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
		//在三数和基础上加一个for
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);

		for (int k = 0; k < nums.length; k++) {
			//剪枝，注意target可能为负数，不能沿用三数和的方式
			if (nums[k] > target && nums[k] > 0 && target > 0){
				break;// 这里使用break，统一通过最后的return返回
			}
			//对nums[k]去重
			if (k > 0 && nums[k] == nums[k - 1]){
				continue;
			}
			//将 nums[k]+nums[i] 看作一个整体，这一层循环就是三数之和的逻辑
			for (int i = k + 1; i < nums.length; i++) {
				int a = nums[k] + nums[i];
				//二级剪枝
				if (a > target && a > 0 && target > 0){
					break;
				}
				//二级去重
				if (i > k + 1 && nums[i] == nums[i - 1]){
					continue;
				}

				int left = i + 1;
				int right = nums.length - 1;
				while (right > left){
					// nums[k] + nums[i] + nums[left] + nums[right] > target int会溢出
					long sum =(long) a + nums[left] + nums[right];
					if (sum > target){
						right--;
					}else if (sum < target){
						left++;
					}else {
						result.add(Arrays.asList(nums[k],nums[i],nums[left],nums[right]));
						//去重
						while (right > left && nums[right] == nums[right - 1]){right--;}
						while (right > left && nums[left] == nums[left + 1]){left++;}

						right--;
						left++;
					}
				}


			}
		}

		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
