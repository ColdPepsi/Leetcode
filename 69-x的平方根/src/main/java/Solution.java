/**
 * @author WuBiao
 * @date 2020/3/23 20:04
 */
public class Solution {
    /**
     * @param x
     * @return int
     * @description 一个数 x 的开方 sqrt 一定在 1 ~ x 之间，并且满足 sqrt == x / sqrt。
     * 可以利用二分查找在 0 ~ x 之间查找 sqrt。
     * 对于 x = 8，它的开方是 2.82842...，最后应该返回 2 而不是 3。
     * 在循环条件为 l <= h 并且循环退出时，h 总是比 l 小 1，
     * 也就是说 h = 2，l = 3，因此最后的返回值应该为 h 而不是 l。
     * @author WuBiao
     * @date 2020/3/23 20:33
     */
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (sqrt > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}