package leetcode.editor.cn;

import java.util.*;

/**
 * 股票价格波动
 * stock-price-fluctuation
 *
 * @author mqinrui
 * @date 2023-10-08 11:16:44
 */
class P2034_StockPriceFluctuation {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2034_StockPriceFluctuation().new Solution();
    }

    //力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
    class StockPrice {
        private Map<Integer, Integer> map;
        private PriorityQueue<int[]> pq;
        private TreeSet<int[]> maxAndMin;
//        private PriorityQueue<int[]> min;

        public StockPrice() {
            map = new HashMap<>();
            //按照时间降序排列 最新的就在上面
            pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });
//            max = new int[]{0, Integer.MIN_VALUE};
//            min = new int[]{0, Integer.MAX_VALUE};
            maxAndMin = new TreeSet<>(new Comparator<int[]>() {
                //按价格升序排列
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });

        }


        public void update(int timestamp, int price) {
            int[] oldStock = new int[2];
            //存在时间戳
            if (map.containsKey(timestamp)) {
                //拿到旧的 移除队列中旧的数据
                oldStock[0] = timestamp;
                oldStock[1] = map.get(timestamp);
                pq.remove(oldStock);
                //如果更新的恰好是之前的最大或者最小值  很难处理  所以也用优先级队列 按照价格存储
                //最大、最小分别在头部、尾部
                if (price >= maxAndMin.last()[1] || price <= maxAndMin.first()[1]){
                    maxAndMin.remove(oldStock);
                }
            }

            //更新操作
            map.put(timestamp, price);
            int[] newStock = new int[]{timestamp, price};
            pq.add(newStock);
            maxAndMin.add(newStock);
        }

        public int current() {
            return pq.isEmpty() ? 0 : pq.peek()[1];
        }

        public int maximum() {
            return maxAndMin.last()[1];
        }

        public int minimum() {
            return maxAndMin.first()[1];
        }

    }


/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
//leetcode submit region end(Prohibit modification and deletion)


}
