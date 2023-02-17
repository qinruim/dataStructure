public class Main {
    public static void main(String[] args) {
        TimeTool.check("fib", new TimeTool.Task() {
            @Override
            public void execute() {
                System.out.println(fib(45));
            }
        });
        TimeTool.check("fib1", new TimeTool.Task() {
            @Override
            public void execute() {
                System.out.println(fib1(45));
            }
        });
//        System.out.println(fib1(64));
    }

    /**
     * 返回第n个斐波那契数   0,1,1,2,3,5,8,13.......
     * 递归 性能不好 重复调用 时间复杂度大  O（2^n）
     * @param n
     * @return
     */
    public static int fib(int n){
        if (n <= 1){
            return n;
        }
        return fib(n - 1)+fib(n - 2);
    }

    /**
     *时间复杂度  O（n）
     * @param n
     * @return
     */
    public static int fib1(int n){
        if (n <= 1){
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }


}