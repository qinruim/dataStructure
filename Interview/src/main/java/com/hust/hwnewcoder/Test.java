package com.hust.hwnewcoder;

/**
 * @Package: com.hust.hwnewcoder
 * @Title: Test
 * @Author: qinrui
 * @Date 2023-09-17 15:15
 * @description:
 */
public class Test {
    public static void main(String[] args) {
//        int r = 156;
//        String s = Integer.toString(r);
//        System.out.println(s.substring(0,2));


        System.out.println(rContainsL(13, 123));
    }

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
