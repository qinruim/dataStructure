package leetcode.editor.cn;

import java.security.Key;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;

/**
 * LRU 缓存
 * lru-cache
 * @author mqinrui
 * @date 2023-08-02 21:09:32
 */
class P146_LruCache{
	 public static void main(String[] args) {
	 	 //测试代码
//	 	 Solution solution = new P146_LruCache().new Solution();
//         LRUCache lruCache = new LRUCache(2);

     }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 注意，LinkedList的remove方法是遍历寻找删除，复杂度不是O（1），
     * 因此此种做法其实不符合要求，用来弄清楚LRU思路
     * 符合要求的做法事手写一个简单双向链表，实现O（1）的删除方法
     */
    class LRUCache {

         private int capacity;
         private Map<Integer,Integer> cacheMap;
         private LinkedList<Integer> list;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.list = new LinkedList<>();
    }
    
    public int get(int key) {
        if (!cacheMap.containsKey(key)){
            return -1;
        }
        //将这个元素移动到最新的位置（先删除后添加）
        list.remove(((Integer) key));
        list.addFirst(key);
        return cacheMap.get(key);
    }
    
    public void put(int key, int value) {
        if (cacheMap.containsKey(key)){
            //更新value,并移动到最新位置
            cacheMap.put(key,value);
            list.remove(((Integer) key));
            list.addFirst(key);
        }else {
            //容量满了，移除最久未使用的元素
            if (list.size() >= capacity){
//                int oldestKey = list.getLast();
                int oldestKey = list.removeLast();
                cacheMap.remove(oldestKey);
//                list.remove(((Integer) oldestKey));
            }
            //插入
            list.addFirst(key);
            cacheMap.put(key,value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)


}
