package 队列;

import java.util.Stack;

public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c1 : c) {
            if (!stack.isEmpty() && stack.peek() == c1) {
                stack.pop();
            }else {
                stack.push(c1);
            }
        }
       StringBuffer stringBuffer = new StringBuffer();
        while (!stack.isEmpty()){
            stringBuffer.append(stack.pop());
        }
       return stringBuffer.reverse().toString();
    }
}
