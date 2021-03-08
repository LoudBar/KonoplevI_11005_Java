package Calculator;

import java.util.Stack;

public class Main {

    static Stack<Integer> stack = new Stack<>();

    public static void calculator(String s) {

        String[] str = s.split(" ");

        for (int i = 0; i < str.length; i++) {


            if (isNumber(str[i])) {
                int num = Integer.parseInt(str[i]);
                stack.push(num);
            }
            else {

                if (stack.size() >= 2)
                    result(str[i]);
                else { System.out.println("Incorrect input"); return;}
            }

        }

        if (stack.size() == 1)
            System.out.println(stack.pop());
        else System.out.println("Incorrect input");

    }

    static void result(String op) {

        String ops = "+-*/";

        if (ops.contains(op)) {

            int ans = 0;
            int a = stack.pop();
            int b = stack.pop();

            if (op.equals("+"))
                ans = b + a;
            if (op.equals("-"))
                ans = b - a;
            if (op.equals("*"))
                ans = b * a;
            if (op.equals("/"))
                ans = b / a;

            stack.push(ans);
        }
    }

    static boolean isNumber(String str) throws NumberFormatException {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {

        String a = "2 3 * 4 5 * +";
        String b = "3 4 5 6 * + -";
        String c = "2 3 +";
        String d = "6 2 /";
        String e = "5 5 * (";
        String f = "asd";

        calculator(a);
        calculator(b);
        calculator(c);
        calculator(d);
        calculator(e);
        calculator(f);
    }
}
