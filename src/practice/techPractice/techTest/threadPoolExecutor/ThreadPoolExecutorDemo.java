package practice.techPractice.techTest.threadPoolExecutor;

import java.util.concurrent.*;

/**
 * @Package: practice.techPractice.techTest.threadPoolExcutor
 * @Title: Main
 * @Author: qinrui
 * @Date 2023-08-14 23:40
 * @description: 主函数
 */
public class ThreadPoolExecutorDemo {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        //创建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        //创建MyRunnable的实例对象（任务），交给线程池执行
//        for (int i = 0; i < 10; i++) {
//            MyRunnable taskRunnable = new MyRunnable("任务" + i);
//            //Runnable用submit，execute都可
////            Future<?> submit = threadPoolExecutor.submit(taskRunnable);
//            threadPoolExecutor.execute(taskRunnable);
//        }

        //MyCallable
        for (int i = 0; i < 10; i++) {
            MyCallable taskCallable = new MyCallable("任务" + i);
            //Callable只能用submit
            Future future = threadPoolExecutor.submit(taskCallable);

            //获取线程执行结果  future.get() 是一个阻塞方法 会一个线程执行完才到下一个  出现类似单线程的情况
            //Future 接口的 get() 方法用于获取异步任务的执行结果。如果在调用 get() 方法时，任务还没有完成，
            // 那么当前线程会被阻塞，直到任务完成并返回结果，或者直到发生超时或被中断。
            // 这就意味着，如果你在多个任务上分别调用了 get() 方法，每次调用都会等待任务完成，这可能会导致类似单线程的串行行为。

            //因此可以交给另一个线程去异步处理 解除依赖关系
//            try {
//                String result = (String) future.get();
//                System.out.println("result: " + result);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            new Thread(() -> {
//                try {
//                    String result = (String) future.get();
//                    System.out.println("result: " + result);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }).start();

            threadPoolExecutor.execute(() -> {
                try {
                    String result = (String) future.get();
                    System.out.println(Thread.currentThread().getName() + " result: " + result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }




        //终止线程池
        threadPoolExecutor.shutdown();

        //保证线程池结束后才执行后面的
        while (!threadPoolExecutor.isTerminated()){}
        System.out.println("线程全部执行完成");




    }
}
