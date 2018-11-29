package Petuum;

import java.util.HashSet;

public class Permutation {
    HashSet<String> set = new HashSet<>();
    public void find(int num) {
        String str = "" + num;
        char[] cs = str.toCharArray();
        boolean[] used = new boolean[cs.length];
        StringBuilder sb = new StringBuilder();
        add(sb, used, cs);
    }

    public void add(StringBuilder pre, boolean[] used, char[] cs) {
        if (pre.length() == cs.length) {
            String s = pre.toString();
            if(set.add(s))
                System.out.println(pre.toString());
        }
        int len = cs.length;
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                pre.append(cs[i]);
                used[i] = true;
                add(pre, used, cs);
                used[i] = false;
                pre.deleteCharAt(pre.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        p.find(9999998);
    }
}
