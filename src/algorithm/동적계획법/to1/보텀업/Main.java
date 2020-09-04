package algorithm.동적계획법.to1.보텀업;

import java.util.Scanner;

public class Main {

    //각 index를 주어진 숫자로 봤을 때 해당 값을 1로 만드는 데 필요한 최소 연산 횟수를 저장하는 DP 테이블
    public static int[] cache = new int[30001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        //보텀업 방식
        for(int i = 2; i <= x; i ++) {
            //1을 뺀 숫자의 최소 연산 횟수 + 1
            cache[i] = cache[i - 1] + 1;
            //5로 나눈 숫자의 최소 연산 횟수 + 1
            if(i % 5 == 0) {
                //앞에서 저장한 최소 연산 횟수보다 5로 나눈 숫자의 최소 연산 횟수가 더 적은 경우 그 횟수로 교체
                cache[i] = Math.min(cache[i], cache[i / 5] + 1);
            }
            if(i % 3 == 0) {
                //앞에서 저장한 최소 연산 횟수보다 3으로 나눈 숫자의 최소 연산 횟수가 더 적은 경우 그 횟수로 교체
                cache[i] = Math.min(cache[i], cache[i / 3] + 1);
            }
            if(i % 2 == 0) {
                //앞에서 저장한 최소 연산 횟수보다 2로 나눈 숫자의 최소 연산 횟수가 더 적은 경우 그 횟수로 교체
                cache[i] = Math.min(cache[i], cache[i / 2] + 1);
            }
        }
        System.out.println(cache[x]);
    }
}
