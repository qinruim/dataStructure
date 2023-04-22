package netEase;

public class Demo2 {
    public static void main(String[] args) {
        //[[1, 1], [1, 1]],0,0,1,1
        //(int[][] map, int a_x, int a_y, int b_x, int b_y
        int[][] map = new int[2][2];
        map[0] = new int[]{1,1};
        map[1] = new int[]{1,1};
        int a_x = 0;
        int a_y = 0;
        int b_x = 1;
        int b_y = 1;

        System.out.println(getEstTime(map, a_x, a_y, b_x, b_y));
        System.out.println(3 / 2);
    }

    private static int getEstTime(int[][] map, int a_x, int a_y, int b_x, int b_y) {
        int res = 0;
        int len = 0;
        int x = Math.abs(a_x - b_x);
        int y = Math.abs(a_y - b_y);
        len = x + y;
        if ((len % 2) == 0){
           res = len / 2;
        }else if (len % 2 == 1){
            res = len - len / 2;
        }

        return  res;


    }
}
