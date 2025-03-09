package java.leetcode.basicCalculator;

import java.util.Stack;

public class solution {

    // basic calculator
    /*
     * Input: s = "(1+(4+5+2)-3)+(6+8)"
     * Output: 23
     * Input: s = " 2-1 + 2 "
     * Output: 3
     */
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int curRes = 0, res = 0;
        // ovo je za znak: 1 za sabiranje +; -1 za oduzimanje -;
        int sign = 1;
        for (var i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                // ova '0' je karakter cija je vrednost 48. s.charAt(i) je u stvari s[0], sto je
                // u ovom primeru 1,gde je vrednost 1 u ASCII-ju 49.
                // curRes = 49-48; curRes = 1;
                // Za konverziju karaktera u brojeve, treba koristiti ovaj pristup
                curRes = s.charAt(i) - '0';
                // ako je u pitanju broj sa vise cifara, npr 42. Tada u prvoj iteraciji
                // curRes=4; druga iter, curRes=4*10+2=42;treca itreracija je'+' i ona se
                // prekida. Takodje, prvi uslov u while petlji i+1<s.length() osigurava da ne
                // izadjemo iz
                // granica stringa
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    curRes = curRes * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                // Ako je prethodni operator -, onda sign = -1, pa broj treba postati negativan.
                // Ako je prethodni operator +, sign = 1, pa broj ostaje nepromenjen. To je
                // razlog
                // zasto se mnozi.
                /*
                 * ako imamo 3-2, Koraci:
                 * 3 → currNo = 3, sign = 1 → currNo = 3 * 1 = 3
                 * - → sign = -1
                 * 2 → currNo = 2, sign = -1 → currNo = 2 * -1 = -2
                 * Konačni rezultat: 3 - 2 = 1
                 */
                curRes = curRes * sign;
                res += curRes;
                curRes = 0;
                sign = 1;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
                // ovde se res mnozi sa znakom koji je ili minus ili plus
            } else if (s.charAt(i) == ')') {
                int prevSign = stack.pop();
                res = prevSign * res;
                int prevRes = stack.pop();
                res = prevRes + res;
            }
        }
        return res;
    }
}
