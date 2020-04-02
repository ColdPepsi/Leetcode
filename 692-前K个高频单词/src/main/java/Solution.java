import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WuBiao
 * @date 2020/4/2 19:51
 */
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);//统计每个单词出现的次数
        }
        List<String>[] buckets = new List[words.length + 1];
        for (String word : count.keySet()) {//把词放在数组根据频率放在数组里
            int num = count.get(word);
            if (buckets[num] == null) {
                buckets[num] = new ArrayList<>();
            }
            buckets[num].add(word);
        }
        List<String> res = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) {
                continue;
            }
            buckets[i].sort(String::compareTo);//同一个频率按照字母序排序
            if (buckets[i].size() <= k - res.size()) {//能放下的话全放下
                res.addAll(buckets[i]);
            } else {//放不下的话看能放下多少
                res.addAll(buckets[i].subList(0, k - res.size()));
            }
        }
        return res;
    }
}