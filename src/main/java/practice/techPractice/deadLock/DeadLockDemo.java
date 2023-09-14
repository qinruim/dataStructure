package practice.techPractice.deadLock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * @Package: deadLock
 * @Title: DeadLockDemo
 * @Author: qinrui
 * @Date 2023-08-09 23:16
 * @description: 两个线程互相持有对方想要的资源，形成死锁
 */
public class DeadLockDemo {
    private static Object resource1 = new Object();//资源 1
    private static Object resource2 = new Object();//资源 2

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1){
                System.out.println(Thread.currentThread().getName() + "获取了资源1");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "试图获取资源2");
                synchronized (resource2){
                    System.out.println(Thread.currentThread().getName() + "获取了资源2");
                }
            }

        },"线程1").start();

        //如果线程2也先获取资源1再获取资源2就不会死锁  破坏了循环等待条件
        new Thread(() -> {
            synchronized (resource2){
                System.out.println(Thread.currentThread().getName() + "获取了资源2");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "试图获取资源1");
                synchronized (resource1){
                    System.out.println(Thread.currentThread().getName() + "获取了资源1");
                }
            }

        },"线程2").start();
    }
}
