import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author WuBiao
 * @date 2020/4/18 23:16
 */
public class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> numbers = new ArrayList<Double>();
        for (int num : nums) {
            numbers.add((double) num);
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
    private boolean solve(List<Double> numbers) {
        if (numbers.size() == 1) {//数组中只剩下一个数的时候判断结果
            return Math.abs(numbers.get(0) - 24) < 1e-6;//看是否与24相等
        }
        //从numbers中取出两个数，把结果放入数组中
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (i != j) {//取不同的两个数
                    //如果回溯的话，还要恢复现场，把数插回原位置，所以不如直接生成一个新数组
                    List<Double> nums = new ArrayList<Double>();
                    for (int k = 0; k < numbers.size(); k++) {
                        if (k != i && k != j) {//把剩下的数加入到新数组
                            nums.add(numbers.get(k));
                        }
                    }
                    Set<Double> doubles = calculate(numbers.get(i), numbers.get(j));//获取两个数运算的结果集
                    for (Double aDouble : doubles) {
                        nums.add(aDouble);//把两个数运算的结果，分别加入到新数组中
                        if (solve(nums)) {//找到一个结果，立即返回
                            return true;
                        }
                        nums.remove(nums.size() - 1);//恢复现场
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