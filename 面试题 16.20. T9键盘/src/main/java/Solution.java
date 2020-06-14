import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/6/15 0:00
 */
public class Solution {

    private static final String[] strMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> getValidT9Words(String num, String[] words) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        for (String word : words) {//对每个词进行判断
            char[] chars = word.toCharArray();
            boolean flag = true;
            for (int i = 0; i < chars.length; i++) {
                String s = strMap[num.charAt(i) - '0'];
                if (s.indexOf(chars[i]) == -1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(word);
            }
        }
        return res;
    }
}
