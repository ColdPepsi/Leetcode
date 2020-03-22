import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/3/22 15:22
 */
public class Solution {
    /**
     * @param s
     * @return java.util.List<java.lang.String>
     * @description 回溯
     * @author WuBiao
     * @date 2020/3/22 15:52
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 4 || s.length() > 12) {//小于4位或者大于12位肯定凑不成
            return res;
        }
        backTracking(0, new StringBuilder(), res, s);
        return res;
    }

    /**
     * @param k      表示现在进行到IP地址的第几个段，取值 0~3，表示IP地址的4段
     * @param prefix 保存正在拼接的IP地址
     * @param res    保存结果集
     * @param s      给定的字符串
     * @return void
     * @description 循环取s开头的[0, i]位进行回溯，符合答案放入结果集
     * @author WuBiao
     * @date 2020/3/22 15:26
     */
    private void backTracking(int k, StringBuilder prefix, List<String> res, String s) {
        if (k == 4 || s.length() == 0) {
            if (k == 4 && s.length() == 0) {//找到结果
                res.add(prefix.toString());
            }
            return;
        }
        for (int i = 0; i < s.length() && i <= 2; i++) {//循环取s开头的[0,i]位
            if (i != 0 && s.charAt(0) == '0') {
                break;//出现字符0，0只能自己一位，不能和后面的结合
            }
            String part = s.substring(0, i + 1);//取s开头的[0,i]位
            if (Integer.parseInt(part) <= 255) {//取得数的值不能超过255
                if (k != 0) {
                    part = '.' + part;//第一组不用加点，后面的每组前面都要加上点
                }
                prefix.append(part);//放入临时结果集
                backTracking(k + 1, prefix, res, s.substring(i + 1));//回溯后面的串
                prefix.delete(prefix.length() - part.length(), prefix.length());//删掉末尾的part，恢复现场
            }
        }
    }
}