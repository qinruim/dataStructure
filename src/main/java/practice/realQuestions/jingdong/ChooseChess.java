//package practice.realQuestions.jingdong;
//
//import com.sun.javafx.image.BytePixelSetter;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
///**
// * @Package： practice.realQuestions.jingdong
// * @Title: ChooseChess
// * @Author： qrpop
// * @Date： 2023-08-12 19:30
// * @description: 小红有一个大小为n×m的棋盘，'.'表示这个格子没有棋子，'X'表这个格子有棋子。
// * 第i行第j列的格子可以用一个坐标(i,j)表示。
// * 小红想选出四个棋子，对应坐标分别为()()()(),使得这四个坐标构成一个止方形，小红有多少种方案。
// * 如果两个方案有任意一个棋子的坐标不同，那么就认为是两种不同的方案
// * 输入描述：
// * 第一行输入n,m,代表棋盘的大小
// * 接下来有n行，每行一个长度为m的字符串仅包含'.'和'X'。
// * 输出描述：
// * 一个整数，代表最终的 方案数
// *
//4 4
//XX..
//XXX.
//.X.X
//..X.
// */
//public class ChooseChess {
//
//    private static int result = 0;
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = 0, m = 0;
//        n = scanner.nextInt();
//        m = scanner.nextInt();
//
//
//        char[][] chess = new char[n][m];
//        for (int i = 0; i < n; i++) {
//            String inputRow = scanner.next();
//            for (int j = 0; j < inputRow.length(); j++) {
//                chess[i][j] = inputRow.charAt(j);
//            }
//
//        int countChess = 0;
////        int result = 0;
//        HashMap<Integer, Integer> map = new HashMap<>(); //存储棋子的坐标
//
//        getPlans(chess, countChess,0,map);
//
//        System.out.println(result);
//
//
//    }
//
//    private static void getPlans(char[][] chess, int countChess, int startIndex, HashMap<Integer, Integer> map) {
//        if (countChess == 4){
//            if (isSquare(map)){
//                result++;
//            }
//            return;
//        }
//
//        for (int i = startIndex; i < chess.length; i++) {
//            for (int j = 0; j < chess[i].length; j++) {
//                if (chess[i][j] == 'X'){
//                    countChess++;
//                    map.put(i,j);
//                    getPlans(chess, countChess, i + 1, map);
//                    map.remove(i,j);
//                    countChess--;
//                }
//            }
//        }
//
//
//
//    }
//
//    private static boolean isSquare(HashMap<Integer, Integer> chessMap) {
//        int[] x = new int[4];
//        int[] y = new int[4];
//
//        for (int i = 0; i < chessMap.keySet().size(); i++) {
//            x[i] = chessMap.keySet().iterator().next();
//            y[i] = chessMap.get(x[i]);
//        }
////        for (int i = 0; i < chessMap.entrySet().size(); i++) {
////            Map.Entry<Integer, Integer> entry = chessMap.entrySet().iterator().next();
////            x[i] = entry.getKey();
////            y[i] = entry.getValue();
////        }
//
//        int x1 = x[0],x2 = x[1],x3 = x[2],x4 = x[3];
//        int y1 = y[0],y2 = y[1],y3 = y[2],y4 = y[3];
//
//        int[] distances = {
//                distance(x1, y1, x2, y2), distance(x1, y1, x3, y3),
//                distance(x1, y1, x4, y4), distance(x2, y2, x3, y3),
//                distance(x2, y2, x4, y4), distance(x3, y3, x4, y4)
//        };
//
//        // 计数器，用于统计两个相等的距离数量和四个相等的距离数量
//        int count2 = 0, count4 = 0;
//        for (int dist : distances) {
//            if (dist == 0) {
//                return false; // 如果有重复的点，不是正方形
//            }
//            if (dist == distances[0]) {
//                count2++; // 统计相等的距离数量
//            }
//            if (dist == distances[0] * 2) {
//                count4++; // 统计两倍相等的距离数量
//            }
//        }
//
//        // 判断是否满足正方形的条件：2个相等的距离和4个两倍相等的距离
//        return count2 == 2 && count4 == 4;
//
//    }
//
//    static int distance(int x1, int y1, int x2, int y2) {
//        int dx = x1 - x2;
//        int dy = y1 - y2;
//        return dx * dx + dy * dy;
//    }
//}
