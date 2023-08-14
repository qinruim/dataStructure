package practice.techPractice.techTest;

import java.nio.channels.NonWritableChannelException;
import java.util.concurrent.*;

/**
 * @Package: practice.techPractice.techTest
 * @Title: ThreadPoolDemo
 * @Author: qinrui
 * @Date 2023-08-14 22:08
 * @description: 线程池demo
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //创建线程池方法1：Executors.new  使用内置线程池（默认线程池核心参数） 一般不用
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        //创建线程池方法2：使用 ThreadPoolExecutor()构造函数，人工指定线程池核心参数，更可控
        //核心参数： public ThreadPoolExecutor(int corePoolSize,//线程池的核心线程数量
        //                              int maximumPoolSize,//线程池的最大线程数
        //                              long keepAliveTime,//当线程数大于核心线程数时，多余的空闲线程存活的最长时间
        //                              TimeUnit unit,//时间单位
        //                              BlockingQueue<Runnable> workQueue,//任务队列，用来储存等待执行任务的队列
        //                              ThreadFactory threadFactory,//线程工厂，用来创建线程，一般默认即可
        //                              RejectedExecutionHandler handler//拒绝策略，当提交的任务过多而不能及时处理时，我们可以定制策略来处理任务
        //                               )
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,
                5,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        threadPoolExecutor.execute(() -> {

        });

        new Thread(() -> {

        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        new Thread(String.valueOf(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                return 0;
            }
        })).start();




    }
}
