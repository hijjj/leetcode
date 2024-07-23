package 队列;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EvalRPN {
    List<String> numbersLists = new ArrayList<>();
    int current = 0;

    public int evalRPN(String[] tokens) {
        numbersLists.add("/");
        numbersLists.add("-");
        numbersLists.add("*");
        numbersLists.add("+");

        Stack<Integer> stack = new Stack<>();
        for (int j = 0; j < tokens.length; j++) {
            String str = tokens[j];
            if (stack.size()>=2 && numbersLists.contains(str)) {
                int number1 = stack.pop();
                int number2 = stack.pop();
                if ("+".equals(str)) {
                    current = number2+number1;
                    stack.push(current);
                }
                if ("-".equals(str)) {
                    current = number2-number1;
                    stack.push(current);
                }
                if ("*".equals(str)) {
                    current = number2*number1;
                    stack.push(current);
                }
                if ("/".equals(str)) {
                    current = number2/number1;
                    stack.push(current);
                }
            } else {
                stack.push(Integer.valueOf(str));
            }
        }
        if (tokens.length == 0) {
            return Integer.valueOf(tokens[0]);
        }
        return current;
    }

    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        String[] strs = {"1", "1", "1", "1",  "+",  "-",  "+"};
        evalRPN.evalRPN(strs);
    }
}
