package practice.realQuestions.xiaohongshu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;

public class SetCompare {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();


        list.add(1);
        list.add(-1);
        list.add(10);
        list.add(15);
        list.add(-7);
        list.add(13);

        //原始的list
        System.out.println(list);

        //排序 sort()方法 参数 Comparator 重写compare方法 从小到大排序
//        list.sort(Comparator.reverseOrder());
        list.sort(new Comparator<Integer>() {
            //自定义排序规则 重写compare方法
            @Override
            public int compare(Integer o1, Integer o2) {

                return o2.compareTo(o1);
            }
        });
        //lambda表达式 默认从小到大排序  其实是一个交换的过程
//        list.sort((o1, o2) -> {
//            if (o1 > o2) { //o1 > o2 交换位置（返回1）
//                return 1;
//            } else if (o1 < o2){ //o1 < o2 不交换位置（返回-1）
//                return -1;
//            } else { //o1 = o2 不交换位置（返回0）
//                return 0;
//            }
//        });

        //排序后的list
        System.out.println(list);
    }
}
