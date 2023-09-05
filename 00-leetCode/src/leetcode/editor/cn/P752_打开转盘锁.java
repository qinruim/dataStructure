package leetcode.editor.cn;

import sun.awt.X11.Depth;

import java.util.*;

/**
 * 打开转盘锁
 * open-the-lock
 * @author mqinrui
 * @date 2023-09-05 14:48:34
 */
class P752_OpenTheLock{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P752_OpenTheLock().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int openLock(String[] deadends, String target) {
		//先不考虑deadrnds的限制 穷举所有密码 BFS 8叉树
		//再考虑限制条件即可
		//由于先往上拨 进入一个循环后再往下拨会重复  算法超时 采取措施 visited

		Queue<String> queue = new LinkedList<>();
		Set<String> deads = new HashSet<>();
		for (String deadend : deadends) {
			deads.add(deadend);
		}
		Set<String> visited = new HashSet<>();

		queue.offer("0000");
		visited.add("0000");

		int depth = 0;

		while (!queue.isEmpty()){
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();

				//终点
				if (deads.contains(cur)){
					continue;
				}
				if (cur.equals(target)){
					return depth;
				}

				//将cur的相邻节点加入队列
				for (int j = 0; j < 4; j++) {
					String up = plusOne(cur, j);
					String down = minusOne(cur, j);
					if (!visited.contains(up)){
						queue.offer(up);
						visited.add(up);
					}
					if (!visited.contains(down)){
						queue.offer(down);
						visited.add(down);
					}
				}


			}
			//一层遍历玩 进入下一层 才+1
			depth++;
		}
		//没找到
		return -1;
    }

	/**
	 * 将字符串对应索引位置 -1 并返回
	 * @param cur
	 * @param i
	 * @return
	 */
	private String minusOne(String cur, int i) {
		char[] chars = cur.toCharArray();
		if (chars[i] == '0'){
			chars[i] = '9';
		}else {
			chars[i]--;
		}
		//toString() 方法将返回字符数组的哈希码表示，而不是数组中的实际字符内容
//		return chars.toString();
		return new String(chars);
	}

	/**
	 * 将字符串对应索引位置 +1 并返回
	 * @param s
	 * @param j
	 * @return
	 */
	private String plusOne(String s, int j) {
		char[] ch = s.toCharArray();
		if (ch[j] == '9')
			ch[j] = '0';
		else
			ch[j]++;
		return new String(ch);
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
