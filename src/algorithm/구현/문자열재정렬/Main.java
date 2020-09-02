package algorithm.구현.문자열재정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        char[] chars = str.toCharArray();
        ArrayList<Character> result = new ArrayList<>();
        int sum = 0;//입력 값 중에 숫자들만 더한 값
        Arrays.sort(chars);
        for(int i = 0; i < chars.length; i ++) {
            /*답안 풀이
            * Character클래스의 isLetter(), isDigit()같은 메소드를 활용하자
            * */
            if(Character.isLetter(chars[i])) {
                result.add(chars[i]);
            }
            else {
                sum += chars[i] - '0';//숫자인 경우 숫자들은 모두 더해준다.
            }

            /*
            * 나의 최초 풀이
            * */
            /*if(chars[i] - '0' < 10) {
                sum += chars[i] - '0';//숫자인 경우 숫자들은 모두 더해준다.
            }
            else {
                result.add(chars[i]);
            }*/
        }

        String sumStr = Integer.toString(sum);
        for(int i = 0; i < sumStr.length(); i ++) {
            result.add(sumStr.charAt(i));
        }
        for(int i = 0; i < result.size(); i ++) {
            System.out.print(result.get(i));
        }
    }
}
