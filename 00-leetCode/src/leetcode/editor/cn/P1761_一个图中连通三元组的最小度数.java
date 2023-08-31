package leetcode.editor.cn;

/**
 * 一个图中连通三元组的最小度数
 * @author qr
 * @date 2023-08-31 23:01:14
 */
class P1761_MinimumDegreeOfAConnectedTrioInAGraph{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1761_MinimumDegreeOfAConnectedTrioInAGraph().new Solution();
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	 * 枚举每一个三元组 并计算其度数
	 * @param n
	 * @param edges
	 * @return
	 */
    public int minTrioDegree(int n, int[][] edges) {
		//枚举三元组：用邻接矩阵graph存储图 graph[i][j]=1表示i、j节点之间有边
		//那么 [i][j]、[j][k]、[i][k] 都为1说明这是一个三元组

		//并预处理每个节点的度数 degree[]
		//三元组的 度数 ：  degree[i] + degree[j] + degree[k] - 6
		int[][] graph = new int[n + 1][n + 1];
		int[] degree = new int[n + 1];

		for (int[] edge : edges) {
			int i = edge[0];
			int j = edge[1];
			graph[i][j] = graph[j][i] = 1;
			degree[i]++;
			degree[j]++;
		}

		//可以只枚举 i<j<k 的情况
		int res = Integer.MAX_VALUE;
		boolean flag = false;

		for (int i = 1; i < n + 1; i++) {
			for (int j = i + 1; j < n + 1; j++) {
				if (graph[i][j] == 1) {
					for (int k = j + 1; k < n + 1; k++) {
						if (graph[i][k] == 1 && graph[j][k] == 1){
							//找到一个三元组
							flag = true;
							int d = degree[i] + degree[j] + degree[k] - 6;
							res = Math.min(res,d);
						}

					}
				}

			}
		}

		return flag ? res : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
