public class Main {
    public static void main(String[] args) {

        System.out.println(fib(4));
    }

    /**
     * 返回第n个斐波那契数   0,1,1,2,3,5,8,13.......
     * 递归
     * @param n
     * @return
     */
    public static int fib(int n){
        if (n <= 1){
            return n;
        }
        return fib(n - 1)+fib(n - 2);
    }
}