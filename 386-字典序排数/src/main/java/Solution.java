import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/4/6 22:04
 */
public class Solution {
    /**
     * @param n
     * @return java.util.List<java.lang.Integer>
     * @description 想象成9棵10叉树，根分别为1~9,每棵树分别进行DFS
     * @author WuBiao
     * @date 2020/4/6 22:14
    public List<Integer> lexicalOrder(int n) {//[ˈleksɪkl] 词汇的
    List<Integer> res = new ArrayList<Integer>();
    for (int i = 1; i <= 9; i++) {
    if (i <= n) {
    lexicalOrder(n, i, res);
    } else {
    break;
    }
    }
    return res;
    }

     */
    /**
     * @param n
     * @param currentNum
     * @param res
     * @return void
     * @description 10叉树深度优先
     * @author WuBiao
     * @date 2020/4/6 22:13
     *//*
    private void lexicalOrder(int n, int currentNum, List<Integer> res) {
        if (currentNum > n) {
            return;
        }
        res.add(currentNum);
        for (int nextBit = 0; nextBit <= 9; nextBit++) {
            lexicalOrder(n, currentNum * 10 + nextBit, res);
        }
    }*/
    private void lexicalOrder(int n, int currentNum, List<Integer> res) {
        if (currentNum > n) {
            return;
        }
        if (currentNum != 0) {
            res.add(currentNum);
        }
        for (int nextBit = 0; nextBit <= 9; nextBit++) {
            if (currentNum == 0 && nextBit == 0) {
                continue;
            }
            lexicalOrder(n, currentNum * 10 + nextBit, res);
        }
    }

    public List<Integer> lexicalOrder(int n) {//[ˈleksɪkl] 词汇的
        List<Integer> res = new ArrayList<Integer>();
        lexicalOrder(n, 0, res);
        return res;
    }
}