/**
 * @author WuBiao
 * @date 2020/3/12 9:17
 */
public class Solution {
    /**
     * @param s
     * @return int
     * @description 构造回文字符串，从字符串中取出偶数个，分别放在字符串的两边，如果有剩余，就在中间放一个。
     * @author WuBiao
     * @date 2020/3/12 9:32
     */
    public int longestPalindrome(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int[] count = new int[128];
        //统计每个字符出现的次数
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int res = 0;
        for (int cnt : count) {
            res += (cnt / 2) * 2;//若某个数的计数为奇数个，拿出其中最大的偶数个。
        }
        if (res < s.length()) {
            //说明还有字符没使用，拿出一个，放在中心。只能放一个
            res++;
        }
        return res;
    }
}