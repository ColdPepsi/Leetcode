/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：要注意小细节
 *
 * @author wubiao21 2020年11月09日 10:58:15
 */
public class Solution {
    public int compress(char[] chars) {
        int len = chars.length;
        int currCount = 1;
        int limit = -1;//[0,limit]表示修改后的字符串区间
        for (int i = 1; i <= len; i++) {//这里i要能取到len，因为最后一个字符串的结果要写入数组
            if (i < len && chars[i] == chars[i - 1]) {
                currCount++;//统计有多少个字符连续
            } else {//出现不连续的字符或者数组遍历完了
                chars[++limit] = chars[i - 1];//先把字符拷到数组前面
                if (currCount > 1) {//计数大于1的话拷贝计数
                    String str = String.valueOf(currCount);
                    for (int j = 1; j <= str.length(); j++) {
                        chars[limit + j] = str.charAt(j - 1);
                    }
                    limit = limit + str.length();//更新preLeft的值
                }
                currCount = 1;//计数器置1
            }
        }
        return limit + 1;
    }
}