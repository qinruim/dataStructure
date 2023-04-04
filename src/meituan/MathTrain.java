package meituan;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MathTrain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inputNums = new int[n];
        for (int i = 0; i < n; i++) {
            inputNums[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        Map<Integer, String> map = new HashMap<>();
        int[] keys = new int[m];
        for (int i = 0; i < m; i++) {
            int k = scanner.nextInt();
            String v = scanner.next();
            map.put(k,v);
            keys[i] = k;
        }

//        System.out.println(Arrays.toString(inputNums)+","+map.toString());

        //求和
        double result = 0.0;
        for (int j = 0; j < n; j++) {
            result += inputNums[j];
        }
//        System.out.println(result);

        //开始操作
        for (int i = 0; i < m; i++) {
            //第i次，一共m次
            int key = keys[i];
            String symbol = map.get(key);

            //将第key个+变成symbol
            if(symbol.equals("+")){
                String format = String.format("%.1f", result);
                System.out.print(format + " ");
            }else if (symbol.equals("-")){
                //将第key个+换成-，即result-2倍第（key+1）个数
                double v = result - 2 * inputNums[key];
                String format = String.format("%.1f", v);
                System.out.print(format + " ");
            }else if (symbol.equals("*")){
                //减去第key个+前后两个数再加上他们的和
                double v = result - (inputNums[key - 1] + inputNums[key]) + inputNums[key - 1] * inputNums[key];
                String format = String.format("%.1f", v);
                System.out.print(format + " ");
            }else if (symbol.equals("/")){
                double v = result - (inputNums[key - 1] + inputNums[key]) + ((double)inputNums[key - 1] / (double) inputNums[key]);
                String format = String.format("%.1f", v);
                System.out.print(format + " ");
            }

        }





    }
}
