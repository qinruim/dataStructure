package meituan;

import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Tree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] p = new int[n + 1];
        int[] c = new int[n + 1];

        AtomicInteger atomicInteger = new AtomicInteger(5);
        atomicInteger.getAndIncrement();

    }
}
