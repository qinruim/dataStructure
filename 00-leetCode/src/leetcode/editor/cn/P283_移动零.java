package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 移动零
 * move-zeroes
 * @author mqinrui
 * @date 2023-08-30 10:55:30
 */
class P283_MoveZeroes{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P283_MoveZeroes().new Solution();
		  int[] nums = {0,1,0,3,12};
		  solution.moveZeroes(nums);
		 System.out.println(Arrays.toString(nums));
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
		//将数组中的0全部删除 后面的再全部赋0即可
		int slow = 0,fast = 0;
		while (fast < nums.length){
			//fast遇到0跳过  遇到不为0的就复制给slow slow++
			if (nums[fast] != 0){
				nums[slow++] = nums[fast];
			}
			fast++;
		}
		///再将slow及之后的赋0
		for (int i = slow; i < nums.length; i++) {
			nums[i] = 0;
		}
    }



}
//leetcode submit region end(Prohibit modification and deletion)


}
