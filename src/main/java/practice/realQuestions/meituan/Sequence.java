package practice.realQuestions.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Package： meituan
 * @Title: SumOfab
 * @Author： qrpop
 * @Date： 2023-08-12 10:01
 * @description:   有一个长度为n的排列（没有重复元素），小美想知道x、y两个元素是否相邻
 *
 *                 输入：第一行输入一个正整数n，代表排列的长度
 *                      第二行输入n个正整数ai，代表排列中的元素
 *                      第三行输入两个正整数x，y（x!=y），用空格隔开
 *
 *                 输出：如果x、y在排列中相邻，输出“Yes”，否则输出“No”
 */
public class Sequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(scanner.nextInt(),i);
        }
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if (Math.abs(map.get(x) - map.get(y)) == 1 ){
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }

    }
}
