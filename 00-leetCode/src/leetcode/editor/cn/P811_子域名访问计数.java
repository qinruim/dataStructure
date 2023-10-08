package leetcode.editor.cn;

import java.util.*;

/**
 * 子域名访问计数
 * subdomain-visit-count
 * @author mqinrui
 * @date 2023-10-08 11:18:35
 */
class P811_SubdomainVisitCount{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P811_SubdomainVisitCount().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
		List<String> res = new ArrayList<>();

		//先拿出每一个计数配对域名 对其拆解计数  遍历 ++
		//用一个map装<域名，次数> 判断其是否存在  存在加上  不存在新添加
		Map<String,Integer> map = new HashMap<>();

		for (String cpdomain : cpdomains) {
//			System.out.println(cpdomain);
			String[] s = cpdomain.split(" ");
			int count = Integer.parseInt(s[0]);
//			System.out.println(count);
			//将域名拆分组合成所有可能的域名
			List<String> adds = new ArrayList<>();
			String address = s[1];
			String[] split = address.split("\\.");

			for (int i = 0; i < split.length; i++) {
				StringBuilder sb = new StringBuilder();
					//当前索引到最后
					for (int j = i; j < split.length - 1; j++) {
						sb.append(split[j]).append(".");
					}
					sb.append(split[split.length - 1]);

					String add = sb.toString();

					map.put(add, map.getOrDefault(add,0) + count);
			}

			//处理域名
			for (String add : adds) {
				System.out.println(add);
					map.put(add, map.getOrDefault(add,0) + count);
			}
		}

		//统计
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String resAdd = entry.getValue() + " " + entry.getKey();
			res.add(resAdd);
		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
