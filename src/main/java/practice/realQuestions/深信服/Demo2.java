package practice.realQuestions.深信服;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @Package： practice.realQuestions.深信服
 * @Title: Demo2
 * @Author： qrpop
 * @Date： 2023-09-06 20:05
 * @description: 有两个字符串数组 一个是名字 一个是时间（HH:MM） 返回去重(时间间隔在一小时内使用三次及以上的需要去重)后的名字 按字母升序排列
 */
public class Demo2 {
    public static void main(String[] args) {
        String[] names = {"a","a","a","b","b","b"};
        String[] times = {"12:01","12:02","12:50","12:03","12:04","15:53"};

        method(names,times);
    }

    private static void method(String[] names, String[] times) {
        Map<String,List<LocalTime>> map = new HashMap<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            LocalTime time = LocalTime.parse(times[i],formatter);
              if (!map.containsKey(name)){
                    List<LocalTime> list = new ArrayList<>();
                    list.add(time);
                    map.put(name,list);
                }
              else if(map.containsKey(name)){
                  if (map.get(name).size() < 3){
                      List<LocalTime> list = map.get(name);
                      list.add(time);
                      map.put(name,list);
                  }
                  else {
                      //判断时间间隔 第一个和最后一个进行判断
                      List<LocalTime> list = map.get(name);
                      LocalTime[] localTimes = list.toArray(new LocalTime[0]);
                      //时间排序
                      Arrays.sort(localTimes);
                      LocalTime first = localTimes[0];
                      LocalTime last = localTimes[localTimes.length - 1];
                      if (last.getHour() - first.getHour() == 1){
                          if (last.getMinute() - first.getMinute() <= 0){
                              continue;
                          }
                      }
                      else if (last.getHour() - first.getHour() > 1){
                          continue;
                      }
                      else {
                          List<LocalTime> list1 = new ArrayList<>();
                          list1.add(time);
                          map.put(name,list1);
                      }

                  }
            }



        }
}

}
