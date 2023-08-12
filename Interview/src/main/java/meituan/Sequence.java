package meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Package： meituan
 * @Title: SumOfab
 * @Author： qrpop
 * @Date： 2023-08-12 10:01
 * @description:
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
