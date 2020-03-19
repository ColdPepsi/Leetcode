import java.util.Arrays;
import java.util.Comparator;

/**
 * @author WuBiao
 * @date 2020/3/19 15:17
 */
public class Solution {
    /**
     * @param points
     * @return int
     * @description 找出非重叠区间，多少个非重叠区间，就需要多少支箭
     * @author WuBiao
     * @date 2020/3/19 15:22
     */
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });//把points按照右端点排序
        int arrow = 1;
        int pre = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > pre) {
                pre = points[i][1];
                arrow++;
            }
        }
        return arrow;
    }
}