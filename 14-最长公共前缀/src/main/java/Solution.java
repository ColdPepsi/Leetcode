/**
 * @author WuBiao
 * @date 2020/6/17 22:40
 */
public class Solution {
    /**
     * @param strs 字符串数组
     * @return java.lang.String
     * @description 纵向遍历
     * @author WuBiao
     * @date 2020/6/17 22:40
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int n = strs.length;
        int row = 0;
        boolean stop = false;
        while (true) {
            for (int i = 1; i < n; i++) {
                if (strs[i - 1] == null || strs[i - 1].length() <= row || strs[i] == null || strs[i].length() <= row) {
                    stop = true;
                    break;
                }
                if (strs[i].charAt(row) != strs[i - 1].charAt(row)) {
                    stop = true;
                    break;
                }
            }
            if (stop) {
                break;
            }
            row++;
        }
        return strs[0].substring(0, row);
    }
}
