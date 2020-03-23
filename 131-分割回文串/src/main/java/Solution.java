import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/3/23 15:48
 */
public class Solution {
    /**
     * @param s
     * @return java.util.List<java.util.List < java.lang.String>>
     * @description 回溯
     * @author WuBiao
     * @date 2020/3/23 16:10
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        backTracking(s, res, new ArrayList<String>());
        return res;
    }

    /**
     * @param s
     * @param res
     * @param prefix
     * @return void
     * @description 回溯
     * @author WuBiao
     * @date 2020/3/23 16:10
     */
    private void backTracking(String s, List<List<String>> res, List<String> prefix) {
        if (s.length() == 0) {
            res.add(new ArrayList<String>(prefix));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)) {//如果s的[0,i]是回文
                prefix.add(s.substring(0, i + 1));//保存[0,i]
                backTracking(s.substring(i + 1), res, prefix);//回溯剩下的
                prefix.remove(prefix.size() - 1);//恢复现场
            }
        }
    }

    /**
     * @param str
     * @param left
     * @param right
     * @return boolean
     * @description 判断str在[left, right]内是否是回文
     * @author WuBiao
     * @date 2020/3/23 15:57
     */
    private boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}