/**
 * @author WuBiao
 * @date 2020/3/18 8:58
 */
public class Solution {
    /**
     * @param letters
     * @param target
     * @return char
     * @description 找到数组中第一个大于target的元素
     * @author WuBiao
     * @date 2020/3/18 9:09
     */
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters == null || letters.length == 0) {
            return 0;
        }
        int right = letters.length;
        int left = 0;
        while (left < right) {
            int mid = (right + left) / 2;
            if (letters[mid] > target) {
                right = mid;//注意下标的设置
            } else {
                left = mid + 1;
            }
        }
        return left == letters.length ? letters[0] : letters[left];
    }
}