import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author WuBiao
 * @date 2020/5/27 8:02
 */
public class Solution3 {
    /**
     * @param nums
     * @return int[]
     * @description bfs解法
     * @author WuBiao
     * @date 2020/5/27 8:29
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<int[]> queue = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        addNumToQueue(0, 0, nums, res, queue);
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            addNumToQueue(temp[0] + 1, temp[1], nums, res, queue);//下面元素入队
            addNumToQueue(temp[0], temp[1] + 1, nums, res, queue);//右边元素入队
        }
        int[] ret = new int[res.size()];
        int index = 0;
        for (Integer integer : res) {
            ret[index++] = integer;
        }
        return ret;
    }

    private void addNumToQueue(int row, int col, List<List<Integer>> nums,
                               List<Integer> res,
                               Queue<int[]> queue) {
        if (row >= nums.size() || col >= nums.get(row).size() || nums.get(row).get(col) < 0) {
            return;
        }
        int temp = nums.get(row).get(col);
        res.add(temp);//入队前就加入到结果集中
        queue.offer(new int[]{row, col});//坐标入队
        nums.get(row).set(col, -temp);//修改为负，表示已访问。
    }
}