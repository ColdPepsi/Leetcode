/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：难点主要是处理Z,防止越界，如zb,zbz
 *
 * @author wubiao21 2020年11月12日 13:56:39
 */
public class Solution {
    public String alphabetBoardPath(String target) {
        int[][] paths = new int[26][2];
        for (int i = 0; i < 26; i++) {//建立字母与坐标的映射
            paths[i][0] = i / 5;
            paths[i][1] = i % 5;
        }
        char preChar = 'a';
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (preChar > c) {
                //先往上再往左右，不然如果出发点是Z容易越界
                int count = paths[preChar - 'a'][0] - paths[c - 'a'][0];
                for (int j = 0; j < count; j++) {
                    res.append('U');
                }
                count = paths[preChar - 'a'][1] - paths[c - 'a'][1];
                if (count > 0) {
                    for (int j = 0; j < count; j++) {
                        res.append('L');
                    }
                } else {
                    for (int j = -count; j > 0; j--) {
                        res.append('R');
                    }
                }
            } else if (preChar < c) {
                //先往左右再往下，不然的话如果要抵达的点是Z容易越界
                int count = paths[c - 'a'][1] - paths[preChar - 'a'][1];
                if (count > 0) {
                    for (int j = 0; j < count; j++) {
                        res.append('R');
                    }
                } else {
                    for (int j = -count; j > 0; j--) {
                        res.append('L');
                    }
                }
                count = paths[c - 'a'][0] - paths[preChar - 'a'][0];
                for (int j = 0; j < count; j++) {
                    res.append('D');
                }
            }
            res.append('!');
            preChar = c;
        }
        return res.toString();
    }
}