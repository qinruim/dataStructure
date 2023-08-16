package practice.techPractice.techTest.threadPoolExecutor;

import java.util.Date;

/**
 * @Package: practice.techPractice.techTest.threadPoolExcutor
 * @Title: MyRunnable
 * @Author: qinrui
 * @Date 2023-08-14 23:33
 * @description: Runnable接口实现类，交给excutor执行
 */
public class MyRunnable implements Runnable{
    //成员变量
    private String command;

    //构造器
    public MyRunnable(String command){
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
    public void run() {
        System.out.println(command+" "+Thread.currentThread().getName() + " 开始时间：" + new Date());
        processCommand();
        System.out.println(command+" "+Thread.currentThread().getName() + " 结束时间：" + new Date());
    }

    @Override
    public String toString() {
        return "MyRunnable{" +
                "command='" + command + '\'' +
                '}';
    }
}
