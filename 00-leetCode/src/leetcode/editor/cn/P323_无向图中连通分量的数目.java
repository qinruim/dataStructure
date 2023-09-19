package leetcode.editor.cn;

/**
 * 无向图中连通分量的数目
 * number-of-connected-components-in-an-undirected-graph
 * @author mqinrui
 * @date 2023-09-19 16:18:07
 */
class P323_NumberOfConnectedComponentsInAnUndirectedGraph{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P323_NumberOfConnectedComponentsInAnUndirectedGraph().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countComponents(int n, int[][] edges) {
		//用并查集算法
		UF uf = new UF(n);
		//将该连的节点连起来
		for (int[] edge : edges) {
			uf.union(edge[0],edge[1]);
		}
		//返回连通分量个数
		return uf.count();
    }

	private class UF {
		private int count; //连通分量个数
		private int[] parent; //存储每个节点的父节点
		public UF(int n) {
			this.count = n;
			parent = new int[n];
			//初始化父节点指向自己
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
		}

		public void union(int x,int y){
			//连通两个节点
			int rootX = findRoot(x);
			int rootY = findRoot(y);

			if (rootX == rootY)return;

			parent[rootX] = rootY;
			count--;
		}

		private int findRoot(int x) {
			//获取根节点
			//递归将当前节点接到根节点
			if (parent[x] != x){
				//将当前节点 x 的父节点（parent[x]）更新为 x 所属集合的根节点。
				//为了找到根节点，它会继续递归调用 findRoot 方法，直到找到根节点为止
				parent[x] = findRoot(parent[x]);
			}
			return parent[x];
		}

		public int count(){
			return count;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)


}
