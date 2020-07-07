/**
 * 类Solution.java的实现描述：400-第N个数字
 *
 * @author wubiao21 2020年07月07日 10:11:20
 */
public class Solution {
    public int findNthDigit(int n) {
        n--;//n的索引从0开始
        for (int digits = 1; digits < 11; digits++) {//digits表示几位数，从1位数到10位数测试
            long firstNum = (long) Math.pow(10, digits - 1);//firstNum表示几位数的第一个数，如1，10，100等
            long len = 9 * firstNum * digits;
            if (n < len) {//9 * firstNum * digits是当前区间长度
                //firstNum + n / digits是对应的数字
                //n % digits 是对应数子上的对应位数
                return String.valueOf(firstNum + n / digits).charAt(n % digits) - '0';
            }
            n -= len;
        }
        return 0;
    }
    //1~9，      9 个1位数
    //10~99，    90个2位数
    //100~999， 900个3位数
}