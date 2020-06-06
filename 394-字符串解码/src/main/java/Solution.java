import java.util.Stack;

/**
 * @author WuBiao
 * @date 2020/5/28 17:13
 */
public class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();//保存没被处理的num
        Stack<String> strs = new Stack<>();//保存没被处理的res
        int num = 0;//是他后面'['和']'的倍数
        StringBuilder res = new StringBuilder();//保存两个'['和']'之间的内容
        for (char c : s.toCharArray()) {//遍历字符串s
            if (c == '[') {//碰到左括号
                strs.push(res.toString());//把没处理的res入栈，以后处理
                nums.push(num);//把没处理的num入栈，以后处理
                res = new StringBuilder();//res指向空串，用来记录[之后的内容
                num = 0;//nums置0；
            } else if (c == ']') {//碰到右括号
                int curr_num = nums.pop();//弹出倍数
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < curr_num; i++) {
                    temp.append(res);//res重复curr_num倍
                }
                res = new StringBuilder(strs.pop()).append(temp);
            } else if (Character.isDigit(c)) {//c是数字，把加在num的后面
                num = num * 10 + Integer.parseInt(String.valueOf(c));
            } else if (Character.isLetter(c)) {//c是字母，就把c加到res中
                res.append(c);
            }
        }
        return res.toString();
    }
}