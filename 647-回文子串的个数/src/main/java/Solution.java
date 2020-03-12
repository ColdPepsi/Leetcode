/**
 * @author WuBiao
 * @date 2020/3/12 12:24
 */
public class Solution {
    /**
     * @param s
     * @return int
     * @description 每个字符向两侧延伸，统计个数
     * @author WuBiao
     * @date 2020/3/12 14:31
     */
    public int countSubstrings(String s) {
        int count = 0;
        //数组中的每个字符都要运行延伸函数
        for (int i = 0; i < s.length(); i++) {
            //回文长度可能为奇数也可能为偶数，两种都要累加
            count += countSubstrings(s, i, i);//当长度为奇数时，s[i]为中心向两端延伸
            count += countSubstrings(s, i, i + 1);//当长度为偶数时，s[i],s[i+1]为中心向两端延伸
        }
        return count;
    }

    /**
     * @param s
     * @param left  回文左区间
     * @param right 回文右区间
     * @return int
     * @description 向两侧延伸，来查找回文字符串个数
     * @author WuBiao
     * @date 2020/3/12 14:55
     */
    private int countSubstrings(String s, int left, int right) {
        int count = 0;
        //向两侧延伸，如果相等，则计数加1
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) {
            count++;
        }
        return count;
    }
}