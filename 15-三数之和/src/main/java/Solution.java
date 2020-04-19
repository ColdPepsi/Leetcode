import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/4/12 15:12
 */
public class Solution {
    /**
     * @param nums
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @description 排序+双指针，先固定最左端。双指针找后面两个
     * @author WuBiao
     * @date 2020/4/12 15:42
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        /*backTracking(res, new ArrayList<Integer>(), nums, 0, 0, 0);*/
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {//nums[i]>0，则i后面的所有数都大于0，相加已经不可能等于0了。
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;//去重
            }
            doublePointers(nums, i, i + 1, nums.length - 1, res);//从i的后面开始找，如果从坐标0开始找，会出现重复结果
        }
        return res;
    }

    //用回溯法時間会超时
    /*private void backTracking(List<List<Integer>> res, List<Integer> prefix,
                              int[] nums, int index, long target, long currSum) {
        if (prefix.size() == 3) {
            if (target == currSum) {
                res.add(new ArrayList<Integer>(prefix));
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;//去重
            }
            prefix.add(nums[i]);
            //下一个index从i+1开始，不是index+1！！
            backTracking(res, prefix, nums, i + 1, target, currSum + nums[i]);
            prefix.remove(prefix.size() - 1);
        }
    }*/
    private void doublePointers(int[] nums, int curr, int left, int right, List<List<Integer>> res) {
        while ((left < right)) {
            int sum = nums[curr] + nums[left] + nums[right];
            if (sum == 0) {
                res.add(Arrays.asList(nums[curr], nums[left], nums[right]));
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;//去重
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;//去重
                }
                left++;//找到相加等于0的话，继续寻找
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }
}