package volatileDemos;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Package: volatileDemos
 * @Title: AtomicOfVolatile
 * @Author: qinrui
 * @Date 2023-08-10 00:13
 * @description: 证明volatile不能保证原子性
 */
public class AtomicOfVolatile {
    private volatile static int count = 0;

    public synchronized void increment(){
        count++;
    }

    public static void main(String[] args) {
        //用很多线程  每个去加个数  看最后结果是否等于应该是的结果

        AtomicOfVolatile atomicOfVolatile = new AtomicOfVolatile();

        ExecutorService threadPool = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    atomicOfVolatile.increment();
//                    count++;

                }
            });
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);

        threadPool.shutdown();
    }




}
