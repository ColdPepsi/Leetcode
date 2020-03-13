import java.util.HashMap;
import java.util.Map;

/**
 * @author WuBiao
 * @date 2020/3/13 13:56
 */
public class Solution {
    /**
     * @param s
     * @return java.lang.String
     * @description 还是应用桶排序
     * @author WuBiao
     * @date 2020/3/13 14:17
     */
    public String frequencySort(String s) {
        Map<Character, Integer> countForChar = new HashMap<>();//存放字符出现的次数
        for (char c : s.toCharArray()) {
            countForChar.put(c, countForChar.getOrDefault(c, 0) + 1);
        }
        StringBuilder[] bucket = new StringBuilder[s.length() + 1];
        for (Character character : countForChar.keySet()) {
            int count = countForChar.get(character);//获取出现的次数
            if (bucket[count] == null) {
                bucket[count] = new StringBuilder();
            }
            for (int i = 0; i < count; i++) {
                bucket[count].append(character);//加到桶里,出现几次加几次
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] == null) {
                continue;//为空直接跳过
            }
            res.append(bucket[i]);//加到结果集里
        }
        return res.toString();
    }
}