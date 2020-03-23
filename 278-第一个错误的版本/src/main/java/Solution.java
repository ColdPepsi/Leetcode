/**
 * @author WuBiao
 * @date 2020/3/23 21:44
 */
public class Solution extends VersionControl {
    /**
     * @param n
     * @return int
     * @description 如果m个版本出错，第一个出错的一定在[1,m]之间
     * @author WuBiao
     * @date 2020/3/23 21:45
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;//防止溢出
            if (isBadVersion(mid)) {
                right = mid;//mid右边元素不可能是第一个出错的元素，因为mid错了
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}