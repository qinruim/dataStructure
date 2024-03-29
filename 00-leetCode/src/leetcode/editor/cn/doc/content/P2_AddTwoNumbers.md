<p>给你两个&nbsp;<strong>非空</strong> 的链表，表示两个非负的整数。它们每位数字都是按照&nbsp;<strong>逆序</strong>&nbsp;的方式存储的，并且每个节点只能存储&nbsp;<strong>一位</strong>&nbsp;数字。</p>

<p>请你将两个数相加，并以相同形式返回一个表示和的链表。</p>

<p>你可以假设除了数字 0 之外，这两个数都不会以 0&nbsp;开头。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/01/02/addtwonumber1.jpg" style="width: 483px; height: 342px;" /> 
<pre>
<strong>输入：</strong>l1 = [2,4,3], l2 = [5,6,4]
<strong>输出：</strong>[7,0,8]
<strong>解释：</strong>342 + 465 = 807.
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>l1 = [0], l2 = [0]
<strong>输出：</strong>[0]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
<strong>输出：</strong>[8,9,9,9,0,0,0,1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>每个链表中的节点数在范围 <code>[1, 100]</code> 内</li> 
 <li><code>0 &lt;= Node.val &lt;= 9</code></li> 
 <li>题目数据保证列表表示的数字不含前导零</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>递归 | 链表 | 数学</details><br>

<div>👍 9852, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

逆序存储很友好了，直接遍历链表就是从个位开始的，符合我们计算加法的习惯顺序。如果是正序存储，那倒要费点脑筋了，可能需要 [翻转链表](https://labuladong.github.io/article/fname.html?fname=递归反转链表的一部分) 或者使用栈来辅助。

这道题主要考察 [链表双指针技巧](https://labuladong.github.io/article/fname.html?fname=链表技巧) 和加法运算过程中对进位的处理。注意这个 `carry` 变量的处理，在我们手动模拟加法过程的时候会经常用到。

**代码中还用到一个链表的算法题中是很常见的「虚拟头结点」技巧，也就是 `dummy` 节点**。你可以试试，如果不使用 `dummy` 虚拟节点，代码会稍显复杂，而有了 `dummy` 节点这个占位符，可以避免处理初始的空指针情况，降低代码的复杂性。

**标签：[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        // 在两条链表上的指针
        ListNode *p1 = l1, *p2 = l2;
        // 虚拟头结点（构建新链表时的常用技巧）
        ListNode *dummy = new ListNode(-1);
        // 指针 p 负责构建新链表
        ListNode *p = dummy;
        // 记录进位
        int carry = 0;
        // 开始执行加法，两条链表走完且没有进位时才能结束循环
        while (p1 != nullptr || p2 != nullptr || carry > 0) {
            // 先加上上次的进位
            int val = carry;
            if (p1 != nullptr) {
                val += p1->val;
                p1 = p1->next;
            }
            if (p2 != nullptr) {
                val += p2->val;
                p2 = p2->next;
            }
            // 处理进位情况
            carry = val / 10;
            val = val % 10;
            // 构建新节点
            p->next = new ListNode(val);
            p = p->next;
        }
        // 返回结果链表的头结点（去除虚拟头结点）
        return dummy->next;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        # 在两条链表上的指针
        p1, p2 = l1, l2
        # 虚拟头结点（构建新链表时的常用技巧）
        dummy = ListNode(-1)
        # 指针 p 负责构建新链表
        p = dummy
        # 记录进位
        carry = 0
        # 开始执行加法，两条链表走完且没有进位时才能结束循环
        while p1 or p2 or carry:
            # 先加上上次的进位
            val = carry
            if p1:
                val += p1.val
                p1 = p1.next
            if p2:
                val += p2.val
                p2 = p2.next
            # 处理进位情况
            carry, val = divmod(val, 10)
            # 构建新节点
            p.next = ListNode(val)
            p = p.next
        # 返回结果链表的头结点（去除虚拟头结点）
        return dummy.next
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 在两条链表上的指针
        ListNode p1 = l1, p2 = l2;
        // 虚拟头结点（构建新链表时的常用技巧）
        ListNode dummy = new ListNode(-1);
        // 指针 p 负责构建新链表
        ListNode p = dummy;
        // 记录进位
        int carry = 0;
        // 开始执行加法，两条链表走完且没有进位时才能结束循环
        while (p1 != null || p2 != null || carry > 0) {
            // 先加上上次的进位
            int val = carry;
            if (p1 != null) {
                val += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                val += p2.val;
                p2 = p2.next;
            }
            // 处理进位情况
            carry = val / 10;
            val = val % 10;
            // 构建新节点
            p.next = new ListNode(val);
            p = p.next;
        }
        // 返回结果链表的头结点（去除虚拟头结点）
        return dummy.next;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    // 在两条链表上的指针
    p1, p2 := l1, l2
    // 虚拟头结点（构建新链表时的常用技巧）
    dummy := &ListNode{-1, nil}
    // 指针 p 负责构建新链表
    p := dummy
    // 记录进位
    carry := 0
    // 开始执行加法，两条链表走完且没有进位时才能结束循环
    for p1 != nil || p2 != nil || carry > 0 {
        // 先加上上次的进位
        val := carry
        if p1 != nil {
            val += p1.Val
            p1 = p1.Next
        }
        if p2 != nil {
            val += p2.Val
            p2 = p2.Next
        }
        // 处理进位情况
        carry = val / 10
        val = val % 10
        // 构建新节点
        p.Next = &ListNode{val, nil}
        p = p.Next
    }
    // 返回结果链表的头结点（去除虚拟头结点）
    return dummy.Next
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var addTwoNumbers = function(l1, l2) {
    // 在两条链表上的指针
    let p1 = l1, p2 = l2;
    // 虚拟头结点（构建新链表时的常用技巧）
    let dummy = new ListNode(-1);
    // 指针 p 负责构建新链表
    let p = dummy;
    // 记录进位
    let carry = 0;
    // 开始执行加法，两条链表走完且没有进位时才能结束循环
    while (p1 !== null || p2 !== null || carry > 0) {
        // 先加上上次的进位
        let val = carry;
        if (p1 !== null) {
            val += p1.val;
            p1 = p1.next;
        }
        if (p2 !== null) {
            val += p2.val;
            p2 = p2.next;
        }
        // 处理进位情况
        carry = Math.floor(val / 10);
        val = val % 10;
        // 构建新节点
        p.next = new ListNode(val);
        p = p.next;
    }
    // 返回结果链表的头结点（去除虚拟头结点）
    return dummy.next;
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_add-two-numbers" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_add-two-numbers"></div></div>
</details><hr /><br />

**类似题目**：
  - [445. 两数相加 II 🟠](/problems/add-two-numbers-ii)
  - [67. 二进制求和 🟢](/problems/add-binary)
  - [剑指 Offer II 025. 链表中的两数相加 🟠](/problems/lMSNwu)

</details>
</div>

