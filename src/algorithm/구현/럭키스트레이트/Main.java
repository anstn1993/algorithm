package algorithm.구현.럭키스트레이트;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine();

        /*답안 풀이
        * 왼쪽 숫자들은 더하고 오른쪽 숫자들은 뺐을 때 0이면 조건 부합
        * */
        int sum = 0;
        for(int i = 0; i < n.length() / 2; i ++) {
            sum += n.charAt(i) - '0';
        }
        for(int i = n.length() / 2; i < n.length(); i ++) {
            sum -= n.charAt(i) - '0';
        }

        if(sum == 0) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }

        /*나의 최초 풀이*/
        /*int length = n.length();
        int[] score = new int[length];

        for(int i = 0; i < length; i ++) {
            score[i] = n.charAt(i) - '0';
        }

        int left = 0;
        int right = 0;
        for(int i = 0; i < length; i ++) {
            if(i > length - 1 - i) {
                break;
            }
            left += score[i];
            right += score[length - 1 - i];
        }

        if(left == right) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }*/
    }
}
