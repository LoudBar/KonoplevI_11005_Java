package Stack;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(10);
        int x = stack.peek();
        stack.push(5);
        int y = stack.pop();
        System.out.println(y);
        System.out.println(x);
    }
}
