package algorithm.동적계획법.to1.탑다운;

import java.util.Scanner;

public class Main {

    //각 index를 주어진 숫자로 봤을 때 해당 값을 1로 만드는 데 필요한 최소 연산 횟수를 저장하는 메모이제이션
    public static int[] cache = new int[30001];

    //탑다운 방식으로 최소 연산 횟수를 구한다.
    private static int getMinCount(int x) {
        if(x == 1) {
            return 0;
        }
        if(x == 2) {
            return 1;
        }
        if(cache[x] != 0) {
            return cache[x];
        }
        int temp = 30000;//특정 숫자를 연산하는 데 드는 최소 횟수
        //각 조건에 부합하는 숫자에 대한 최소 연산 횟수를 구하는 연산을 재귀적으로 수행한다.
        if(x % 5 == 0) {
            temp = getMinCount(x / 5);
        }
        if(x % 3 == 0) {
            temp = Math.min(temp, getMinCount(x / 3));
        }
        if(x % 2 == 0) {
            temp = Math.min(temp, getMinCount(x / 2));
        }
        temp = Math.min(temp, getMinCount(x - 1));
        //현재 숫자의 최소 연산 횟수는 temp에 1을 더한 값이 된다. 그 값을 DP 테이블에 저장
        cache[x] = temp + 1;
        return cache[x];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(getMinCount(x));
    }
}
