package leetcode.editor.cn;

/**
 * 接雨水
 * trapping-rain-water
 * @author mqinrui
 * @date 2023-08-30 14:51:30
 */
class P42_TrappingRainWater{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P42_TrappingRainWater().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int trap(int[] height) {
		//1.暴力解 加memo优化
//		return method1(height);

		//2.双指针 边走边算 降低空间复杂度
		return method2(height);


    }

	/**
	 * 双指针
	 * @param height
	 * @return
	 */
	private int method2(int[] height) {
		int n = height.length;
		int left = 0,right = n - 1;


		int lMax = 0;
		int rMax = 0;

		int res = 0;
		while (left < right){
			//[0,...left]中最高的柱子高度 和 [right,...end]最高的
			lMax = Math.max(lMax,height[left]);
			rMax = Math.max(rMax,height[right]);

			if (lMax < rMax){
				res += lMax - height[left];
				left++;
			}else {
				res += rMax - height[right];
				right--;
			}
		}

		return res;
	}

	/**
	 * 暴力解 ： 每个位置能装的水
	 * 	  water[i] = min(
	 * 	             # 左边最高的柱子
	 * 	             max(height[0..i]),
	 * 	             # 右边最高的柱子
	 * 	             max(height[i..end])
	 * 	          ) - height[i]
	 *
	 * @param height
	 * @return
	 */
	private int method1(int[] height) {
		int n = height.length;
		//预计算每个位置左侧最高和右侧最高的柱子(含每个柱子本身)（memo 避免每次都算）
		int[] lMax = new int[n];
		int[] rMax = new int[n];

		lMax[0] = height[0];
		for (int i = 1; i < n; i++) {
			lMax[i] = Math.max(lMax[i - 1],height[i]);
		}
		rMax[n - 1] = height[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rMax[i] = Math.max(rMax[i + 1],height[i]);
		}

		//获得这两个数组之后  遍历柱子即可
		int res = 0;
		for (int i = 0; i < n; i++) {
			int min = Math.min(lMax[i],rMax[i]);
			if (min > height[i]){
				res += min - height[i];
			}
//			res += Math.min(lMax[i],rMax[i]) - height[i];
		}

		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
