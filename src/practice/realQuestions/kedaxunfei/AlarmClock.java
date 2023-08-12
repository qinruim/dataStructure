package practice.realQuestions.kedaxunfei;

import java.util.Scanner;

public class AlarmClock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentTime = scanner.next();
        String[] currentTimeArr = currentTime.split(":");
        int h0 = Integer.parseInt(currentTimeArr[0]);
        int m0 = Integer.parseInt(currentTimeArr[1]);

        int n = scanner.nextInt();

        int nextHour = Integer.MAX_VALUE;
        int nextMin = Integer.MAX_VALUE;


        for (int i = 0; i < n; i++) {
            String alarmTime = scanner.next();
            String[] alarmTimeArr = alarmTime.split(":");
            int hi = Integer.parseInt(alarmTimeArr[0]);
            int mi = Integer.parseInt(alarmTimeArr[1]);

            if (hi < h0){
                hi+=24;
            }
            //闹钟时间在当前时间之后
            if (hi > h0 || (hi == h0 && mi > m0)){
                if (hi < nextHour || (hi == nextHour && mi < nextMin)){
                    nextHour = hi;
                    nextMin = mi;
                }
            }

        }

        if (nextHour >= 24){
            System.out.println(String.format("%02d:%02d",nextHour-24,nextMin));
        }else {
        System.out.println(String.format("%02d:%02d",nextHour,nextMin));
    }}
}
