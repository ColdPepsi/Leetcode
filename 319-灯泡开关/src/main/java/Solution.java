/**
 * @author WuBiao
 * @date 2020/4/3 21:28
 */
public class Solution {
    /**
     * @param n
     * @return int
     * @description 看有多少个完全平方数
     * @author WuBiao
     * @date 2020/4/3 21:32
     */
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);//看小于n有多少个完全平方数
    }
}
//灯泡初始状态时灭，
//第18个灯泡会在1,2,3,6,9,18轮翻转。
//第36个灯泡会在1,2,3,4,6,9,12,18,36轮翻转。
//
//规律显而易见，只有在轮数是该位置因数的时候才会执行翻转操作。
//
//于是我们回答了那个问题：只要找到该位置的所有因数个数，我们就知道该位置翻转了多少次。
//
//更进一步的，除了完全平方数，因数都是成对出现的，这意味着实际起到翻转作用(0->1)的，只有
//完全平方数而已。完全平方数的因子个数是奇数，最后一定是亮的
//
//作者：ooolize-2
//链接：https://leetcode-cn.com/problems/bulb-switcher/solution/ru-guo-bu-shi-mo-ni-guo-cheng-bu-neng-tong-guo-shu/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。