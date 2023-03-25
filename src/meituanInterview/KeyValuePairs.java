package meituanInterview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 首先，我们读取输入的字符串并将其拆分为键值对数组。然后，我们使用一个HashMap将这些键值对存储起来。
 * 接下来，我们读取查询字符串的数量，然后循环处理每个查询字符串。对于每个查询字符串，我们将其拆分为键值对数组，
 * 然后遍历这些键值对。如果我们找到了一个键值对，其键与我们存储的键值对的键相同且值相等，我们将其值更新为结果。
 * 最后，我们输出结果。如果我们在循环结束后没有找到匹配的键值对，则结果为“empty”。
 */
public class KeyValuePairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String keyValueString = scanner.nextLine();
        String[] keyValuePairs = keyValueString.split(",");
        Map<String, String> keyValueMap = new HashMap<>();
        for (String pair : keyValuePairs) {
            String[] keyValue = pair.split("=");
            String key = keyValue[0];
            String value = keyValue[1];
            keyValueMap.put(key, value);
        }

        int q = scanner.nextInt();
        scanner.nextLine(); // 读取换行符
        for (int i = 0; i < q; i++) {
            String query = scanner.nextLine();
            String[] queryPairs = query.split(",");
            String result = "empty";
            for (String pair : queryPairs) {
                String[] keyValue = pair.split("=");
                String key = keyValue[0];
                String value = keyValue[1];
                if (keyValueMap.containsKey(key) && keyValueMap.get(key).equals(value)) {
                    result = value;
                }
            }
            System.out.println(result);
        }
    }
}
