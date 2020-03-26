/**
 * @author WuBiao
 * @date 2020/3/26 17:30
 */
public class Solution {
    /**
     * @param n
     * @return int
     * @description 找因子中5的个数
     * @author WuBiao
     * @date 2020/3/26 17:38
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n != 0) {
            n /= 5;//每次让N除5去依次计算
            count += n;
        }
        return count;
    }
}
//一个数后面的0全部都是由2*5得到的，2出现的次数远远比5高，所以找到1---N因子包含几个5，
//1--n每隔5个数就会出现一个5，
//25由5*5构成，所以每隔25个数，会多贡献一个5
//最终5的个数是 n/5+n/25+n/125...