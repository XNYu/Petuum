package Petuum;

import java.util.Stack;

public class RemoveAdjacentDuplicates {
    public static String func2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()&&stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    public static String func(String s) {
        int p1 = -1, p2 = 0;
        char[] cs = s.toCharArray();
        for (; p2 < cs.length; p2++) {
            if ( p1<0 || cs[p2] != cs[p1]) {
                cs[++p1] = cs[p2];
            } else {
                p1--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= p1; i++) {
            sb.append(cs[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(func2("abbc"));
    }
}
