package algorithm.알고리즘연습장;

import java.util.*;

public class Main {

    public static int getBalancedIndex(String w) {
        int num = 0;
        char[] chars = w.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                num++;
            } else {
                num--;
            }

            if (num == 0) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isRight(String s) {
        char[] chars = s.toCharArray();
        int count = 0;//왼쪽 괄호 개수
        for(int i = 0; i < chars.length; i ++) {
            if(chars[i] == '(') {
                count ++;
            }
            else {
                if(count == 0) {
                    return false;
                }
                count --;
            }
        }
        return true;
    }

    public static String makeRightBracket(String p) {
        int sliceIndex = getBalancedIndex(p);
        String u = p.substring(0, sliceIndex + 1);
        String v = p.substring(sliceIndex + 1);
        if(isRight(u)) {
            return u + makeRightBracket(v);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(makeRightBracket(v));
        sb.append(")");
        u = u.substring(1, u.length() - 1);
        char[] chars = u.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '(') {
                chars[i] = ')';
            }
            else {
                chars[i] = '(';
            }
        }
        String middle = String.valueOf(chars);
        sb.append(middle);

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String p = sc.next();
        if (p.equals("")) {
            System.out.println("");
        }
        String result = makeRightBracket(p);
        System.out.println(result);
    }
}
