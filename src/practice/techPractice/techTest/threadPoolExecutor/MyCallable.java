package practice.techPractice.techTest.threadPoolExecutor;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * @Package: practice.techPractice.techTest.threadPoolExcutor
 * @Title: MyCallable
 * @Author: qinrui
 * @Date 2023-08-14 23:49
 * @description: Callable接口实现类
 */
public class MyCallable implements Callable {
    private String command;

    public MyCallable(String command){
        this.command = command;
    }

    //成员方法 让线程sleep 5000ms
    private void processCommand(){
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public String call() throws Exception {
        System.out.println(command+" "+Thread.currentThread().getName() + " 开始时间：" + new Date());
        processCommand();
        System.out.println(command+" "+Thread.currentThread().getName() + " 结束时间：" + new Date());

        return command + "执行了";
    }

    @Override
    public String toString() {
        return "MyCallable{" +
                "command='" + command + '\'' +
                '}';
    }
}
