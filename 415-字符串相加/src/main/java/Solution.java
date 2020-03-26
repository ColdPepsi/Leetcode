/**
 * @author WuBiao
 * @date 2020/3/26 18:06
 */
public class Solution {
    /**
     * @param num1
     * @param num2
     * @return java.lang.String
     * @description 思想类似67题
     * @author WuBiao
     * @date 2020/3/26 18:10
     */
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (carry != 0 || i >= 0 || j >= 0) {
            if (i >= 0) {
                carry += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += num2.charAt(j--) - '0';
            }
            res.append(carry % 10);
            carry /= 10;
        }
        return res.reverse().toString();
    }
}