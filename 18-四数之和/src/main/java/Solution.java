import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/4/12 9:57
 */
public class Solution {
    /**
     * @param nums   数组
     * @param target 目标和
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @description 排序加双指针，固定最左边两个元素，然后双指针取剩下的两个元素
     * @author WuBiao
     * @date 2020/4/12 18:12
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;//去重
            }
            int mini = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];//因为是排好序的，最左边四个相加就是最小值
            if (mini > target) {
                break;//最小值大于target，后面越加越大根本没戏。
            }
            int maxi = nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3];
            if (maxi < target) {//nums[i]开头所能组成的四元组最大值就是nums[i]加数组最后3个数
                continue;//如果还小于target说明nums[i]开头没戏，进行下一个测试
            }
            for (int j = i + 1; j < len - 2; j++) {//j从i向下一个开始
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;//去重
                }
                int minij = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];//nums[i]，nums[j]开头组成4元组的最小和
                if (minij > target) {
                    break;
                }
                int maxij = nums[i] + nums[j] + nums[len - 1] + nums[len - 2];//nums[i]，nums[j]开头组成4元组的最大和
                if (maxij < target) {
                    continue;
                }
                doublePointers(i, j, j + 1, len - 1, nums, target, res);
            }
        }
        return res;
    }
    /**
     * @param i
     * @param j
     * @param left   区间左端点
     * @param right  区间右端点
     * @param nums   数组
     * @param target 目标和
     * @param res    结果集
     * @return void
     * @description 双指针
     * @author WuBiao
     * @date 2020/4/12 18:11*/
    private void doublePointers(int i, int j, int left, int right, int[] nums, int target, List<List<Integer>> res) {
        while (left < right) {
            int sum = nums[i] + nums[j] + nums[left] + nums[right];
            if (sum == target) {//找到结果
                res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;//去重
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;//去重
                }
                left++;
                right--;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
    }
}