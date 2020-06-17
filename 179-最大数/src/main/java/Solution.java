import java.util.Arrays;

/**
 * @author WuBiao
 * @date 2020/6/17 23:07
 */
public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "0";
        }
        int len = nums.length;
        String[] num = new String[len];
        for (int i = 0; i < len; i++) {
            num[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(num, (a, b) -> {
            String str1 = a + b;
            String str2 = b + a;
            return str2.compareTo(str1);
        });
        if (num[0].equals("0")) {
            return "0";//如果排序后，最大位为0，直接返回0
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : num) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
