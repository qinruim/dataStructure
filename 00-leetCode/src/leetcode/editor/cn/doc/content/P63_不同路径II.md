<p>一个机器人位于一个
 <meta charset="UTF-8" />&nbsp;<code>m x n</code>&nbsp;网格的左上角 （起始点在下图中标记为 “Start” ）。</p>

<p>机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。</p>

<p>现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？</p>

<p>网格中的障碍物和空位置分别用 <code>1</code> 和 <code>0</code> 来表示。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/robot1.jpg" /> 
<pre>
<strong>输入：</strong>obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
<strong>输出：</strong>2
<strong>解释：</strong>3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 <span><code>2</code></span> 条不同的路径：
1. 向右 -&gt; 向右 -&gt; 向下 -&gt; 向下
2. 向下 -&gt; 向下 -&gt; 向右 -&gt; 向右
</pre>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/robot2.jpg" /> 
<pre>
<strong>输入：</strong>obstacleGrid = [[0,1],[0,0]]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>m ==&nbsp;obstacleGrid.length</code></li> 
 <li><code>n ==&nbsp;obstacleGrid[i].length</code></li> 
 <li><code>1 &lt;= m, n &lt;= 100</code></li> 
 <li><code>obstacleGrid[i][j]</code> 为 <code>0</code> 或 <code>1</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划 | 矩阵</details><br>

<div>👍 1107, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

动态规划问题层层优化的通用步骤：

1、根据 [动态规划核心套路](https://labuladong.github.io/article/fname.html?fname=动态规划详解进阶)，思考如何分解问题（状态转移方程），明确函数定义，写出暴力递归解；然后用 `memo` 备忘录消除重叠子问题，并根据 [这篇文章](https://labuladong.github.io/article/fname.html?fname=备忘录等基础) 确定 base case 的初始值。

2、（可选）根据 [动态规划核心套路](https://labuladong.github.io/article/fname.html?fname=动态规划详解进阶) 将自顶向下的递归解法改为自底向上的迭代解法，根据 [这篇文章](https://labuladong.github.io/article/fname.html?fname=最优子结构) 确定 `dp` 数组的迭代方向。

3、（可选）根据 [这篇文章](https://labuladong.github.io/article/fname.html?fname=状态压缩技巧) 尝试对多维 `dp` 数组进行降维打击，优化空间复杂度。

这道题分解问题规模的关键是：

到达 `(i, j)` 的路径条数等于到达 `(i-1, j)` 和到达 `(i, j-1)` 的路径条数之和。

那么 `dp` 函数的定义就是：

从 `grid[0][0]` 出发到达 `grid[i][j]` 的路径条数为 `dp(grid, i, j)`。

然后走流程，一步步优化，我把所有步骤都写在解法代码中了。

**标签：[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

// 第一步：自顶向下带备忘录的递归
class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();
        memo = vector<vector<int>>(m, vector<int>(n, 0));
        return dp(obstacleGrid, m - 1, n - 1);
    }

    // 备忘录
    vector<vector<int>> memo;

    // 定义：从 grid[0][0] 出发到达 grid[i][j] 的路径条数为 dp(grid, i, j)
    int dp(vector<vector<int>>& grid, int i, int j) {
        int m = grid.size(), n = grid[0].size();
        // base case
        if (i < 0 || i >= m || j < 0 || j >= n
                || grid[i][j] == 1) {
            // 数组越界或者遇到阻碍
            return 0;
        }
        if (i == 0 && j == 0) {
            // 起点到起点的路径条数就是 1
            return 1;
        }
        if (memo[i][j] > 0) {
            // 避免冗余计算
            return memo[i][j];
        }
        // 状态转移方程：
        // 到达 grid[i][j] 的路径条数等于
        // 到达 grid[i-1][j] 的路径条数加上到达 grid[i][j-1] 的路径条数
        int left = dp(grid, i, j - 1);
        int upper = dp(grid, i - 1, j);
        int res = left + upper;
        // 存储备忘录
        memo[i][j] = res;
        return res;
    }
};

// 第二步：自底向上迭代的动态规划
class Solution2 {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();
        // 数组索引偏移一位，dp[0][..] dp[..][0] 代表 obstacleGrid 之外
        // 定义：到达 obstacleGrid[i][j] 的路径条数为 dp[i-1][j-1]
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
        // base case：如果没有障碍物，起点到起点的路径条数就是 1
        dp[1][1] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    // 跳过 base case
                    continue;
                }
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    // 跳过障碍物的格子
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // 返回到达 obstacleGrid[m-1][n-1] 的路径数量
        return dp[m][n];
    }
};

// 第三步：优化二维 dp 数组为一维 dp 数组
class Solution3 {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();
        // 根据二维 dp 数组优化为一维 dp 数组
        vector<int> dp(n + 1, 0);
        dp[1] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    // 跳过 base case
                    continue;
                }
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    // 跳过障碍物的格子
                    dp[j] = 0;
                    continue;
                }
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        // 返回到达 obstacleGrid[m-1][n-1] 的路径数量
        return dp[n];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

# 第一步：自顶向下带备忘录的递归
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        # 备忘录
        memo = [[0] * n for _ in range(m)]
        return self.dp(obstacleGrid, m - 1, n - 1, memo)

    # 定义：从 grid[0][0] 出发到达 grid[i][j] 的路径条数为 dp(grid, i, j)
    def dp(self, grid, i, j, memo):
        m, n = len(grid), len(grid[0])
        # base case
        if i < 0 or i >= m or j < 0 or j >= n or grid[i][j] == 1:
            # 数组越界或者遇到阻碍
            return 0
        if i == 0 and j == 0:
            # 起点到起点的路径条数就是 1
            return 1
        if memo[i][j] > 0:
            # 避免冗余计算
            return memo[i][j]
        # 状态转移方程：
        # 到达 grid[i][j] 的路径条数等于
        # 到达 grid[i-1][j] 的路径条数加上到达 grid[i][j-1] 的路径条数
        left = self.dp(grid, i, j - 1, memo)
        upper = self.dp(grid, i - 1, j, memo)
        res = left + upper
        # 存储备忘录
        memo[i][j] = res
        return res


# 第二步：自底向上迭代的动态规划
class Solution2:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        # 数组索引偏移一位，dp[0][..] dp[..][0] 代表 obstacleGrid 之外
        # 定义：到达 obstacleGrid[i][j] 的路径条数为 dp[i-1][j-1]
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        # base case：如果没有障碍物，起点到起点的路径条数就是 1
        dp[1][1] = 1 if obstacleGrid[0][0] == 0 else 0

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if i == 1 and j == 1:
                    # 跳过 base case
                    continue
                if obstacleGrid[i - 1][j - 1] == 1:
                    # 跳过障碍物的格子
                    continue
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        # 返回到达 obstacleGrid[m-1][n-1] 的路径数量
        return dp[m][n]


# 第三步：优化二维 dp 数组为一维 dp 数组
class Solution3:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        # 根据二维 dp 数组优化为一维 dp 数组
        dp = [0] * (n + 1)
        dp[1] = 1 if obstacleGrid[0][0] == 0 else 0

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if i == 1 and j == 1:
                    # 跳过 base case
                    continue
                if obstacleGrid[i - 1][j - 1] == 1:
                    # 跳过障碍物的格子
                    dp[j] = 0
                    continue
                dp[j] = dp[j] + dp[j - 1]
        # 返回到达 obstacleGrid[m-1][n-1] 的路径数量
        return dp[n]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
// 第一步：自顶向下带备忘录的递归
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        memo = new int[m][n];
        return dp(obstacleGrid, m - 1, n - 1);
    }

    // 备忘录
    int[][] memo;

    // 定义：从 grid[0][0] 出发到达 grid[i][j] 的路径条数为 dp(grid, i, j)
    int dp(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        // base case
        if (i < 0 || i >= m || j < 0 || j >= n
                || grid[i][j] == 1) {
            // 数组越界或者遇到阻碍
            return 0;
        }
        if (i == 0 && j == 0) {
            // 起点到起点的路径条数就是 1
            return 1;
        }
        if (memo[i][j] > 0) {
            // 避免冗余计算
            return memo[i][j];
        }
        // 状态转移方程：
        // 到达 grid[i][j] 的路径条数等于
        // 到达 grid[i-1][j] 的路径条数加上到达 grid[i][j-1] 的路径条数
        int left = dp(grid, i, j - 1);
        int upper = dp(grid, i - 1, j);
        int res = left + upper;
        // 存储备忘录
        memo[i][j] = res;
        return res;
    }
}

// 第二步：自底向上迭代的动态规划
class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // 数组索引偏移一位，dp[0][..] dp[..][0] 代表 obstacleGrid 之外
        // 定义：到达 obstacleGrid[i][j] 的路径条数为 dp[i-1][j-1]
        int[][] dp = new int[m + 1][n + 1];
        // base case：如果没有障碍物，起点到起点的路径条数就是 1
        dp[1][1] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    // 跳过 base case
                    continue;
                }
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    // 跳过障碍物的格子
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // 返回到达 obstacleGrid[m-1][n-1] 的路径数量
        return dp[m][n];
    }
}

// 第三步：优化二维 dp 数组为一维 dp 数组
class Solution3 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // 根据二维 dp 数组优化为一维 dp 数组
        int[] dp = new int[n + 1];
        dp[1] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    // 跳过 base case
                    continue;
                }
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    // 跳过障碍物的格子
                    dp[j] = 0;
                    continue;
                }
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        // 返回到达 obstacleGrid[m-1][n-1] 的路径数量
        return dp[n];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// 第一步：自顶向下带备忘录的递归
func uniquePathsWithObstacles(obstacleGrid [][]int) int {
    m := len(obstacleGrid)
    n := len(obstacleGrid[0])
    memo := make([][]int, m)
    for i := 0; i < m; i++ {
        memo[i] = make([]int, n)
    }
    return dp(obstacleGrid, m - 1, n - 1, memo)
}

// 定义：从 grid[0][0] 出发到达 grid[i][j] 的路径条数为 dp(grid, i, j)
func dp(grid [][]int, i int, j int, memo [][]int) int {
    m := len(grid)
    n := len(grid[0])
    // base case
    if i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 1 {
        // 数组越界或者遇到阻碍
        return 0
    }
    if i == 0 && j == 0 {
        // 起点到起点的路径条数就是 1
        return 1
    }
    if memo[i][j] > 0 {
        // 避免冗余计算
        return memo[i][j]
    }
    // 状态转移方程：
    // 到达 grid[i][j] 的路径条数等于
    // 到达 grid[i-1][j] 的路径条数加上到达 grid[i][j-1] 的路径条数
    left := dp(grid, i, j - 1, memo)
    upper := dp(grid, i - 1, j, memo)
    res := left + upper
    // 存储备忘录
    memo[i][j] = res
    return res
}

// 第二步：自底向上迭代的动态规划
func uniquePathsWithObstacles2(obstacleGrid [][]int) int {
    m := len(obstacleGrid)
    n := len(obstacleGrid[0])
    // 数组索引偏移一位，dp[0][..] dp[..][0] 代表 obstacleGrid 之外
    // 定义：到达 obstacleGrid[i][j] 的路径条数为 dp[i-1][j-1]
    dp := make([][]int, m + 1)
    for i := 0; i < m + 1; i++ {
        dp[i] = make([]int, n + 1)
    }
    // base case：如果没有障碍物，起点到起点的路径条数就是 1
    dp[1][1] = 0;
    if obstacleGrid[0][0] == 0 {
        dp[1][1] = 1;
    }
    for i := 1; i <= m; i++ {
        for j := 1; j <= n; j++ {
            if i == 1 && j == 1 {
                // 跳过 base case
                continue
            }
            if obstacleGrid[i - 1][j - 1] == 1 {
                // 跳过障碍物的格子
                continue
            }
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        }
    }
    // 返回到达 obstacleGrid[m-1][n-1] 的路径数量
    return dp[m][n]
}

// 第三步：优化二维 dp 数组为一维 dp 数组
func uniquePathsWithObstacles3(obstacleGrid [][]int) int {
    m := len(obstacleGrid)
    n := len(obstacleGrid[0])
    // 根据二维 dp 数组优化为一维 dp 数组
    dp := make([]int, n + 1)
    dp[1] = 0
    if obstacleGrid[0][0] == 0 {
        dp[1] = 1
    }
    for i := 1; i <= m; i++ {
        for j := 1; j <= n; j++ {
            if i == 1 && j == 1 {
                // 跳过 base case
                continue
            }
            if obstacleGrid[i - 1][j - 1] == 1 {
                // 跳过障碍物的格子
                dp[j] = 0
                continue
            }
            dp[j] = dp[j] + dp[j - 1]
        }
    }
    // 返回到达 obstacleGrid[m-1][n-1] 的路径数量
    return dp[n]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var uniquePathsWithObstacles = function(obstacleGrid) {
    var m = obstacleGrid.length; // 行数
    var n = obstacleGrid[0].length; // 列数
    var memo = new Array(m); // 创建大小为 m 的一维数组
    for (var i = 0; i < m; i++) {
        memo[i] = new Array(n).fill(0); // 依次创建每一行的大小为 n 的二维数组，并初始化为 0
    }
    return dp(obstacleGrid, m - 1, n - 1); // 返回到达目标格子的路径条数

    function dp(grid, i, j) { // 递归函数，记录从起点到达 grid[i][j] 的路径条数
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 1) { // 如果当前格子越界或者是障碍物，返回 0
            return 0;
        }
        if (i == 0 && j == 0) { // 如果到达起点，返回 1
            return 1;
        }
        if (memo[i][j] > 0) { // 如果已经计算过了，直接返回结果
            return memo[i][j];
        }
        var left = dp(grid, i, j - 1); // 从左边走到达 grid[i][j] 的路径条数
        var upper = dp(grid, i - 1, j); // 从上面走到达 grid[i][j] 的路径条数
        var res = left + upper; // 到达 grid[i][j] 的路径条数等于上面和左边的路径条数之和
        memo[i][j] = res; // 存储结果到备忘录中
        return res; // 返回结果
    }
};

var uniquePathsWithObstacles2 = function(obstacleGrid) {
    var m = obstacleGrid.length; // 行数
    var n = obstacleGrid[0].length; // 列数
    var dp = new Array(m + 1).fill(0).map(() => new Array(n + 1).fill(0)); // 创建大小为 (m+1)x(n+1) 的二维数组，初始化为 0，为避免访问 dp[-1][-1] 之类的越界情况开辟了额外的一行一列
    dp[1][1] = obstacleGrid[0][0] == 1 ? 0 : 1; // 如果起点有障碍，路径条数为 0；否则路径条数为 1

    for (var i = 1; i <= m; i++) { // 从上到下逐行遍历
        for (var j = 1; j <= n; j++) { // 从左到右逐列遍历
            if (i == 1 && j == 1) { // 跳过起点
                continue;
            }
            if (obstacleGrid[i - 1][j - 1] == 1) { // 如果当前格子是障碍物，路径条数为 0
                continue;
            }
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // 到达当前格子的路径条数等于到达上一格和左一格的路径条数之和
        }
    }
    return dp[m][n]; // 返回从起点到达目标列的路径条数
};

var uniquePathsWithObstacles3 = function(obstacleGrid) {
    var m = obstacleGrid.length; // 行数
    var n = obstacleGrid[0].length; // 列数
    var dp = new Array(n + 1).fill(0); // 创建大小为 n+1 的一维数组，初始化为 0，因为只需要保存上一行和当前行的状态，所以无需创建二维数组
    dp[1] = obstacleGrid[0][0] == 1 ? 0 : 1; // 如果起点有障碍，路径条数为 0；否则路径条数为 1

    for (var i = 1; i <= m; i++) { // 从上到下逐行遍历
        for (var j = 1; j <= n; j++) { // 从左到右逐列遍历
            if (i == 1 && j == 1) { // 跳过起点
                continue;
            }
            if (obstacleGrid[i - 1][j - 1] == 1) { // 如果当前格子是障碍物，将当前行的状态设置为 0，表示从这里开始无法到达终点
                dp[j] = 0;
                continue;
            }
            dp[j] = dp[j] + dp[j - 1]; // 到达当前格子的路径条数等于到达上一格和左一格的路径条数之和
        }
    }
    return dp[n]; // 返回从起点到达目标列的路径条数
};
```

</div></div>
</div></div>

<details open><summary><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_unique-paths-ii" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_unique-paths-ii"></div></div>
</details><hr /><br />

</details>
</div>



