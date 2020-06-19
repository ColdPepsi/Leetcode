/**
 * @author WuBiao
 * @date 2020/6/19 23:12
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (!isEqual(s.charAt(left++), s.charAt(right--))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param a 字符参数
     * @param b 字符参数
     * @return boolean
     * @description 判断两个字符是否相等
     * @author WuBiao
     * @date 2020/6/19 23:13
     */
    private boolean isEqual(char a, char b) {
        if (Character.isLetter(a) && Character.isLetter(b)) {
            return (int) Character.toLowerCase(a) == (int) Character.toLowerCase(b);
        }
        return (int) a == (int) b;
    }
}
