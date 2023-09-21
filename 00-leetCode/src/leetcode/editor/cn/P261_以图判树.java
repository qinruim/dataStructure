package leetcode.editor.cn;

/**
 * 以图判树
 * @author qr
 * @date 2023-09-21 23:08:14
 */
class P261_GraphValidTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P261_GraphValidTree().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validTree(int n, int[][] edges) {
		UF uf = new UF(n);
		for (int[] edge : edges) {
			//不成环就连起来 成环就返回false
			int x = edge[0];
			int y = edge[1];
			if (uf.connected(x,y)){
				return false;
			}
			uf.union(x,y);
		}

		//连接完之后 如果连通分量个数为1  说明ok
		return uf.getCount() == 1;
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

		public void union(int x,int y){
			int rootX = findRoot(x);
			int rootY = findRoot(y);
			if (rootY == rootX)return;
			parent[rootX] = parent[rootY];
			count--;
		}

		public int findRoot(int x){
			if (x != parent[x]){
				parent[x] = findRoot(parent[x]);
			}
			return parent[x];
		}

		public int getCount(){
			return count;
		}

		public boolean connected(int x,int y){
			return findRoot(x) == findRoot(y);
		}
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}
