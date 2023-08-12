package practice.techPractice.volatileDemos;

/**
 * @Package: volatileDemos
 * @Title: SingletonWithVolatile
 * @Author: qinrui
 * @Date 2023-08-10 00:03
 * @description: 用volatile实现单例类
 */
public class SingletonWithVolatile {

    //静态 生成一个单例对象
    private volatile static SingletonWithVolatile uniqueSingletonInstance;

    //构造器（私有）通过将构造函数设置为私有，该类防止外部类直接实例化该类。
    private SingletonWithVolatile(){}

    //静态方法 获取单例对象
    public static SingletonWithVolatile getSingleton(){
        //判断是否实例化过 没有实例化过才加锁进行实例化
        if (uniqueSingletonInstance == null){
            synchronized (SingletonWithVolatile.class){
                if (uniqueSingletonInstance == null) {
                    uniqueSingletonInstance = new SingletonWithVolatile();
                }
            }
        }

        return uniqueSingletonInstance;

    }




}
