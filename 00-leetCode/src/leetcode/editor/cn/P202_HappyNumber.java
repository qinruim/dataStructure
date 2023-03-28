//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」 定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果这个过程 结果为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 19
//输出：true
//解释：
//1² + 9² = 82
//8² + 2² = 68
//6² + 8² = 100
//1² + 0² + 0² = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// Related Topics 哈希表 数学 双指针 👍 1255 👎 0


package leetcode.editor.cn;

import java.util.HashSet;

/**
 * 快乐数
 * @author mqinrui
 * @date 2023-03-28 16:43:39
 */
public class P202_HappyNumber{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P202_HappyNumber().new Solution();
	 }
	 
//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
		//用不重复集合记录每一轮更新后的n值。（如果出现重复，说明陷入无限循环，立刻结束）
		HashSet<Integer> record = new HashSet<>();
		//n不为1,且 record中不包含更新的n，继续循环
		while (n != 1 && !record.contains(n)){
			record.add(n);
			//更新 n
			n = getNewNumber(n);
		}
		return n == 1;
    }

	//更新n
	private int getNewNumber(int n) {
		int result = 0;
		//只剩一位时 除以10 会得到0
		while (n > 0){
			//计算最后一位的平方
			int temp = n % 10;
			result += temp * temp;
			//去掉最后一位
			n /= 10;
		}
		return result;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
