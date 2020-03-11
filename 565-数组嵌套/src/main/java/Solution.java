/**
 * @author WuBiao
 * @date 2020/3/11 20:52
 */
public class Solution {
    /**
     * @param nums
     * @return int
     * @description 如果当前元素访问了就设置为-1，因为每个元素的值不同，
     * 所以不会有两个元素跳转到同一索引处，循环外的元素不会跳转到循环里
     * @author WuBiao
     * @date 2020/3/11 22:02
     */
    public int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; nums[j] != -1; ) {//如果当前元素没访问过，就进行访问，嵌套测试
                int temp = nums[j];//先保存下当前元素
                count++;
                nums[j] = -1;//当前元素标记为已访问
                j = temp;//更新j
            }
            max = Math.max(max, count);
        }
        return max;
    }
}