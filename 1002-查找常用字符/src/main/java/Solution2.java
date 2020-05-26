import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/5/26 14:49
 */
public class Solution2 {
    public List<String> commonChars(String[] A) {
        int[] counts = new int[26];
        Arrays.fill(counts, 101);
        for (String s : A) {
            int[] tempCount = new int[26];
            for (int i = 0; i < s.length(); i++) {
                tempCount[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < tempCount.length; i++) {
                counts[i] = Math.min(counts[i], tempCount[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                for (int j = 0; j < counts[i]; j++) {
                    res.add(String.valueOf((char) (i + 'a')));
                }
            }
        }
        return res;
    }
}
