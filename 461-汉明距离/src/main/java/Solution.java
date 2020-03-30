/**
 * @author WuBiao
 * @date 2020/3/30 13:53
 */
public class Solution {
    /**
     * @param x
     * @param y
     * @return int
     * @description 异或即可，不同的位异或为1
     * @author WuBiao
     * @date 2020/3/30 13:54
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}