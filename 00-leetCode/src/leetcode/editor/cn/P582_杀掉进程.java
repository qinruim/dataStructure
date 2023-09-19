package leetcode.editor.cn;

import java.util.List;

/**
 * 杀掉进程
 * kill-process
 * @author mqinrui
 * @date 2023-09-19 17:19:09
 */
class P582_KillProcess{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P582_KillProcess().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		UF uf = new UF(pid.size());

		for (int i = 0; i < ppid.size(); i++) {
			int parent = ppid.get(i);
			if (parent == 0){continue;}
			uf.union(parent,pid.get(i));
		}





		return null;

    }

	class UF{
		private int count;
		private int[] parent;
		public UF(int n){
			this.count = n;
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
		}

		public boolean connected(int x,int y){
			return findRoot(x) == findRoot(y);
		}

		public void union(int x,int y){
			int rootX = findRoot(x);
			int rootY = findRoot(y);
			if (rootX == rootY)return;
			parent[rootX] = rootY;
			count--;
		}
		public int getCount(){
			return count;
		}
		private int findRoot(int x) {
			if (x != parent[x]){
				parent[x] = findRoot(parent[x]);
			}
			return parent[x];
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
