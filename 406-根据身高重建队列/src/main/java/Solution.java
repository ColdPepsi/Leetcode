import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/3/19 15:53
 */
public class Solution {
    /**
     * @param people
     * @return int[][]
     * @description 身高按照升序降序排列，k按照升序排列，依次插入到队列索引k处，
     * 先插身高高的，因为后插入身高低的对身高高的没有影响。
     * @author WuBiao
     * @date 2020/3/19 16:06
     */
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];//返回长度为0的数组
        }
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {//身高不同
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });//people数组，身高按照降序排列，k按照升序排列
        List<int[]> queue = new LinkedList<>();
        for (int[] person : people) {
            queue.add(person[1], person);//把person插入到索引person[1]处
        }
        return queue.toArray(new int[queue.size()][2]);//转换成二维数组，返回结果
    }
}