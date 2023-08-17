package leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

/**
 * 重新安排行程
 * reconstruct-itinerary
 *
 * @author mqinrui
 * @date 2023-08-17 10:27:35
 */
class P332_ReconstructItinerary {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P332_ReconstructItinerary().new Solution();
    }

    //力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
//    class Solution {
//        LinkedList<String> result = new LinkedList<>();
//        HashMap<String, Map<String,Integer>> map = new HashMap<>();
//
//        public List<String> findItinerary(List<List<String>> tickets) {
//            for (List<String> ticket : tickets) {
//
//                if (map.containsKey(ticket.get(0))){
//
//                }
//            }
//
//            return result;
//        }
//    }

    class Solution {
        private LinkedList<String> res;
        //map<出发机场, map<到达机场, 航班次数>>  记录航班映射关系
        //如果“航班次数”大于零，说明目的地还可以飞，
        // 如果“航班次数”等于零说明目的地不能飞了，而不用对集合做删除元素或者增加元素的操作。
        private Map<String, Map<String, Integer>> map;

        public List<String> findItinerary(List<List<String>> tickets) {
            map = new HashMap<String, Map<String, Integer>>();
            res = new LinkedList<>();

            //添加航班信息到映射关系表 map<出发机场, map<到达机场, 航班次数>>
            for(List<String> t : tickets){
                //temp是 <到达机场，航班次数>
                Map<String, Integer> temp;
                //map中存在这个出发地 就将到达地点的航班次数+1
                if(map.containsKey(t.get(0))){
                    temp = map.get(t.get(0));
                    temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
                }
                ////map中不存在这个出发地，就添加进去
                else{
                    temp = new TreeMap<>();//升序Map 保证到达地点按照升序排列
                    temp.put(t.get(1), 1);
                }

                map.put(t.get(0), temp);
            }

            //第一个机场一定是JFK 先添加到结果
            res.add("JFK");
            //tickets.size 是航班个数
            //回溯
            backTracking(tickets.size());
//            return new ArrayList<>(res);
            return res;
        }


        private boolean backTracking(int ticketNum){
            //终止条件：机场个数 == 航班个数 + 1
            if(res.size() == ticketNum + 1){
                return true;
            }
            String last = res.getLast(); //当前起点
            if(map.containsKey(last)){//防止出现null
                //遍历当前起点对应的航班
                for(Map.Entry<String, Integer> target : map.get(last).entrySet()){
                    int count = target.getValue(); //当前起点-重点之间的航班数 为0说明已经飞过了
                    if(count > 0){
                        res.add(target.getKey());
                        target.setValue(count - 1); //飞过的航班-1
                        //执行回溯 并判断
                        if(backTracking(ticketNum)) return true; //return true说明已经找到了  返回true即可
                        res.removeLast();
                        target.setValue(count); //没找到形程 航班计数要加回去
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
