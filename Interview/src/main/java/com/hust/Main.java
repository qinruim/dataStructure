package com.hust;

public class Main {
    public static void main(String[] args) {
        int[] ints = {1,3,4,2};
        System.out.println(solution(ints));

    }

    private static int solution(int[] ints){
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int i : ints) {
            if (i > first){
                third = second;
                second = first;
                first = i;
            }else if (i < first && i > second){
                third = second;
                second = i;
            }else if (i< second && i > third){
                third = i;
            }
        }

        if (third == Integer.MIN_VALUE){
            return first;
        }else {
            return third;
        }
    }


}
