package practice.techPractice.techTest.threadPoolExecutor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Package: practice.techPractice.techTest.threadPoolExecutor
 * @Title: NamingThreadFactory
 * @Author: qinrui
 * @Date 2023-08-15 11:09
 * @description: 自定义线程工厂，给线程池命名
 */
public class NamingThreadFactory implements ThreadFactory {
    private final AtomicInteger threadNum = new AtomicInteger();
    private final ThreadFactory delegate;
    private final String threadPoolName;

    //构造器 传入线程池名字和委托的线程工厂
    public NamingThreadFactory(ThreadFactory delegate,String threadPoolName){
        this.delegate = delegate;
        this.threadPoolName = threadPoolName;
    }

//    public NamingThreadFactory(String threadPoolName){
//        this.threadPoolName = threadPoolName;
//    }


    //重写创建线程方法 给线程命名
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = delegate.newThread(r);
//        Thread thread = new Thread(r);
        thread.setName(threadPoolName + "[#" + threadNum.incrementAndGet() + "]");
        return thread;
    }
}
