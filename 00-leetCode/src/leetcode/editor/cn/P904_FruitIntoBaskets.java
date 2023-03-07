package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 水果成篮
 * @author qr
 * @date 2023-03-07 21:16:27
 */
public class P904_FruitIntoBaskets{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P904_FruitIntoBaskets().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * 题目翻译成人话就是 ：
	 * 找至多包含两种元素的最长子串，返回其长度
	 *
	 * 滑动窗口计数问题
	 * start,end表示滑动窗口左右界，用hashMap count存储这个窗口内的数以及出现的次数
	 * key=fruit[end],value=count.get(fruits[right])+1）)
	 * 如果哈希表value大于2，那就移动left将fruits[left]从哈希表中移除，直到满足要求为止。
	 * 如果fruits[left]在哈希表中出现的次数减少为0，那么要将其key值移出，此时哈希表大小=2，继续循环。
	 */
	class Solution {
    public int totalFruit(int[] fruits) {
		int len = fruits.length;
		int start = 0;
		int result = 0;
		HashMap<Integer, Integer> count = new HashMap<>();
		for (int end = 0; end < len; end++) {
			//getOrDefault() 获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值
			//key相同，相当于覆盖更新value
			count.put(fruits[end],count.getOrDefault(fruits[end],0) + 1);
			//更新滑动窗口
			while (count.size() >  2){//count.size大于2，左移start，并减少左边元素记录次数直至满足要求
				count.put(fruits[start],count.getOrDefault(fruits[start],0) - 1);
				if(count.get(fruits[start]) == 0){//如果fruits[left]在哈希表中出现的次数减少为0，那么要将其key值移除，此时哈希表大小=2，继续外层循环
					count.remove(fruits[start]);
				}
				start++;
			}
			result = Math.max(result,end -start + 1);
		}
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
