package algorithm.그리디.곱하기혹은더하기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        char[] numChars = s.toCharArray();

        //첫 번째 숫자를 먼저 result에 대입해준다.
        int result = numChars[0] - '0';
        //두 번째 숫자부터 순서대로 연산 시작
        for (int i = 1; i < numChars.length; i++) {
            int num = numChars[i] - '0';//피연산 숫자
            if (result <= 1 || num <= 1) {//피 연산자 중 하나라도 0 혹은 1인 숫자가 있다면 무조건 더해준다.
                result += num;
            } else {//그렇지 않은 경우 곱해준다.
                result *= num;
            }
        }

        System.out.println(result);
    }
}
