import java.util.List;

/**
 * @author WuBiao
 * @date 2020/5/26 17:08
 */
public class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int maxLen = -1;
        int count = 0;
        for (List<Integer> num : nums) {
            count += num.size();
            maxLen = Math.max(maxLen, num.size());
        }
        int index = 0;
        int[] ret = new int[count];
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i; j >= 0; j--) {
                int sub = i - j;
                if (sub < nums.get(j).size()) {
                    ret[index++] = nums.get(j).get(sub);
                }
            }
        }
        int temp1 = nums.size() + maxLen - 1;
        int temp2 = nums.size() - 1;
        for (int i = nums.size(); i < temp1; i++) {
            for (int j = temp2; j >= 0; j--) {
                int sub = i - j;
                if (sub < nums.get(j).size()) {
                    ret[index++] = nums.get(j).get(sub);
                }
            }
        }
        return ret;
    }
}