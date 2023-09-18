package com.hust.hwnewcoder;

import java.util.*;

/**
 * @Package: com.hust.hwnewcoder
 * @Title: HJ25数据分类
 * @Author: qinrui
 * @Date 2023-09-17 14:16
 * @description:
 */
public class HJ25数据分类 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //整数序列L 不去重  <索引，值>
        int ln = scanner.nextInt();
        Map<Integer,Integer> lMap = new HashMap<>();
        for (int i = 0; i < ln; i++) {
            int lVal = scanner.nextInt();
            lMap.put(i,lVal);
        }

        //规则序列R
        int rn = scanner.nextInt();
        Set<Integer> rSet = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.intValue() - o2.intValue();
            }
        });
        for (int i = 0; i < rn; i++) {
            rSet.add(scanner.nextInt());
        }



        LinkedList<List<Integer>> res = new LinkedList<>();
        int count = 0; //记录最终有多少整数
        for (Integer r : rSet) {
//            System.out.println("R:" + r);
            int countL = 0;
            LinkedList<Integer> list = new LinkedList<>();
            for (Map.Entry<Integer, Integer> lEntry : lMap.entrySet()) {
                //<索引，值>
                //1.r要是l的子序列
                int L = lEntry.getValue();
                boolean flag = rContainsL(r,L);
                if (flag){
                    //找到了满足条件的L
                    //输出信息：r，L的个数，  L索引，L
                    countL++;
                    list.add(lEntry.getKey());//L索引
                    list.add(L);// L
                }
            }
            if (countL == 0){
                continue;
            }
            //一个r对应的所有L遍历结束
            list.addFirst(countL);
            list.addFirst(r);
            res.add(list);
            count += (countL*2 + 2);
        }

        //输出
        System.out.print(count + " ");
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
        }

    }

    /**
     * 判断 r是否l的子序列 （l整数对应的数字需要连续包含r对应的数字）
     * @param r
     * @param l
     * @return
     */
    private static boolean rContainsL(int r, int l) {
       String R = Integer.toString(r);
       String L = Integer.toString(l);

       int subLen = R.length();
       int lLen = L.length();
       if (lLen < subLen){
           return false;
       }
        for (int i = 0; i <= lLen - subLen; i++) {
            String substring = L.substring(i, i + subLen);
            if(substring.equals(R)){
                return true;
            }
        }
        return false;
    }
}
