/**
 * @author WuBiao
 * @date 2020/3/30 17:23
 */
public class Solution {
    /**
     * @param words
     * @return int
     * @description 用二进制的一位表示某一个字母是否出现过，0表示没出现，1表示出现。
     * "abcd"二进制表示00000000 00000000 00000000 00001111、
     * "bc"二进制表示00000000 00000000 00000000 00000110。
     * 当两个字符串没有相同的字母时，二进制数与的结果为0
     * 作者：koukou-11
     * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths/solution/javawei-yun-suan-by-koukou-11/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @author WuBiao
     * @date 2020/3/30 17:31
     */
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int[] values = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                values[i] |= 1 << (c - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if ((values[i] & values[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}