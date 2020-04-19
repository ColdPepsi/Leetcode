import java.util.HashSet;
import java.util.Set;

/**
 * @author WuBiao
 * @date 2020/4/19 9:27
 */
public class Solution2 {
    /**
     * @param nums
     * @return boolean
     * @description 用数组要比用list快点，可能少了自动装箱拆箱
     * @author WuBiao
     * @date 2020/4/19 9:42
     */
    public boolean judgePoint24(int[] nums) {
        double[] numbers = new double[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = nums[i];
        }
        return solve(numbers);
    }

    /**
     * @param numbers
     * @return boolean
     * @description 回溯法，从数组中选出两个数，把运算结果加到数组中
     * @author WuBiao
     * @date 2020/4/19 8:58
     */
    private boolean solve(double[] numbers) {
        if (numbers.length == 1) {//数组中只剩下一个数的时候判断结果
            return Math.abs(numbers[0] - 24) < 1e-6;//看是否与24相等
        }
        //从numbers中取出两个数，把结果放入数组中
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {//取不同的两个数
                    //如果回溯的话，还要恢复现场，把数插回原位置，所以不如直接生成一个新数组
                    double[] nums = new double[numbers.length - 1];
                    int index = 0;
                    for (int k = 0; k < numbers.length; k++) {
                        if (k != i && k != j) {//把剩下的数加入到新数组
                            nums[index++] = numbers[k];
                        }
                    }
                    Set<Double> doubles = calculate(numbers[i], numbers[j]);//获取两个数运算的结果集
                    for (Double aDouble : doubles) {
                        nums[index] = aDouble;//把两个数运算的结果，分别加入到新数组中
                        if (solve(nums)) {//找到一个结果，立即返回
                            return true;
                        }
                    }
                }
            }
        }
        return false;//如果没有找到结果，返回false
    }

    /**
     * @param a
     * @param b
     * @return java.util.Set<java.lang.Double>
     * @description 返回两个数计算得到的结果集
     * @author WuBiao
     * @date 2020/4/18 23:25
     */
    private Set<Double> calculate(double a, double b) {
        Set<Double> res = new HashSet<Double>();
        res.add(a - b);
        res.add(b - a);
        res.add(a + b);
        res.add(a * b);
        if (a != 0) {
            res.add(b / a);
        }
        if (b != 0) {
            res.add(a / b);
        }
        return res;
    }
}