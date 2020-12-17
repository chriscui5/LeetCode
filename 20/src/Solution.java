import java.util.Stack;

/**
 * @author:yixiaolan
 * @date:Created in 2020/8/14
 * @description:
 * @version:1.0
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length()==0) return true;
        for(char c:s.toCharArray()){

            if(stack.isEmpty()&&(c==')'||c=='}'||c==']'))
                return false;
            if(c=='('||c=='['||c=='{') stack.push(c);

            if(c==')'){//当前元素若为右括号

                if(stack.peek()=='(')//并且栈顶元素为对应左括号则弹出栈顶元素
                    stack.pop();
                else return false;//否则直接返回false 类似于这种情况"(])"
            }else if(c==']'){

                if(stack.peek()=='[')
                    stack.pop();
                else return false;

            }else if(c=='}'){

                if(stack.peek()=='{')
                    stack.pop();
                else return false;

            }
        }
        return stack.isEmpty();
    }

}
