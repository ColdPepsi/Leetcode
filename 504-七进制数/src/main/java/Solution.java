/**
 * @author WuBiao
 * @date 2020/3/26 15:39
 */
public class Solution {
    /**
     * @param num
     * @return java.lang.String
     * @description 除7取余法
     * @author WuBiao
     * @date 2020/3/26 15:48
     */
    public String convertToBase7(int num) {
        /*if (num < 7 && num > -7) {
            return String.valueOf(num);
        }
        boolean isNegative = num < 0;//记录num的正负号
        if (isNegative) {
            num = -num;
        }
        StringBuilder res = new StringBuilder();//保存结果
        while (num > 0) {
            res.append(num % 7);
            num /= 7;
        }
        res = res.reverse();//翻转结果
        return isNegative ? "-" + res.toString() : res.toString();*/
        return Integer.toString(num, 7);//Integer此静态方法,可以将一个整数转换为 radix 进制表示的字符串
    }
}