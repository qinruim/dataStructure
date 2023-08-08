<p><strong>有效 IP 地址</strong> 正好由四个整数（每个整数位于 <code>0</code> 到 <code>255</code> 之间组成，且不能含有前导 <code>0</code>），整数之间用 <code>'.'</code> 分隔。</p>

<ul> 
 <li>例如：<code>"0.1.2.201"</code> 和<code> "192.168.1.1"</code> 是 <strong>有效</strong> IP 地址，但是 <code>"0.011.255.245"</code>、<code>"192.168.1.312"</code> 和 <code>"192.168@1.1"</code> 是 <strong>无效</strong> IP 地址。</li> 
</ul>

<p>给定一个只包含数字的字符串 <code>s</code> ，用以表示一个 IP 地址，返回所有可能的<strong>有效 IP 地址</strong>，这些地址可以通过在 <code>s</code> 中插入&nbsp;<code>'.'</code> 来形成。你 <strong>不能</strong>&nbsp;重新排序或删除 <code>s</code> 中的任何数字。你可以按 <strong>任何</strong> 顺序返回答案。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "25525511135"
<strong>输出：</strong>["255.255.11.135","255.255.111.35"]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "0000"
<strong>输出：</strong>["0.0.0.0"]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "101023"
<strong>输出：</strong>["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 20</code></li> 
 <li><code>s</code> 仅由数字组成</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>字符串 | 回溯</details><br>

<div>👍 1278, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题是经典的回溯算法，完全遵循 [回溯算法详解](https://labuladong.github.io/article/fname.html?fname=回溯算法详解修订版) 中讲到的算法框架。

不过呢，做这道题之前我建议你先做一下 [131. 分割回文串](/problems/palindrome-partitioning)，因为稍微改改 131 题就可以解决这道题了。

131 题的要求是：让你把字符串 `s` 切分成**若干个**合法的**回文串**，返回所有的切分方法。

本题的要求是：让你把字符串 `s` 切分成 **4 个**合法的 **IP 数字**，返回所有的切分方法。

所以我们只要把 131 题的解法稍微改改，重写一个 `isValid` 函数判断合法的 IP 数字，并保证整棵回溯树只有 4 层（即 `track` 中只有 4 个子串）即可。

具体看代码吧，基本逻辑和 131 题一模一样。

**标签：[回溯算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)**

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
    vector<string> res;
    deque<string> track; // 用双端队列实现列表
    vector<string> restoreIpAddresses(string s) {
        backtrack(s, 0);
        return res;
    }
    // 回溯算法框架
    void backtrack(string s, int start) {
        if (start == s.size() && track.size() == 4) {
            // base case，走到叶子节点
            // 即整个 s 被成功分割为合法的四部分，记下答案
            res.push_back(join_track(track));
            return;
        }
        for (int i = start; i < s.size(); i++) {
            if (!is_valid(s, start, i)) {
                // s[start..i] 不是合法的 ip 数字，不能分割
                continue;
            }
            if (track.size() >= 4) {
                // 已经分解成 4 部分了，不能再分解了
                break;
            }
            string str = s.substr(start, i - start + 1);
            track.push_back(str); // 做选择，把 s[start..i] 放入路径列表中
            // 进入回溯树的下一层，继续切分 s[i+1..]
            backtrack(s, i + 1);
            track.pop_back(); // 撤销选择
        }
    }
    // 判断 s[start..end] 是否是一个合法的 ip 段
    bool is_valid(string s, int start, int end) {
        int len = end - start + 1;
        if (len > 3 || len == 0) { // 长度超出了合理范围
            return false;
        }
        if (len > 1 && s[start] == '0') { // 0x、0xx 不是合法情况
            return false;
        }
        if (stoi(s.substr(start, len)) > 255) { // 判断是否越界
            return false;
        }
        return true;
    }
    // 把路径(双端队列)转成字符串
    string join_track(deque<string> track) {
        string res = "";
        for (int i = 0; i < track.size(); i++) {
            res += track[i];
            if (i < track.size() - 1) {
                res += ".";
            }
        }
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def __init__(self):
        self.res = []
        self.track = []

    def restoreIpAddresses(self, s: str) -> List[str]:
        self.backtrack(s, 0)
        return self.res

    # 回溯算法框架
    def backtrack(self, s: str, start: int) -> None:
        if start == len(s) and len(self.track) == 4:
            # base case，走到叶子节点
            # 即整个 s 被成功分割为合法的四部分，记下答案
            self.res.append(".".join(self.track))
        for i in range(start, len(s)):
            if not self.is_valid(s, start, i):
                # s[start..i] 不是合法的 ip 数字，不能分割
                continue
            if len(self.track) >= 4:
                # 已经分解成 4 部分了，不能再分解了
                break
            # s[start..i] 是一个合法的 ip 数字，可以进行分割
            # 做选择，把 s[start..i] 放入路径列表中
            self.track.append(s[start:i + 1])
            # 进入回溯树的下一层，继续切分 s[i+1..]
            self.backtrack(s, i + 1)
            # 撤销选择
            self.track.pop()

    # 判断 s[
    def is_valid(self, s: str, start: int, end: int) -> bool:
        length = end - start + 1

        if length == 0 or length > 3:
            return False

        if length == 1:
            # 如果只有一位数字，肯定是合法的
            return True

        if s[start] == '0':
            # 多于一位数字，但开头是 0，肯定不合法
            return False

        if length <= 2:
            # 排除了开头是 0 的情况，那么如果是两位数，怎么着都是合法的
            return True

        # 现在输入的一定是三位数
        if int(s[start:start + length]) > 255:
            # 不可能大于 255
            return False
        else:
            return True
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {

    List<String> res = new LinkedList<>();
    LinkedList<String> track = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0);
        return res;
    }

    // 回溯算法框架
    void backtrack(String s, int start) {
        if (start == s.length() && track.size() == 4) {
            // base case，走到叶子节点
            // 即整个 s 被成功分割为合法的四部分，记下答案
            res.add(String.join(".", track));
        }
        for (int i = start; i < s.length(); i++) {
            if (!isValid(s, start, i)) {
                // s[start..i] 不是合法的 ip 数字，不能分割
                continue;
            }
            if (track.size() >= 4) {
                // 已经分解成 4 部分了，不能再分解了
                break;
            }
            // s[start..i] 是一个合法的 ip 数字，可以进行分割
            // 做选择，把 s[start..i] 放入路径列表中
            track.addLast(s.substring(start, i + 1));
            // 进入回溯树的下一层，继续切分 s[i+1..]
            backtrack(s, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }

    // 判断 s[
    boolean isValid(String s, int start, int end) {
        int length = end - start + 1;

        if (length == 0 || length > 3) {
            return false;
        }

        if (length == 1) {
            // 如果只有一位数字，肯定是合法的
            return true;
        }

        if (s.charAt(start) == '0') {
            // 多于一位数字，但开头是 0，肯定不合法
            return false;
        }

        if (length <= 2) {
            // 排除了开头是 0 的情况，那么如果是两位数，怎么着都是合法的
            return true;
        }

        // 现在输入的一定是三位数
        if (Integer.parseInt(s.substring(start, start + length)) > 255) {
            // 不可能大于 255
            return false;
        } else {
            return true;
        }

    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

import "strings"

func restoreIpAddresses(s string) []string {
    var res []string
    track := make([]string, 0, 4)
    backtrack(s, 0, &track, &res)
    return res
}

// backtrack 是回溯算法框架，用来枚举所有可能的 ip 地址方案
func backtrack(s string, start int, track *[]string, res *[]string) {
    // 如果已经成功地分配了四部分，即获得了一个符合要求的 IP 地址
    // 则将这个地址加入结果 res 中，并直接返回
    if start == len(s) && len(*track) == 4 {
        *res = append(*res, strings.Join(*track, "."))
        return
    }
    // 在 s 的[start, len(s)] 区间内选择一个合法数字作为当前部分的地址
    for i := start; i < len(s); i++ {
        if !isValid(s, start, i) {
            continue
        }
        // 如果已经选择了四个数字作为 IP 地址的四个部分，再选就超标了，直接回溯
        if len(*track) >= 4 {
            break
        }
        // 把选定的数字加入到可行解中
        *track = append(*track, s[start:i+1])
        // 继续递归，从 i+1 开始作为下一个部分进行选择
        backtrack(s, i+1, track, res)
        // 回溯，撤销当前选择的数字
        *track = (*track)[:len(*track)-1]
    }
}

// 判断字符串 s[start:end+1] 是否为合法的 IP 地址的数段
func isValid(s string, start, end int) bool {
    length := end - start + 1
    if length == 0 || length > 3 {
        return false
    }
    if length == 1 {
        return true
    }
    if s[start] == '0' {
        return false
    }
    if length <= 2 {
        return true
    }
    if n, err := strconv.Atoi(s[start : start+length]); err != nil || n > 255 {
        return false
    }
    return true
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {string} s
 * @return {string[]}
 */
var restoreIpAddresses = function(s) {
    // 保存IP地址的结果
    const res = [];
    // 保存每一次分割出来的部分
    const track = [];

    // 回溯算法框架
    const backtrack = (s, start) => {
        // 如果走到叶子节点，即整个 s 被成功分割为合法的四部分，记下答案
        if (start === s.length && track.length === 4) {
            res.push(track.join('.'));
        }
        for (let i = start; i < s.length; i++) {
            // 如果该部分已经不是有效的ip地址部分，分割没有意义，跳过
            if (!isValid(s, start, i)) {
                continue;
            }
            // 如果已经分解成4个部分了，不能再分解了
            if (track.length >= 4) {
                break;
            }
            // 把该ip地址部分放入路径列表中，做选择
            track.push(s.substring(start, i + 1));
            // 进入回溯树的下一层，继续切分剩余部分
            backtrack(s, i + 1);
            // 撤销选择
            track.pop();
        }
    }

    // 判断该ip地址部分是否是合法的
    const isValid = (s, start, end) => {
        const length = end - start + 1;

        if (length === 0 || length > 3) {
            return false;
        }

        if (length === 1) {
            // 如果只有一位数字，肯定是合法的
            return true;
        }

        if (s.charAt(start) === '0') {
            // 多于一位数字，但开头是0，则不合法
            return false;
        }

        if (length <= 2) {
            // 开头不是0，则1~2位数都是合法的
            return true;
        }

        // 现在输入的一定是三位数
        if (parseInt(s.substring(start, start + length)) > 255) {
            // 不可能大于 255
            return false;
        } else {
            return true;
        }

    }

    backtrack(s, 0);
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_restore-ip-addresses" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_restore-ip-addresses"></div></div>
</details><hr /><br />

</details>
</div>

