/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：把两个字符串s拼接在一起，并移除第一个和最后一个字符，那么得到的字符串一定包含 s，即 s 是它的一个子串。
 *
 * @author wubiao21 2020年08月24日 11:14:21
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}