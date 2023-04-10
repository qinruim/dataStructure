//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1521 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 前 K 个高频元素
 * @author mqinrui
 * @date 2023-04-10 21:06:07
 */
public class P347_TopKFrequentElements{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P347_TopKFrequentElements().new Solution();
	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
		/**
		 * 一个map
		 * 遍历一个元素，作为key，map看有没有，有则value+1，无则添加，value=1
		 * 将map元素按照value排序
		 *
		 * 不必全部排序，用大顶堆/小顶堆去遍历map，维护k个元素，遍历结束后就是要的结果
		 * 要用小顶堆，因为要统计最大前k个元素，只有小顶堆每次将最小的元素弹出，最后小顶堆里积累的才是前k个最大元素。
		 * 优先级队列（优先级队列内部元素是自动依照元素的权值排列）
		 */
		Map<Integer,Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num,map.getOrDefault(num,0) + 1);
		}
		//在优先队列中存储k-v(num,cnt),cnt表示元素值num在数组中的出现次数
		//出现次数按从队头到队尾的顺序是从小到大排,出现次数最低的在队头(相当于小顶堆)
		PriorityQueue<int[]> pq = new PriorityQueue<>();



		return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
