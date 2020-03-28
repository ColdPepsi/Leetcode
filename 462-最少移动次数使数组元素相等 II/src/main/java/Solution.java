import java.util.Arrays;

/**
 * @author WuBiao
 * @date 2020/3/27 21:10
 */
public class Solution {
    /**
     * @param nums
     * @return int
     * @description 找到中位数，最短路径就是每个数都移动到中位数
     * @author WuBiao
     * @date 2020/3/27 21:54
     */
    public int minMoves2(int[] nums) {
        /*int move = 0;
        int mid = findKthNum(nums, 0, nums.length - 1, nums.length / 2 + 1);
        for (int num : nums) {
            move += Math.abs(num - mid);
        }
        return move;*/
        Arrays.sort(nums);//排序找中位数，不需要计算出中位数 因为 right-mid+（mid-left）=right-left;
        int i = 0;
        int j = nums.length - 1;
        int move = 0;
        while (i < j) {
            move += nums[j] - nums[i];
            i++;
            j--;
        }
        return move;
    }

    /**
     * @param nums
     * @param left
     * @param right
     * @return int
     * @description 结束后，枢纽左边的元素均不大于枢纽，右边元素均大于枢纽
     * @author WuBiao
     * @date 2020/3/27 21:37
     */
    private int partition(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] > temp) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= temp) {//注意等号的位置
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }

    /**
     * @param nums
     * @param left
     * @param right
     * @param K
     * @return int
     * @description 返回数组的第K小的数，随机选择算法
     * @author WuBiao
     * @date 2020/3/27 21:50
     */
    private int findKthNum(int[] nums, int left, int right, int K) {
        if (left == right) {
            return nums[right];//递归边界
        }
        int position = partition(nums, left, right);
        int M = position - left + 1;//nums[position]是nums的第M小
        if (M == K) {
            return nums[position];
        } else if (M < K) {//第K大在右边
            return findKthNum(nums, position + 1, right, K - M);//注意K-M
        } else {//在左边
            return findKthNum(nums, left, position - 1, K);
        }
    }
}