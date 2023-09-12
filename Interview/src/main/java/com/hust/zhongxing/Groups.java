package com.hust.zhongxing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @Package： com.hust.zhongxing
 * @Title: Groups
 * @Author： qrpop
 * @Date： 2023-09-12 21:06
 * @description:
 */
public class Groups {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int p = scanner.nextInt(); //部落数
        int q = scanner.nextInt();//重点部落数

        List<Integer> groups = new ArrayList<>();
        List<Integer> ims = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            groups.add(scanner.nextInt());
        }
        for (int i = 0; i < q; i++) {
            ims.add(scanner.nextInt());
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < ims.size(); i++) {
            Integer im = ims.get(i);
            Iterator<Integer> iterator = groups.iterator();
            while (iterator.hasNext()) {
                Integer group = iterator.next();
                if (group.equals(im)) {
                    res.add(group);
                    iterator.remove();
                }
            }
        }

        groups.sort((o1,o2) -> {
            return o1 - o2;
        });
        res.addAll(groups);

        for (Integer re : res) {
            System.out.print(re + " ");
        }

    }
}
