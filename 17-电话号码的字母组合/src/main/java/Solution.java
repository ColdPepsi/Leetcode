import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/3/22 11:36
 */
public class Solution {
    //建立键盘与字母的映射
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * @param digits
     * @return java.util.List<java.lang.String>
     * @description 标准的回溯
     * @author WuBiao
     * @date 2020/3/22 11:59
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();//保存结果集
        if (digits == null || digits.length() == 0) {
            return res;
        }
        backTracking(digits, new StringBuilder(), res);
        return res;
    }

    /**
     * @param digits
     * @param prefix
     * @param res
     * @return void
     * @description 回溯算法
     * @author WuBiao
     * @date 2020/3/22 11:59
     */
    private void backTracking(String digits, StringBuilder prefix, List<String> res) {
        if (prefix.length() == digits.length()) {//找到结果集,保存结果
            res.add(prefix.toString());
            return;
        }
        int currentDigits = digits.charAt(prefix.length()) - '0';//看看现在该处理digits的哪位数了
        String str = KEYS[currentDigits];//取出该数字映射的所有字母
        for (int i = 0; i < str.length(); i++) {//对str的每个字符都进行回溯
            prefix.append(str.charAt(i));
            backTracking(digits, prefix, res);//进行深一层的回溯的时候，prefix的长度变了，根据长度指向digites的下一位数字
            prefix.deleteCharAt(prefix.length() - 1);//删除prefix最后一位，恢复现场，因为要遍历str的下一位
        }
    }
}