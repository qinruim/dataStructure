package leetcode.editor.cn;

import java.util.*;

/**
 * 设计推特
 * design-twitter
 * @author mqinrui
 * @date 2023-10-08 16:02:37
 */
class P355_DesignTwitter{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P355_DesignTwitter().new Solution();
	 }

//力扣代码提交区
//leetcode submit region begin(Prohibit modification and deletion)
class Twitter {
    Set<Integer>[] follow; //i关注的
    Set<Integer>[] followed; //关注i的
    List<int[]>[] news; //每个人对应一个他能看见的推文集合   int[]:时间，推文id

    public Twitter() {
        follow = new Set[500];
        followed = new Set[500];
        news = new LinkedList[10000];
        for (int i = 0; i < follow.length; i++) {
            follow[i] = new HashSet<>();
            followed[i] = new HashSet<>();
        }
        for (int i = 0; i < news.length; i++) {
            LinkedList<int[]> list = new LinkedList<>();

            news[i] = list;
        }

    }
    
    public void postTweet(int userId, int tweetId) {
        //关注userID的能看见 包括他自己
        for (Integer id : followed[userId]) {
            int size = news[id].size();
            if (size == 10){
                news[id].remove(10);
            }
            news[id].add(new int[]{(int) System.currentTimeMillis(),tweetId});
            Collections.sort(news[id], new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    //时间大（新的）在前面
                    return o2[0] - o1[0];
                }
            });
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        //获取userID能看见的推文id
        List<Integer> res = new ArrayList<>();
        for (int[] twit : news[userId]) {
            res.add(twit[1]);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        //建立 关注关系
        follow[followerId].add(followeeId);
        follow[followerId].add(followerId); //他自己
        //被关注关系
        followed[followeeId].add(followerId);
        followed[followeeId].add(followeeId);//自己
    }
    
    public void unfollow(int followerId, int followeeId) {
        //取消关注
        //关注关系
        follow[followerId].remove(followeeId);
        //被关注关系
        follow[followeeId].remove(followerId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
//leetcode submit region end(Prohibit modification and deletion)


}
