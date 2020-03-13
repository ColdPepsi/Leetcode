/**
 * @author WuBiao
 * @date 2020/3/13 15:12
 */
public class Solution {
    /**
     * @param nums
     * @return void
     * @description 荷兰国旗问题，三路快排
     * @author WuBiao
     * @date 2020/3/13 15:22
     */
    public void sortColors(int[] nums) {
        int p0 = -1;//po表示0的最右边界
        int p2 = nums.length;//p2表示2的最左边界
        int curr = 0;//表示当前元素下标
        while (curr < p2) {
            switch (nums[curr]) {
                case 0:
                    swap(nums, ++p0, curr++);//curr加1，左边过来的元素已经扫描
                    break;
                case 2:
                    swap(nums, --p2, curr);//curr不用加，因为右边过来的元素，还没有扫描
                    break;
                default://等于1，curr直接跳过
                    curr++;
            }
        }
    }

    /**
     * @param nums
     * @param i
     * @param j
     * @return void
     * @description 交换两个数
     * @author WuBiao
     * @date 2020/3/13 15:15
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}