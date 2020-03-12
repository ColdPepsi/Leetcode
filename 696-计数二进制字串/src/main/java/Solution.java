/**
 * @author WuBiao
 * @date 2020/3/12 12:54
 */
public class Solution {
    /**
     * @param s
     * @return int
     * @description 要求每个子串中0和1的个数相同，并且连续的，如k*0+k*1
     * @author WuBiao
     * @date 2020/3/12 15:11
     */
    public int countBinarySubstrings(String s) {
        int preLen = 0;//前一个元素连续的长度
        int curLen = 1;//当前元素连续的长度
        int res = 0;//保存结果
        for (int i = 1; i < s.length(); i++) {//从1开始遍历
            if (s.charAt(i) == s.charAt(i - 1)) {//如果当前元素和前一个元素相同，则计数加1
                curLen++;
            } else {//不相等说明出现01或者10
                preLen = curLen;//更新前面的计数
                curLen = 1;//curLen置1。
            }
            if (preLen >= curLen) {
                res++;//比如从01扩张到0011，000111，一点点扩张
            }
        }
        return res;
    }
}