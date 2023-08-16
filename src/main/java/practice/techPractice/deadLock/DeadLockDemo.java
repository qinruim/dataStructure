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
    public static void main(String[] args) {
        Object resource1 = new Object();
        Object resource2 = new Object();

        new Thread(() -> {
            ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

            //线程1拿到资源1，休眠一段时间  确保线程2拿到资源2
            synchronized (resource1){
                System.out.println(Thread.currentThread().getName() + "拿到了 resource1");
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }


                System.out.println(Thread.currentThread().getName() + "试图获取resource2");

                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + "拿到了 resource2");
                    resource2.notify();

                }




            }
        },"Thread1").start();

        new Thread(() -> {
            //线程2拿到资源2，休眠一段时间  确保线程1拿到资源1
            synchronized (resource2){
                System.out.println(Thread.currentThread().getName() + "拿到了 resource2");
                try {
//                    Thread.sleep(1000);
                    resource2.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "试图获取resource1");
                synchronized (resource1){
                    System.out.println(Thread.currentThread().getName() + "拿到了 resource1");
                }
            }
        },"Thread2").start();
    }
}
