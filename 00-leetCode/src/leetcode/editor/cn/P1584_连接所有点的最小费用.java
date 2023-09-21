package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 连接所有点的最小费用
 *
 * @author qr
 * @date 2023-09-21 23:56:37
 */
class P1584_MinCostToConnectAllPoints {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1584_MinCostToConnectAllPoints().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostConnectPoints(int[][] points) {
            int n = points.length;
            UF uf = new UF(n);

			List<int[]> edges = new ArrayList<>();
			//构造所有边及权重
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
					int xi = points[i][0],yi = points[i][1];
					int xj = points[j][0],yj = points[j][1];
                    int cost = Math.abs(xi - xj) + Math.abs(yi - yj);
					edges.add(new int[]{i,j,cost});
                }
            }
			//按权重从小到大排序
			edges.sort((a,b) -> {return a[2] - b[2];});

			//开始Kruskal算法
			int sumCost = 0;
			for (int[] edge : edges) {
				int x = edge[0];
				int y = edge[1];
				int cost = edge[2];
				if (uf.connected(x,y))continue;
				uf.union(x,y);
				sumCost += cost;
			}


			return sumCost;

        }


        class UF {
            private int count;
            private int[] parent;

            public UF(int n) {
                this.count = n;
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public void union(int x, int y) {
                int rootX = findRoot(x);
                int rootY = findRoot(y);
                if (rootY == rootX) return;
                parent[rootX] = parent[rootY];
                count--;
            }

            public int findRoot(int x) {
                if (x != parent[x]) {
                    parent[x] = findRoot(parent[x]);
                }
                return parent[x];
            }

            public int getCount() {
                return count;
            }

            public boolean connected(int x, int y) {
                return findRoot(x) == findRoot(y);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
