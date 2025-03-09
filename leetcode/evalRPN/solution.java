package java.leetcode.evalRPN;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class solution {

    // Evaluate Reverse Polish Notation
    /*
     * Input: tokens = ["2","1","+","3","*"]
     * Output: 9
     * Explanation: ((2 + 1) * 3) = 9
     * Input: tokens = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+",
     * "5", "+" };
     * Output: 22
     */
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            // Ako je broj, dodaj u stek
            if (s.matches("-?\\d+")) {
                stack.push(Integer.parseInt(s));
            }
            // Ako je operator, izvuci dva broja iz steka i izvrši operaciju
            else {
                int a = stack.pop();
                int b = stack.pop();
                switch (s) {
                    case "+" -> stack.push(a + b);
                    case "-" -> stack.push(b - a);
                    case "*" -> stack.push(a * b);
                    case "/" -> stack.push(b / a);
                }
            }
        }
        return stack.pop();
    }

    // drugi nacin
    public static int evalRPN2(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for (String s : tokens) {
            if (!set.contains(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                // prvi izvuceni operand je zapravo drugi u izrazu
                int a = stack.pop();
                // drugi izvuceni operand je zapravo prvi u izrazu
                int b = stack.pop();
                if (s.equals("+")) {
                    stack.push(a + b);
                } else if (s.equals("*")) {
                    stack.push(a * b);
                } else if (s.equals("-")) {
                    // b je prvi operand, a je drugi
                    stack.push(b - a);
                } else if (s.equals("/")) {
                    // b je prvi operand, a je drugi
                    stack.push(b / a);
                }
            }
        }
        return stack.peek();
    }
}
