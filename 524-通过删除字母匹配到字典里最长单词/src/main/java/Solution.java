import java.util.List;

/**
 * @author WuBiao
 * @date 2020/3/23 23:07
 */
public class Solution {
    /**
     * @param s
     * @param d
     * @return java.lang.String
     * @description 如果s可以删减字符得到target，则target是s的子序列
     * @author WuBiao
     * @date 2020/3/23 23:18
     */
    public String findLongestWord(String s, List<String> d) {
        String longWord = "";//保存最长的结果
        for (String word : d) {
            if (longWord.length() > word.length() || (longWord.length() == word.length() &&
                    longWord.compareTo(word) < 0)) {//过滤掉不符合的元素
                continue;
            }
            if (isSubSeq(s, word)) {
                longWord = word;
            }
        }
        return longWord;
    }

    /**
     * @param s
     * @param target
     * @return boolean
     * @description 看target是否是s的子序列
     * @author WuBiao
     * @date 2020/3/23 23:10
     */
    private boolean isSubSeq(String s, String target) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}