<p>给定一个数组，它的第<em> </em><code>i</code> 个元素是一支给定的股票在第 <code>i</code><em> </em>天的价格。</p>

<p>设计一个算法来计算你所能获取的最大利润。你最多可以完成&nbsp;<strong>两笔&nbsp;</strong>交易。</p>

<p><strong>注意：</strong>你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入：</strong>prices = [3,3,5,0,0,3,1,4]
<strong>输出：</strong>6
<strong>解释：</strong>在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
&nbsp;    随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>prices = [1,2,3,4,5]
<strong>输出：</strong>4
<strong>解释：</strong>在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。 &nbsp; 
&nbsp;    注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。 &nbsp; 
&nbsp;    因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>prices = [7,6,4,3,1] 
<strong>输出：</strong>0 
<strong>解释：</strong>在这个情况下, 没有交易完成, 所以最大利润为 0。</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>prices = [1]
<strong>输出：</strong>0
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;=&nbsp;prices.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>0 &lt;=&nbsp;prices[i] &lt;=&nbsp;10<sup>5</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>

<div>👍 1493, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**



<p><strong><a href="https://labuladong.github.io/article/slug.html?slug=best-time-to-buy-and-sell-stock-iii" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

**提示：股票系列问题有共通性，但难度较大，初次接触此类问题的话很难看懂下述思路，建议直接看 [详细题解](https://labuladong.github.io/article/fname.html?fname=团灭股票问题)。**

股票系列问题状态定义：

```python
dp[i][k][0 or 1]
0 <= i <= n - 1, 1 <= k <= K
n 为天数，大 K 为交易数的上限，0 和 1 代表是否持有股票。
```

股票系列问题通用状态转移方程和 base case：

```python
状态转移方程：
dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])

base case：
dp[-1][...][0] = dp[...][0][0] = 0
dp[-1][...][1] = dp[...][0][1] = -infinity
```

之前的几道股票问题，状态 `k` 都被化简掉了，这道题无法化简 `k` 的限制，所以就要加一层 for 循环穷举这个状态。

详细思路解析和空间复杂度优化的解法见详细题解。

**详细题解：[一个方法团灭 LeetCode 股票买卖问题](https://labuladong.github.io/article/fname.html?fname=团灭股票问题)**

**标签：[三维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122017695998050308)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

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
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int max_k = 2, n = prices.size();
        int dp[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    // 处理 base case
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        // 穷举了 n × max_k × 2 个状态，正确。
        return dp[n - 1][max_k][0];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_k = 2
        n = len(prices)
        dp = [[[0 for _ in range(2)] for _ in range(max_k + 1)] for _ in range(n)]
        for i in range(n):
            for k in range(max_k, 0, -1):
                if i - 1 == -1:
                    # 处理 base case
                    dp[i][k][0] = 0
                    dp[i][k][1] = -prices[i]
                    continue
                dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
                dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
        # 穷举了 n × max_k × 2 个状态，正确。
        return dp[n - 1][max_k][0]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int maxProfit(int[] prices) {
        int max_k = 2, n = prices.length;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    // 处理 base case
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        // 穷举了 n × max_k × 2 个状态，正确。
        return dp[n - 1][max_k][0];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func maxProfit(prices []int) int {
    max_k, n := 2, len(prices)
    dp := make([][][]int, n)
    for i := range dp {
        dp[i] = make([][]int, max_k+1)
        for j := range dp[i] {
            dp[i][j] = make([]int, 2)
        }
    }
    for i := 0; i < n; i++ {
        for k := max_k; k >= 1; k-- {
            if i-1 == -1 {
                // 处理 base case
                dp[i][k][0] = 0
                dp[i][k][1] = -prices[i]
                continue
            }
            dp[i][k][0] = func() int {
                if dp[i-1][k][0] > dp[i-1][k][1]+prices[i] {
                    return dp[i-1][k][0]
                }
                return dp[i-1][k][1] + prices[i]
            }()
            dp[i][k][1] = func() int {
                if dp[i-1][k][1] > dp[i-1][k-1][0]-prices[i] {
                    return dp[i-1][k][1]
                }
                return dp[i-1][k-1][0] - prices[i]
            }()
        }
    }
    // 穷举了 n × max_k × 2 个状态，正确。
    return dp[n-1][max_k][0]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var maxProfit = function(prices) {
    let max_k = 2, n = prices.length;
    let dp = Array(n).fill().map(() => Array(max_k + 1).fill().map(() => Array(2).fill(0)));
    for (let i = 0; i < n; i++) {
        for (let k = max_k; k >= 1; k--) {
            if (i - 1 == -1) {
                // 处理 base case
                dp[i][k][0] = 0;
                dp[i][k][1] = -prices[i];
                continue;
            }
            dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
            dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
        }
    }
    // 穷举了 n × max_k × 2 个状态，正确。
    return dp[n - 1][max_k][0];
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_best-time-to-buy-and-sell-stock-iii" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_best-time-to-buy-and-sell-stock-iii"></div></div>
</details><hr /><br />

**类似题目**：
  - [121. 买卖股票的最佳时机 🟢](/problems/best-time-to-buy-and-sell-stock)
  - [122. 买卖股票的最佳时机 II 🟠](/problems/best-time-to-buy-and-sell-stock-ii)
  - [188. 买卖股票的最佳时机 IV 🔴](/problems/best-time-to-buy-and-sell-stock-iv)
  - [309. 最佳买卖股票时机含冷冻期 🟠](/problems/best-time-to-buy-and-sell-stock-with-cooldown)
  - [714. 买卖股票的最佳时机含手续费 🟠](/problems/best-time-to-buy-and-sell-stock-with-transaction-fee)
  - [剑指 Offer 63. 股票的最大利润 🟠](/problems/gu-piao-de-zui-da-li-run-lcof)

</details>
</div>

