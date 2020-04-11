/**
 * @author WuBiao
 * @date 2020/4/10 10:34
 */
public class Solution {
    /**
     * @param s
     * @return java.lang.String
     * @description 翻转每个字符串，并整体翻转
     * @author WuBiao
     * @date 2020/4/10 11:21
     */
    public String reverseWords(String s) {
        StringBuilder temp = trimString(s);
        int left = 0;
        int right = 0;
        while (left < temp.length()) {
            while (right < temp.length() && temp.charAt(right) != ' ') {
                right++;
            }
            swap(temp, left, right - 1);
            left = right + 1;
            right = left;
        }
        swap(temp, 0, temp.length() - 1);
        return temp.toString();
    }

    /**
     * @param chars
     * @param left
     * @param right
     * @return void
     * @description 翻转字符串s[left, right]
     * @author WuBiao
     * @date 2020/4/10 11:16
     */
    private void swap(StringBuilder chars, int left, int right) {
        while (left < right) {
            char temp = chars.charAt(left);
            chars.setCharAt(left++, chars.charAt(right));
            chars.setCharAt(right--, temp);
        }
    }

    /**
     * @param s
     * @return java.lang.StringBuilder
     * @description 去掉字符串s多余的空格
     * @author WuBiao
     * @date 2020/4/10 11:15
     */
    private StringBuilder trimString(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {//修剪左端空格
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {//修剪右端空格
            right--;
        }
        StringBuilder temp = new StringBuilder();
        while (left <= right) {//去掉中间多余的空格
            if (s.charAt(left) != ' ') {
                temp.append(s.charAt(left));
            } else if (temp.charAt(temp.length() - 1) != ' ') {//如果当前是空格，但是字符串最后一位不是空格，空格入队
                temp.append(' ');
            }
            left++;
        }
        return temp;
    }
}