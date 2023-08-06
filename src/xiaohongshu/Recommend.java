package xiaohongshu;

import java.util.*;

/**
 * 小红书有一个推荐系统，可以根据用户搜索的关键词推荐用户希望获取的内容。
 *
 * 现在给定小红的搜索记录（记录为分词后的结果），我们认为当一个单词出现的次数不少于3次时，
 * 该单词为“用户期望搜索的单词”，即称为关键词。
 *
 * 请你根据小红的记录，输出小红的用户画像对应的所有关键词。
 *
 * in:kou red game red ok who game red karaoke yukari kou red red nani kou can koukou ongakugame game
 * out:red
 *     game
 *     kou
 */
public class Recommend {

    public static void main(String[] args) {
//        String input = "kou red game red ok who game red karaoke yukari kou red red nani kou can koukou ongakugame game";
//        String[] inputWords = input.split(" ");
//        for (int i = 0; i < inputWords.length; i++) {
//            System.out.println(inputWords[i]);
//        }
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputWords = input.split(" ");
        getKeyWords(inputWords);
    }

    private static void getKeyWords(String[] inputWords) {
        HashMap<String, Integer> countMap = new HashMap<>();

        for (String inputWord : inputWords) {
            if (countMap.containsKey(inputWord)){
                countMap.put(inputWord,countMap.get(inputWord) + 1);
            }else {
                countMap.put(inputWord,1);
            }
        }

//        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }

        LinkedList<String> keyWords = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() >= 3){
                keyWords.addFirst(entry.getKey());
            }
        }

        Collections.sort(keyWords, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int a = countMap.get(o2) - countMap.get(o1);
                if (a == 0){
                    return o1.compareTo(o2);
                }
                return a;
            }
        });

        for (String keyWord : keyWords) {
            System.out.println(keyWord);
        }



    }
}
