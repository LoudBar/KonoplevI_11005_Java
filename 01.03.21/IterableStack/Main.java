package IterableStack;

import java.net.Inet4Address;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(10);
        int x = stack.peek();
        stack.push(5);
        int y = stack.pop();
        System.out.println(y);
        System.out.println(x);
        System.out.println();

      stack.push(4);
      stack.push(5);
      stack.push(6);
      stack.push(7);

      for (Integer elem : stack) {

              System.out.println(elem);
          }
      }


}
