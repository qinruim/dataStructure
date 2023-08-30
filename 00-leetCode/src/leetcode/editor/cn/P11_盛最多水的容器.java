package leetcode.editor.cn;

/**
 * 盛最多水的容器
 * container-with-most-water
 * @author mqinrui
 * @date 2023-08-30 15:21:21
 */
class P11_ContainerWithMostWater{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P11_ContainerWithMostWater().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
		int n = height.length;
		int left = 0,right = n - 1;

		int res = 0;
		while (left < right){
//			res = Math.max(res,(right - left) * Math.min())
			if (height[left] > height[right]){
				res = Math.max(res,(right - left) * height[right]);
				right--;
			}else {
				res = Math.max(res,(right - left) * height[left]);
				left++;
			}
		}

		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
