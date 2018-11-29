package Petuum;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public boolean func(String string) {
        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put('(', ')');
        map.put('{', '}');
        for (char c : string.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(map.get(c));
            } else if (stack.isEmpty()||stack.pop() != c) {
                    return false;
                }
        }
        if(stack.size()>0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.func("(()){{}"));
    }
}
