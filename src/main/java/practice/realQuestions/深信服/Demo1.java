package practice.realQuestions.深信服;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Package： practice.realQuestions.深信服
 * @Title: Demo1
 * @Author： qrpop
 * @Date： 2023-09-06 19:43
 * @description: 给一个字符串 消除连续三个相同的字符 消除后的拼起来  继续消除  知道无法再消除
 */
public class Demo1 {
    public static void main(String[] args) {
        String s = "B111CC111CB";
        method(s);



    }

    private static void method(String s) {
        char[] chars = s.toCharArray();
        int count = 1;
        StringBuilder sb = new StringBuilder();
        char pre = chars[0];

        for (int i = 1; i < chars.length; i++) {
            char cur = chars[i];
            if (cur == pre){
                count++;
            }
            else {
                if (count < 3){
                    for (int j = 0; j < count; j++) {
                        sb.append(pre);
                    }
                }
                count = 1;
                pre = cur;
            }
        }

        if (count < 3) {
            for (int j = 0; j < count; j++) {
                sb.append(pre);
            }
        }

        if (sb.length() == s.length()) {
            System.out.println(sb.toString());
        } else {
           method(sb.toString());
        }
    }
}
