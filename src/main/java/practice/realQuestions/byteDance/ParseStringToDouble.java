package practice.realQuestions.byteDance;

/**
 * @Package： practice.byteDance
 * @Title: ParseStringToDouble
 * @Author： qrpop
 * @Date： 2023-08-12 18:39
 * @description: 将一个字符串转成double
 */
public class ParseStringToDouble {
    public static void main(String[] args) {
        String input = "-34.87";
        double result = customParseDouble(input);
        System.out.println(result);
    }

    private static double customParseDouble(String input) {

        double result = 0.0;
        //考虑负数
        boolean flag = false;
        if (input.charAt(0) == '-'){
            flag = true;
            input = input.substring(1);
        }


        String[] split = input.split("\\.");

//        for (int i = 0; i < split.length; i++) {
//            System.out.println(split[i]);
//        }



        //整数部分
        for (int i = 0; i < split[0].length(); i++) {
            double temp = split[0].charAt(i) - '0';
            result = result * 10 + temp;
        }

        //小数部分
        double decimal = 0.0;
        for (int i = split[1].length() - 1; i >= 0; i--) {
            double temp = split[1].charAt(i) - '0';
            decimal = decimal / 10 + temp;
        }
        decimal /= 10;


        result += decimal;

        if (flag){
            result = -result;
        }


        return result;

    }

}
