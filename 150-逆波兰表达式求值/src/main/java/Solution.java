import java.util.Stack;

/**
 * @author WuBiao
 * @date 2020/6/17 23:10
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> integerStack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {//如果是运算符
                int num1 = integerStack.pop();
                int num2 = integerStack.pop();
                int res;
                switch (token) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    default:
                        res = num2 / num1;
                        break;
                }
                integerStack.push(res);
            } else {//操作数
                int i = Integer.parseInt(token);
                integerStack.push(i);
            }
        }
        return integerStack.peek();
    }

    /**
     * @param token 字符串
     * @return boolean
     * @description 判断一个字符是否是运算符
     * @author WuBiao
     * @date 2020/6/17 23:11
     */
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}
