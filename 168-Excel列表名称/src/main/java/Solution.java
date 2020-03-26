/**
 * @author WuBiao
 * @date 2020/3/26 17:09
 */
public class Solution {
    /**
     * @param n
     * @return java.lang.String
     * @description 26进制
     * @author WuBiao
     * @date 2020/3/26 17:16
     */
    public String convertToTitle(int n) {
        if (n == 0) {
            return "";
        }

        return convertToTitle((n - 1) / 26) + (char) ((n - 1) % 26 + 'A');
    }
}
//相当于把n换成26进制，1--A，2--B,但是模26的值是0~25
//x_3×26^2 + x_2×26 + (x_1-1) = n - 1，把等式两边同时减1；
//x_1=(n-1)%26+1，然后把x_1换成字符，(n-1)%26+1-1+‘A’=(n-1)%26+‘A’