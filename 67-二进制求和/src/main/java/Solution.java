/**
 * @author WuBiao
 * @date 2020/3/26 17:51
 */
public class Solution {
    /**
     * @param a
     * @param b
     * @return java.lang.String
     * @description 巧妙利用进位
     * @author WuBiao
     * @date 2020/3/26 17:58
     */
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder res = new StringBuilder();
        int carry = 0;
        while (carry != 0 || i >= 0 || j >= 0) {
            if (i >= 0 && a.charAt(i--) == '1') {
                carry++;
            }
            if (j >= 0 && b.charAt(j--) == '1') {
                carry++;
            }
            res.append(carry % 2);//把carry往结果里放
            carry /= 2;
        }
        return res.reverse().toString();
    }
}