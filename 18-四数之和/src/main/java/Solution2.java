import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/4/13 20:14
 */
public class Solution2 {
    /**
     * @param nums
     * @param target
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @description 回溯法
     * @author WuBiao
     * @date 2020/4/13 20:29
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        backTracking(res, new ArrayList<Integer>(), nums, 0, target, 0);
        return res;
    }

    /**
     * @param res     结果集
     * @param prefix  前缀
     * @param nums    数组
     * @param index   当前开始的索引
     * @param target  目标和
     * @param currSum 当前和
     * @return void
     * @description 回溯法，加剪枝
     * @author WuBiao
     * @date 2020/4/13 20:28
     */
    private void backTracking(List<List<Integer>> res, List<Integer> prefix,
                              int[] nums, int index, long target, long currSum) {
        if (prefix.size() == 4) {
            if (target == currSum) {
                res.add(new ArrayList<Integer>(prefix));
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;//去重
            }
            if (nums[i] > 0 && nums[i] > target - currSum) {
                break;//剪枝，后面的数越加越大，不可能等于target了
            }
            if (prefix.size() == 1 && (currSum + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target
                    || (i + 2 < nums.length && currSum + nums[i] + nums[i + 1] + nums[i + 2] > target))) {
                break;//这三条剪枝是测试currSum是不是合理解，不是的话就终止，返回上一层
            } else if (prefix.size() == 2 && (currSum + nums[nums.length - 1] + nums[nums.length - 2] < target
                    || (i + 1 < nums.length && currSum + nums[i] + nums[i + 1] > target))) {
                break;
            } else if (prefix.size() == 3 && (currSum + nums[nums.length - 1] < target || currSum + nums[i] > target)) {
                break;
            }
            prefix.add(nums[i]);
            //下一个index从i+1开始，不是index+1！！
            backTracking(res, prefix, nums, i + 1, target, currSum + nums[i]);
            prefix.remove(prefix.size() - 1);
        }
    }
}