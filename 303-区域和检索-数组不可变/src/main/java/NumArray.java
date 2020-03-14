/**
 * @author WuBiao
 * @date 2020/3/14 15:11
 */
public class NumArray {

    private int[] sum;//sum[i]为 sum[0,i]的累加和

    public NumArray(int[] nums) {
        if (nums.length==0){
            return;
        }
        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];//计算累加和
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sum[j];
        }
        return sum[j] - sum[i - 1];
    }
}