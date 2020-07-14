/**
 * @author wubiao21 2020年07月13日 14:15:30
 */
public class Solution {
    /**
     * 通过归并排序来求逆序对数
     *
     * @param nums 原始数组
     * @return 返回solution的逆序对数
     */
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int[] temp = new int[nums.length];
        return reversePairs(nums, 0, nums.length - 1, temp);
    }

    /**
     * 通过归并排序求nums[left...right]的逆序对数
     *
     * @param nums  数组
     * @param left  左下标
     * @param right 右下标
     * @param temp  辅助数组
     * @return 返回逆序对数
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {//递归边界
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);//获得左半区间的逆序对数
        int rightPairs = reversePairs(nums, mid + 1, right, temp);//获得右半区间的逆序对数
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);//求跨区间的逆序对数，调用下面的mergeAndCount或者mergeAndCount2都行
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[left...mid]有序，nums[mid+1...right]有序
     * 后有序数组出列时，更新计数器
     * 此时，前有序数组剩下的，都大于出列的数，剩下的个数累加到计数器上
     *
     * @param nums  数组
     * @param left  左区间
     * @param mid   左区间右端点
     * @param right 右区间
     * @param temp  辅助数组
     * @return 跨区间的逆序对数
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        //先拷贝到辅助数组
        if (right + 1 - left >= 0) System.arraycopy(nums, left, temp, left, right + 1 - left);
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if (j == right + 1) {
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                count += (mid - i + 1);//增加逆序对数
            }
        }
        return count;
    }

    /**
     * 前有序数组数列时，更新计数器
     * 此时，后有序数列已经出列的元素都不大于自己，后有序数列已经出列的元素数累加到计数器
     */
    private int mergeAndCount2(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i > mid) {//i已经走到尽头
                nums[k] = temp[j++];
            } else if (j > right) {//j走到尽头
                nums[k] = temp[i++];
                count += right - mid;//增加计数，加上整个右区间
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
                count += j - mid - 1;//增加计数，加上右区间出列的总数
            } else {
                nums[k] = temp[j++];
            }
        }
        return count;
    }
}