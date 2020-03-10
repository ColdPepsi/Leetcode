/**
 * @author WuBiao
 * @date 2020/3/10 10:49
 */
public class Solution {
    /**
     * @param nums
     * @return void
     * @description 找到非0值依次往前覆盖
     * @author WuBiao
     * @date 2020/3/10 10:59
     */
    public void moveZeroes(int[] nums) {
        int index = 0;//指定当前可以覆盖的坐标
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;//找到一个非0值就往前覆盖
            }
        }
        //遍历一遍后数组非0数都挪到了前端，把后面置0
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}