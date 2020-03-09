import java.util.Stack;

/**
 * @author WuBiao
 * @date 2020/3/9 20:36
 */
public class Solution {
    /**
     * @param s
     * @return boolean
     * @description 遇到左括号就入栈，右括号进行逻辑判断
     * @author WuBiao
     * @date 2020/3/9 20:55
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);//遇到左括号就入栈
                continue;
            }
            switch (c) {
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
}
