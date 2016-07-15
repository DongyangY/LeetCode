public class Twitter {
    
    class Tweet {
        int uid, tid;
        public Tweet(int uid, int tid) {
            this.uid = uid;
            this.tid = tid;
        }
    }
    
    List<Tweet> tweets;
    Map<Integer, Set<Integer>> follows;

    /** Initialize your data structure here. */
    public Twitter() {
        tweets = new ArrayList<Tweet>();
        follows = new HashMap<Integer, Set<Integer>>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweets.add(new Tweet(userId, tweetId));    
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> recent = new ArrayList<>();
        for (int i = tweets.size() - 1; i >= 0; i--) {
            int uid = tweets.get(i).uid;
            if (uid == userId || (follows.containsKey(userId) && follows.get(userId).contains(uid))) {
                recent.add(tweets.get(i).tid);
            }
            if (recent.size() >= 10) return recent;
        }
        return recent;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!follows.containsKey(followerId)) {
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            follows.put(followerId, set);
        } else {
            follows.get(followerId).add(followeeId);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!follows.containsKey(followerId)) return;
        follows.get(followerId).remove(followeeId);
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