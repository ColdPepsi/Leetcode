import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/6/17 22:45
 */
public class Solution {
    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        Arrays.sort(chars);//排序是为了后面去重
        List<String> res = new ArrayList<>();
        backTracking(0, new StringBuilder(), new boolean[chars.length], res, chars);
        return res.toArray(new String[0]);
    }

    /**
     * @param index      当前处理的下标
     * @param prefix     前缀
     * @param hasVisited 状态数组
     * @param res        结果集
     * @param chars      字符串
     * @return void
     * @description 回溯法
     * @author WuBiao
     * @date 2020/6/17 22:46
     */
    private void backTracking(int index, StringBuilder prefix, boolean[] hasVisited, List<String> res, char[] chars) {
        if (prefix.length() == chars.length) {
            res.add(prefix.toString());
            return;
        }
        for (int i = 0; i < hasVisited.length; i++) {
            if (i > 0 && chars[i] == chars[i - 1] && !hasVisited[i - 1]) {
                continue;
            }
            if (!hasVisited[i]) {
                hasVisited[i] = true;
                prefix.append(chars[i]);
                backTracking(i, prefix, hasVisited, res, chars);
                prefix.deleteCharAt(prefix.length() - 1);
                hasVisited[i] = false;
            }
        }
    }
}
