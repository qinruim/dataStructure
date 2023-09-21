package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最低成本联通所有城市
 * @author qr
 * @date 2023-09-21 23:43:00
 */
class P1135_ConnectingCitiesWithMinimumCost{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1135_ConnectingCitiesWithMinimumCost().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumCost(int n, int[][] connections) {
		// 城市编号为 1...n，所以初始化大小为 n + 1
		UF uf = new UF(n + 1);
		//连通所有城市的最小成本即是最小生成树的权重之和
		//按照权重从小到大排序
		Arrays.sort(connections,(a,b) -> (a[2] - b[2]));
		int mst = 0; //最小生成树的权重和
		for (int[] edge : connections) {
			int x = edge[0];
			int y = edge[1];
			int weight = edge[2];

			if (uf.connected(x,y)) continue;
			//不成环  加入mst
			mst += weight;
			uf.union(x,y);
		}
		// 保证所有节点都被连通
		// 按理说 uf.count() == 1 说明所有节点被连通
		// 但因为节点 0 没有被使用，所以 0 会额外占用一个连通分量
		return uf.getCount() == 2 ? mst : -1;
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
