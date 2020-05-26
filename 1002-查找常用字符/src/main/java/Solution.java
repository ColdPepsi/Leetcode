import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/5/26 14:30
 */
public class Solution {
    public List<String> commonChars(String[] A) {
        int[][] counts = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                counts[i][A[i].charAt(j) - 'a']++;
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int min = 101;
            for (int j = 0; j < A.length; j++) {
                min = Math.min(min, counts[j][i]);
            }
            if (min > 0) {
                for (int k = 0; k < min; k++) {
                    res.add(String.valueOf((char) (i + 'a')));
                }
            }
        }
        return res;
    }
}
