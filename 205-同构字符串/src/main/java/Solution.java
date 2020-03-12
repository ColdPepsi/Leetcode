/**
 * @author WuBiao
 * @date 2020/3/12 9:39
 */
public class Solution {
    /**
     * @param s
     * @param t
     * @return boolean
     * @description 同构字符串，两个字符串相同索引的字符，第一次出现的位置应该相同
     * @author WuBiao
     * @date 2020/3/12 12:02
     */
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {//长度不同返回false
            return false;
        }
        int[] mapS = new int[128];//记录字符第一次出现的位置
        int[] mapT = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
//            if (mapS[cs] != mapT[ct]) {//映射不相同，返回false
//                return false;
//            }
//            //上步没有返回的话，说明mapS[cs]==mapT[ct]
//            if (mapS[cs] == 0) {
//                //如果第一次映射的话，映射为下标加1，因为初始值都为0，所以加1映射
//                mapS[cs] = i + 1;
//                mapT[ct] = i + 1;
//            }
            if (mapS[cs] == 0 && mapT[ct] == 0) {//第一次映射，映射为下标加1
                mapS[cs] = i + 1;
                mapT[ct] = i + 1;
            }
            if (mapS[cs] != mapT[ct]) {//发现映射不相同，返回false
                return false;
            }
        }
        return true;
    }
}