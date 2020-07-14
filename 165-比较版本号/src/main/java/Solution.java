/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年07月14日 11:19:47
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version1.length() == 0 || version2 == null || version2.length() == 0) {
            return 0;
        }
        String[] version_1 = version1.split("\\.");//以点分割要用"\\."
        String[] version_2 = version2.split("\\.");
        int len1 = version_1.length;
        int len2 = version_2.length;
        int maxLen = Math.max(len1, len2);
        for (int i = 0; i < maxLen; i++) {
            int num1 = i < len1 ? Integer.parseInt(version_1[i]) : 0;
            int num2 = i < len2 ? Integer.parseInt(version_2[i]) : 0;
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }
}