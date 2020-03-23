/**
 * @author WuBiao
 * @date 2020/3/23 22:05
 */
public class Solution {
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {//碰到不相等的字符
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);//尝试删掉左边一个或者右边一个
            }
        }
        return true;
    }

    /**
     * @param s
     * @param left
     * @param right
     * @return boolean
     * @description 判断是否是回文
     * @author WuBiao
     * @date 2020/3/23 22:11
     */
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}