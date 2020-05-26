import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WuBiao
 * @date 2020/5/26 18:24
 */
public class Solution2 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            count += nums.get(i).size();
            for (int j = 0; j < nums.get(i).size(); j++) {
                if (!map.containsKey(i + j)) {
                    map.put(i + j, new ArrayList<>());
                }
                map.get(i + j).add(nums.get(i).get(j));
            }
        }
        int[] ans = new int[count];
        int index = 0;
        for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
            for (int i = integerListEntry.getValue().size() - 1; i >= 0; i--) {
                ans[index++] = integerListEntry.getValue().get(i);
            }
        }
        return ans;
    }
}