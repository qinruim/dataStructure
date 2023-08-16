package practice.techPractice.techTest;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @Package: practice.techPractice.techTest
 * @Title: ThreadLocalDemo
 * @Author: qinrui
 * @Date 2023-08-14 16:43
 * @description: 使用ThreadLocal
 */
public class ThreadLocalDemo implements Runnable {
    // SimpleDateFormat 不是线程安全的，所以每个线程都要有自己独立的副本
    private static final ThreadLocal<SimpleDateFormat> FORMAT_THREAD_LOCAL =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMMdd HHmm"));

    public static void main(String[] args) {
        ThreadLocalDemo demo = new ThreadLocalDemo();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(demo, "" + i);
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.start();

        }
    }


    @Override
    public void run() {
        System.out.println("Thread name:" + Thread.currentThread().getName()
        + " default Formatter = "+FORMAT_THREAD_LOCAL.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        FORMAT_THREAD_LOCAL.set(new SimpleDateFormat());
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+FORMAT_THREAD_LOCAL.get().toPattern());


    }
}
