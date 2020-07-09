import java.util.ArrayList;
import java.util.List;

/**
 * @author wubiao21 2020年07月09日 19:47:13
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {//连续的话跳过
                continue;
            }
            //出现区间右端点
            if (i == j) {
                res.add(String.valueOf(nums[i]));
            } else {
                res.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return res;
    }
}