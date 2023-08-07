package techTest;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

public class CasTest {
//    private static volatile int value;
    private static volatile AtomicInteger value = new AtomicInteger(0);
//    private static final Unsafe unsafe = Unsafe.getUnsafe();

    public static void main(String[] args) {

        CasTest casTest = new CasTest();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    casTest.getAndIncrement(1);
//                    System.out.print(Thread.currentThread().getId()+":"+ casTest.value+" ");

                }
            }).start();
        }


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(casTest.value);

    }

    private void getAndIncrement(int x) {
//        value += x;
       //用原子类 （内部实现是一个cas机制）
        value.getAndAdd(x);
    }

}
