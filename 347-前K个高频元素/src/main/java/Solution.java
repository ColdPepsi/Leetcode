import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WuBiao
 * @date 2020/3/13 12:57
 */
public class Solution {
    /**
     * @param nums
     * @param k
     * @return java.util.List<java.lang.Integer>
     * @description 使用桶排序
     * @author WuBiao
     * @date 2020/3/13 13:24
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countForNums = new HashMap<>();//存放数组中数出现的次数
        for (int num : nums) {//统计出现的次数
            countForNums.put(num, countForNums.getOrDefault(num, 0) + 1);
        }
        List[] bucket = new ArrayList[nums.length + 1];//出现次数为k的数，放在下标k处
        for (Integer num : countForNums.keySet()) {
            int count = countForNums.get(num);//获取num出现的次数
            if (bucket[count] == null) {//下标处为空先建立一个数组
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(num);//放到桶里
        }
        List<Integer> topK = new ArrayList<>();//存放最终结果
        for (int i = nums.length; i >= 0 && topK.size() < k; i--) {
            if (bucket[i] == null) {
                continue;//为空，开启下一轮
            }
            if (bucket[i].size() <= k - topK.size()) {
                topK.addAll(bucket[i]);//剩余空间够，就全放进来
            } else {
                topK.addAll(bucket[i].subList(0, k - topK.size()));//剩余空间不够，塞满即可
            }
        }
        return topK;
    }
}