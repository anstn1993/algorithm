package algorithm.그리디.until1;

import java.util.Scanner;
/*
* 이 알고리즘 문제가 그리디인 이유는 '최대한 많이 나누는 것'이 최적 해가 되기 때문이다.
* */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int answer = 0;

        int target = (n / k) * k;//k의 배수 중 n보다 크지 않은 가장 큰 수
        answer += n - target;//빼기 횟수

        //반복문으로 나누기만 수행해주면 된다.
        while(n != 1) {
            n /= k;
            answer ++;
        }

        /*
        *최초의 풀이
        *이 방식의 풀이는 그때그때 나눌 수 없는 숫자를 1씩 빼서 숫자를 줄여나가는데
        *숫자가 100억 이상의 쿤 수가 될 때를 가정했을 때도 빠르게 동작하게 하려면 N이 K의 배수가
        *때까지 한 번에 빼기를 수행하고 반복문으로 나누기만 수행하면 된다.
        * */
      /*  while(n != 1) {
            if(n % k != 0) {
                n -= 1;
            }
            else {
                n /= k;
            }
            answer ++;
        }*/

        System.out.print(answer);
    }
}
