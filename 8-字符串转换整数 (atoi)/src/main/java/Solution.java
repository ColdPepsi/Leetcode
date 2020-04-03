/**
 * @author WuBiao
 * @date 2020/4/3 14:27
 */
public class Solution {
    /**
     * @param str
     * @return int
     * @description 注意怎么判断溢出
     * @author WuBiao
     * @date 2020/4/3 14:42
     */
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        boolean positive = true;
        int index = 0;
        if (str.charAt(index) == '-') {
            positive = false;
            index++;
        } else if (str.charAt(index) == '+') {
            index++;
        } else if (!Character.isDigit(str.charAt(index))) {
            return 0;//其他字符返回0
        }
        int res = 0;
        //res*10+digit<integer.max 得到 res<(integer.max-digit)/10;
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            int digit = str.charAt(index) - '0';
            if (res > (Integer.MAX_VALUE - digit) / 10) {//溢出
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            index++;
        }
        return positive ? res : -res;
    }
}