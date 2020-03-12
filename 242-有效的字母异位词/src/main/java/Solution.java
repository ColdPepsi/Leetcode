/**
 * @author WuBiao
 * @date 2020/3/12 9:02
 */
public class Solution {
    /**
     * @param s
     * @param t
     * @return boolean
     * @description 用哈希表来计数
     * @author WuBiao
     * @date 2020/3/12 9:07
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;//长度不同直接返回false
        }
        int[] hash = new int[26];
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;//计数，每个字母出现的次数
        }
        for (char c : t.toCharArray()) {
            hash[c - 'a']--;//出现的字母，计数减一
        }
        for (int i : hash) {
            if (i != 0) {//出现计数不为0的项，说明不是异位词
                return false;
            }
        }
        return true;
    }
}