package leetcode.editor.cn;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * find-first-and-last-position-of-element-in-sorted-array
 * @author mqinrui
 * @date 2023-09-06 09:17:28
 */
class P34_FindFirstAndLastPositionOfElementInSortedArray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution{
    public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0){
			return new int[]{-1,-1};
		}
		if (nums.length == 1 && nums[0] == target){
			return new int[]{0,0};
		}

		int[] res = new int[2];
		int left = 0;
		int right = nums.length;
		//找左边界
		while (left < right){
			int mid = left + (right - left) / 2;
			if (nums[mid] == target){
				right = mid;
			}else if (nums[mid] < target){
				left = mid + 1;
			}else if (nums[mid] > target){
				right = mid;
			}
		}

		if (left < 0 || left >= nums.length){
			return new int[]{-1,-1};
		}

		if (nums[left] == target){
			res[0] = left;
		}else {
			return new int[]{-1,-1};
		}
		//找右边界
		left = 0;
		right = nums.length;
		while (left < right){
			int mid = left + (right - left) / 2;
			if (nums[mid] == target){
				left = mid + 1;
			}else if (nums[mid] < target){
				left = mid + 1;
			}else if (nums[mid] > target){
				right = mid;
			}
		}

		if (left - 1 < 0 || left - 1 >= nums.length){
			return new int[]{-1,-1};
		}

		if (nums[left - 1] == target){
			res[1] = left - 1;
		}else {
			return new int[]{-1,-1};
		}


		return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
