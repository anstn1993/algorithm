package algorithm.그리디.문자열뒤집기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] numChar = s.toCharArray();
        int oneCount = 0;
        int zeroCount = 0;
        int zeroOrOne = 0;
        int result = 0;
        //0의 개수 찾기
        for(int i = 0; i < numChar.length; i ++) {
            int value = numChar[i] - '0';
            //현재숫자가 이전 숫자와 같은 경우는 다음 숫자로 넘어간다.
            if(value == zeroOrOne) {
                continue;
            }
            //현재 숫자가 이전 숫자와 다른 경우 숫자 비교 기준 값을 그 다른 숫자로 바꿔준다.
            else {
                //현재 숫자가 0인 경우
                if(value == 0) {
                    oneCount ++;
                }
                //현재 숫가자 1인 경우
                else {
                    zeroCount ++;
                }
                zeroOrOne = value;
            }
        }
        result = zeroCount < oneCount ? zeroCount : oneCount;
        System.out.println(result);
    }
}
