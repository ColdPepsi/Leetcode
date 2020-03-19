/**
 * @author WuBiao
 * @date 2020/3/19 21:54
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = -1;//记录字符串的索引
        for (char c : s.toCharArray()) {
            //indexOf()函数从指定位置开始往后找指定字符在该字符串中第一次出现处的索引，没找到返回-1；
            index = t.indexOf(c, index + 1);
            if (index == -1) {//没有找到返回false
                return false;
            }
        }
        return true;
    }
}