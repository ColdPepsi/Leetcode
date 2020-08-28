/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 类Twitter.java的实现描述：TODO 类实现描述
 *
 * @author wubiao21 2020年08月27日 13:33:54
 */
public class Twitter {
    /**
     * Initialize your data structure here.
     */
    private final List<int[]> msg;//存储发送消息的队列
    private final Map<Integer, Set<Integer>> fans;//键是用户ID，值是该用户的所有粉丝

    public Twitter() {
        msg = new ArrayList<>();
        fans = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        msg.add(new int[]{userId, tweetId});
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ret = new ArrayList<>(16);
        for (int i = msg.size() - 1; i >= 0 && ret.size() < 10; i--) {//逆序遍历，因为新发送的在后面
            int[] ints = msg.get(i);
            int poster = ints[0];//发推人ID
            Integer twitterId = ints[1];//推文ID
            Set<Integer> fanSet = fans.getOrDefault(poster, null);
            if (fanSet != null && fanSet.contains(userId) || poster == userId) {//如果userId有订阅该条推特
                ret.add(twitterId);
            }
        }
        return ret;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        Set<Integer> fanSet = fans.getOrDefault(followeeId, new HashSet<>());
        fanSet.add(followerId);
        fans.put(followeeId, fanSet);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> fanSet = fans.getOrDefault(followeeId, null);
        if (fanSet != null) {
            fanSet.remove(followerId);
        }
    }
}