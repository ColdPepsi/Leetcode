import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/3/20 15:22
 */
public class Solution {
    /**
     * @param S
     * @return java.util.List<java.lang.Integer>
     * @description 尽量选择最左端点元素出现的最后一个位置，但是中间出现的元素会不断的扩充区间，找满足条件的最小区间
     * @author WuBiao
     * @date 2020/3/20 15:30
     */
    public List<Integer> partitionLabels(String S) {
        int[] lastPosition = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastPosition[S.charAt(i) - 'a'] = i;//记录每个字母出现的最后的位置
        }
        int left = 0;//保存当前区间的左端点
        int right = 0;//保存当前区间的右端点
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < S.length(); i++) {
            right = Math.max(right, lastPosition[S.charAt(i) - 'a']);//看看当前端点有没有扩充区间
            if (i == right) {//如果当前元素就在区间右端点上
                res.add(right - left + 1);//更新区间长度
                left = i + 1;//更新左端点
            }
        }
        return res;
    }
}