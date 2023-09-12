package practice.techPractice.reflection;

/**
 * @Package： practice.techPractice.reflection
 * @Title: TargetObject
 * @Author： qrpop
 * @Date： 2023-09-12 16:13
 * @description: 反射操作的目标类
 */
public class TargetObject {
    private String value;

    public TargetObject() {
        value = "qinruimao";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }

}
