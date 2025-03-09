package java.leetcode.simplifyPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class solution {

    // Simplify Path
    /*
     * Input: path = "/home//foo/"
     * Output: "/home/foo"
     */
    public static String simplifyPath(String path) {
        if (path.length() == 0) {
            return "/";
        }
        String[] niz = path.split("/");
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (String s : niz) {
            if (s.equals("") || s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return (sb.length() == 0 ? "/" : sb.toString());
    }

    // drugi nacin, koristeci listu
    public static String simplifyPath2(String path) {
        if (path.length() == 0) {
            return "/";
        }
        String[] niz = path.split("/");
        List<String> rez = new ArrayList<>();
        for (String s : niz) {
            if (s.equals("") || s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                if (!rez.isEmpty()) {
                    rez.remove(rez.size() - 1);
                }
            } else {
                rez.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String i : rez) {
            sb.append("/").append(i);
        }
        return (sb.length() == 0) ? "/" : sb.toString();
    }
}
