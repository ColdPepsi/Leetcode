/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * @author wubiao21 2020年07月17日 17:34:38
 */
public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostoder(postorder, 0, postorder.length - 1);
    }

    /**
     * 判断postorder[left...right]是否是后序遍历序列
     *
     * @param postorder 数组
     * @param left      区间左端点
     * @param right     区间右端点
     * @return 是后序遍历序列的话返回true
     */
    private boolean verifyPostoder(int[] postorder, int left, int right) {
        if (left >= right) {//递归边界
            return true;
        }
        int root = postorder[right];//数组最后一个元素是根节点
        int index = left;//寻找第一个比根大的结点下标
        while (postorder[index] < root) {
            index++;
        }
        int subLeftEnd = index - 1;//此时 [left...subLeftEnd]是左子树，[subLeftEnd+1...right-1]是右子树，左子树都小于根节点，右子树都大于根节点
        while (index < right) {
            if (postorder[index++] < root) {//右区间碰到比root小的则提前返回false
                return false;
            }
        }
        return verifyPostoder(postorder, left, subLeftEnd) && verifyPostoder(postorder, subLeftEnd + 1, right - 1);//递归处理左右区间
    }
}