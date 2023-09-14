package practice.techPractice.volatileDemos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Package: volatileDemos
 * @Title: AtomicOfVolatile
 * @Author: qinrui
 * @Date 2023-08-10 00:13
 * @description: 证明volatile不能保证原子性
 */
public class AtomicOfVolatile {
    private volatile static int count = 0;
    private static AtomicInteger countAtomic = new AtomicInteger(0);

    public synchronized void increment(){
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        //用很多线程  每个去加个数  看最后结果是否等于应该是的结果

        AtomicOfVolatile atomicOfVolatile = new AtomicOfVolatile();

        ExecutorService threadPool = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j < 1000; j++) {
//                    atomicOfVolatile.increment();
//                    countAtomic.getAndIncrement();
                    count++;

                }
            });
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread.sleep(2000);
        System.out.println(count);
//        System.out.println(countAtomic);

        threadPool.shutdown();
    }




}
