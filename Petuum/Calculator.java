package Petuum;

import java.util.Stack;

public class Calculator {
    public int calculate2(String s) {
        int num = 0, n = s.length();
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            }
            if (c<'0'&&c != ' '||i==n-1) {
                if(op=='+')
                    stack.push(num);
                if(op=='-')
                    stack.push(-num);
                if(op=='*')
                    stack.push(stack.pop() * num);
                if(op=='/')
                    stack.push(stack.pop() / num);
                op = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.empty()) {
            res += stack.pop();
        }
        return res;
    }
    public int calculate(String s) {
        int res = 0, num = 0, sign = 1, n = s.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
                if (i == n - 1) {
                    res += sign * num;
                }
            }
            else if (c == '+' || c == '-') {
                res += sign * num;
                num = 0;
                sign = c == '+' ? 1 : -1;
            }
            else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign * num;
                num = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }
        if(num!=0)
            res += sign * num;
        return res;
    }

    public int calculate1(String s) {
        int res = 0, num = 0, sign = 1, n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = 10 * num + (c - '0');
            } else if (c == '(') {
                int j = i, cnt = 0;
                for (; i < n; ++i) {
                    if (s.charAt(i) == '(') ++cnt;
                    if (s.charAt(i) == ')') --cnt;
                    if (cnt == 0) break;
                }
                System.out.println(j+","+i);
                num = calculate(s.substring(j + 1, i));
            }
            if (c == '+' || c == '-' || i == n - 1) {
                res += sign * num;
                num = 0;
                sign = c == '+' ? 1 : -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.calculate2("3+2*2"));
    }
}
