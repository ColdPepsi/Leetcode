/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.Stack;

/**
 * @author wubiao21 2020年07月09日 10:14:21
 */
public class Solution {
    /**
     * 因为涉及到返回上层目录，所以用栈比较合适，栈有记忆功能
     *
     * @param path 路径字符串
     * @return 化简后的路径
     */
    public String simplifyPath(String path) {
        String[] strings = path.split("/");//以"/"分割字符串，有4种情况，“路径”、空串、“.”、“..”
        Stack<String> stack = new Stack<>();
        for (String string : strings) {
            if (!stack.isEmpty() && string.equals("..")) {//栈非空，并且“..”，表示上一级目录，所以出栈
                stack.pop();
            } else if (!string.equals("") && !string.equals(".") && !string.equals("..")) {
                stack.push(string);//路径入栈
            }
        }
        if (stack.isEmpty()) {
            return "/";//栈空，返回根目录
        } else {
            StringBuilder res = new StringBuilder();
            for (String s : stack) {//拼接路径，从栈底到栈顶
                res.append("/").append(s);
            }
            return res.toString();
        }
    }
}