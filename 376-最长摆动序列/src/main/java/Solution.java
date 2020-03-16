/**
 * @author WuBiao
 * @date 2020/3/15 21:35
 */
public class Solution {
    /**
     * @description 动态规划，难。。
     * @param nums
     * @author WuBiao
     * @return int
     * @date 2020/3/16 20:43
    */
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int up = 1;//up[i]表示截止到nums[i]结尾元素是上升的最长序列，nums[i]不一定是序列的结尾
        int down = 1;//down[i]表示截止到nums[i]结尾元素是下降的最长序列，num[i]不一定是序列的结尾
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;//如果nums[i] > nums[i - 1]，up[i]=down[j-1]+1
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;//如果num[i]<nums[i-1], down[i]=up[j-1]+1
            }
        }
        return Math.max(up, down);
    }
}
//up[i]是前i个元素中，摆动序列以上升元素结尾的最长子序列长度；
//down[i]是前i个元素中，摆动序列以下降元素结尾的最长子序列长度。
// 例如，对于序列【3, 2, 4, 5, 7】，有： up[] = 【1, 1, 2, 3, 3】
// down[] = 【1, 2, 2, 2, 2】 以第三个元素为例（为了便于描述，数组下标从1开始），down[3] = 2，
// 也就是子序列【3, 2, 4】中的摆动序列以下降元素结尾的最长子序列的长度是2，
// 即【3, 2】，4并不在该最长摆动子序列中。
//
//有了上面概念，那么就容易得出题解中描述的状态转移方程了：
// 1、对于nums[i] > nums[i-1]，假设up[i-1] = x，
// 有以下事实：如果前i-1个元素中以下降元素结尾的最长摆动序列以元素i-1结尾，
// 显然up[i] = down[i-1] + 1；如果前i-1个元素中以下降元素结尾的最长摆动子序列不以元素i-1结尾，
// 那么必然存在元素nums[j]（0 <= j < i-1），有nums[j] < nums[i-1]，
// （不取等号的原因是，如果nums[j] = nums[i-1]，可以选择元素i-1而不选择元素j），
// 必然nums[j] < nums[i]，那么也可以得出 up[i] = down[j] + 1 = down[i-1] + 1；
// 2、对于nums[i] < nums[i-1]，与上面相反论证便是了；
// 3、对于nums[i] == nums[j-1]，
// 正如1所说，如果存在连续两个元素相同，那么以最后一个元素结尾，而忽略前面一个元素，up和down都不需要改变。