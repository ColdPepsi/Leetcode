/**
 * @author WuBiao
 * @date 2020/3/10 12:07
 */
public class Sort {
    /**
     * @param nums
     * @param left  nums的左下标
     * @param right nums的右下标
     * @return int
     * @description 把数组变成左边小于等于原来第一个元素，右边大于原来第一个元素
     * @author WuBiao
     * @date 2020/3/10 12:22
     */
    private static int partition(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] > temp) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= temp) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;//返回中间点下标
    }

    /**
     * @param nums
     * @param left
     * @param right
     * @return void
     * @description 快速排序
     * @author WuBiao
     * @date 2020/3/10 12:48
     */
    public static void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int mid = Sort.partition(nums, left, right);
        quickSort(nums, left, mid - 1);
        quickSort(nums, mid + 1, right);
    }

    /**
     * @param nums
     * @param L1
     * @param R1
     * @param L2
     * @param R2
     * @return void
     * @description 将nums数组的[L1, R1]和[L2, R2]合并成一个有序数组，两个子数组已经单独有序
     * @author WuBiao
     * @date 2020/3/10 12:55
     */
    private static void merge(int[] nums, int L1, int R1, int L2, int R2) {
        int count = R1 - L1 + R2 - L2 + 2;
        int[] temp = new int[count];
        int i = L1, j = L2, index = 0;
        while (i <= R1 && j <= R2) {
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
                temp[index++] = nums[j++];
            }
        }
        while (i <= R1) {
            temp[index++] = nums[i++];
        }
        while (j <= R2) {
            temp[index++] = nums[j++];
        }
        for (int k = 0; k < index; k++) {
            nums[L1 + k] = temp[k];//拷贝回原数组
        }
    }

    /**
     * @param nums
     * @param left
     * @param right
     * @return void
     * @description 归并排序
     * @author WuBiao
     * @date 2020/3/10 13:16
     */
    public static void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;//取中点
            mergeSort(nums, left, mid);//递归处理左右两个区间
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, mid + 1, right);//合并两个有序区间
        }
    }
}
