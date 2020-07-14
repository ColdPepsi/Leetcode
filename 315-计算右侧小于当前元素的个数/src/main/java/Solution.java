import java.util.ArrayList;
import java.util.List;

/**
 * @author wubiao21 2020年07月13日 14:01:02
 */
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int len = nums.length;
        int[] res = new int[len];//保存结果集，最后再挪到result中
        int[] temp = new int[len];//辅助数组
        int[] index = new int[len];//索引数组
        for (int i = 0; i < len; i++) {
            index[i] = i;//初始化索引数组
        }
        countSmaller(nums, 0, len - 1, res, temp, index);
        for (int count : res) {
            result.add(count);
        }
        return result;
    }

    private void countSmaller(int[] nums, int left, int right, int[] res, int[] temp, int[] index) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        countSmaller(nums, left, mid, res, temp, index);
        countSmaller(nums, mid + 1, right, res, temp, index);
        if (nums[index[mid]] <= nums[index[mid + 1]]) {//套一层index
            return;//nums已经有序，就不用合并
        }
        mergeAndCount(nums, left, mid, right, res, temp, index);
    }

    private void mergeAndCount(int[] nums, int left, int mid, int right, int[] res, int[] temp, int[] index) {
        for (int i = left; i <= right; i++) {
            temp[i] = index[i];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {//i已经到头
                index[k] = temp[j++];
            } else if (j > right) {//j已经到头
                index[k] = temp[i++];
                res[index[k]] += right - mid;//更新累加器
            } else if (nums[temp[i]] <= nums[temp[j]]) {//小于等于号 保持稳定性
                index[k] = temp[i++];
                res[index[k]] += j - mid - 1;//更新累加器
            } else {
                index[k] = temp[j++];
            }
        }
    }
}