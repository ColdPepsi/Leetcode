/**
 * @author WuBiao
 * @date 2020/4/4 17:38
 */
public class Solution {

    public int findKthNumber(int n, int k) {
        int curr = 1;
        k -= 1;
        while (k > 0) {
            int count = getCount(n, curr, curr + 1);//计算以curr开头的前缀有多少个
            if (count > k) {//说明第k个数就在以curr开头的前缀中
                k--;//k前进一步，curr向下增加一层
                curr *= 10;
            } else {
                curr++;//curr向右移动一层
                k -= count;
            }
        }
        return curr;
    }

    private int getCount(int n, long prefix, long next) {
        int count = 0;
        while (prefix <= n) {
            count += (int) (Math.min(n + 1, next) - prefix);
            prefix *= 10;
            next *= 10;
        }
        return count;
    }
}