/**
 * @author WuBiao
 * @date 2020/3/12 12:36
 */
public class Solution {
    /**
     * @param x
     * @return boolean
     * @description 反转字符串的后半部分
     * @author WuBiao
     * @date 2020/3/12 12:46
     */
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {//负数，或者x是10的倍数// 直接返回false
            return false;
        }
        int revertedNum = 0;
        while (x > revertedNum) {
            int temp = x % 10;//取下最后一位
            revertedNum = revertedNum * 10 + temp;
            x /= 10;
        }
        //循环完成后x<=revertedNum，后半部分翻转完了
        return x == revertedNum || revertedNum / 10 == x;//当x位数为奇数是，revertedNum会多一位，需要去掉最后一位
    }
}