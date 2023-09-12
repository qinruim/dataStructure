package practice.techPractice.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Package： practice.techPractice.reflection
 * @Title: Operate
 * @Author： qrpop
 * @Date： 2023-09-12 16:14
 * @description: 通过反射操作目标类
 */
public class Operate {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //1.获取Class对象
        Class targetClass = TargetObject.class;
        //2.创建目标类实例
        TargetObject targetInstance = (TargetObject) targetClass.newInstance();

        //3.获取目标类中的定义的所有方法 并打印方法名
        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        //4.获取制定方法并调用
        Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(targetInstance,"qinruimomaomao");

        //5.获取指定参数 并修改
        Field field = targetClass.getDeclaredField("value");
        field.setAccessible(true);
        field.set(targetInstance,"qqqqqq");

        //6.调用私有方法 并查看修改的参数
        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetInstance);

    }
}
