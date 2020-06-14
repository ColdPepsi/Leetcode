/**
 * @author WuBiao
 * @date 2020/6/15 0:03
 */
public class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        if (s.length() < 2) {
            return 1;
        }
        int pre2 = 1;
        int pre1 = 1;
        int current = 0;
        for (int i = 1; i < s.length(); i++) {
            current = pre1;
            String temp = s.substring(i - 1, i + 1);//取i和i-1位
            int integer = Integer.parseInt(temp);
            if (integer >= 10 && integer <= 25) {
                //i既可以自己一位，也可以和前面组合
                current += pre2;
            }
            pre2 = pre1;
            pre1 = current;
        }
        return current;
    }
}
//dp[i]表示以num[i]为末尾的翻译总数
//dp[i]如果自己一位，则dp[i]=dp[i-1]
//dp[i]如果和前面一位组合，则dp[i]=dp[i-2];