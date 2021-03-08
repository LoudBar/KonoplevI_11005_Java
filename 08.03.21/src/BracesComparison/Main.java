package BracesComparison;

import java.util.Stack;

public class Main {

    public static boolean compareBraces(char l, char m) {

        boolean ans = false;

        if (l == ')')
            ans = m == '(';
        if (l == ']')
            ans = m == '[';
        if (l == '}')
            ans = m == '{';

        return ans;

    }



    public static void main(String[] args) {

        Stack<Character> stack = new Stack<>();

        String str = "(]";
        String oBraces = "([{";
        String cBraces = ")]}";

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            if (oBraces.contains(Character.toString(c)))
                stack.push(c);

            if (cBraces.contains(Character.toString(c))) {
                if (stack.size() == 0) {
                    System.out.println("String is not correct");
                    return;
                }
                if (compareBraces(c, stack.peek())) {
                    stack.pop();
                }
            }
        }
        if (stack.size() == 0)
            System.out.println("String is correct");
        else System.out.println("String is not correct");
    }
}
