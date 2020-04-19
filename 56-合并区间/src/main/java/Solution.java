import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/4/16 14:55
 */
public class Solution {
    /**
     * @param intervals
     * @return int[][]
     * @description 按照区间区间左端点排序，求重合区间的时候按照左端点排序，不重合区间按照右端点排序。
     * @author WuBiao
     * @date 2020/4/16 16:13
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {//按照区间左端点排序
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        int right = intervals[0][1];//保存当前合并区间的右端点
        int left = intervals[0][0];//保存当前合并区间的左端点
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > right) {
                //出现不重叠区间
                res.add(new int[]{left, right});//放入结果集
                left = intervals[i][0];//更新左右端点
                right = intervals[i][1];
            } else {
                //出现重叠区间
                right = Math.max(right, intervals[i][1]);//更新右端点
            }
        }
        res.add(new int[]{left, right});//加入最后一个合并的区间
        return res.toArray(new int[res.size()][2]);//结果转化为数组
    }
}