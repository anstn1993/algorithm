package algorithm.그리디.볼링공고르기;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        /*
        * 답안 풀이
        * 이 문제의 핵심은 볼링공의 무게를 그냥 배열의 요소로 넣어주는 것이 아니라 같은 무게의 볼링공 '개수'를 배열의 요소로 넣어주는 것이다.
        * 그렇게 풀게 되면 나의 최초 풀이처럼 이중 반복문을 쓰지 않고 O(m)의 복잡도로 문제를 풀 수 있다.
        * */
        int result = 0;
        int[] weight = new int[11];//특정 무게의 공 개수를 저장하는 배열
        //예를 들면 첫 번째 요소에 3이면 무게가 1인 공이 3개라는 의미다.
        for(int i = 0; i < n; i ++) {
            int num = sc.nextInt();
            weight[num] += 1;
        }
        //a가 각 무게의 선택했을 때 b가 선택할 수 있는 공의 개수를 구하면 된다.
        //1부터 m까지의 무게별로 처리
        for(int i = 1; i < m + 1; i ++) {
            n -= weight[i];//총 공의 개수에서 a가 선택한 공의 개수만큼 빼준다.
            result += n * weight[i];//a가 선택한 공들은 무게가 같지만 모두 다른 공으로 취급하기 때문에 a가 선택한 공의 개수만큼 곱해줘야 모든 경우의 수가 나온다.
        }
        System.out.println(result);


        /*
        * 나의 최초 풀이
        * */
       /*
        int[] data = new int[n];
        for(int i = 0; i < n; i ++) {
            data[i] = sc.nextInt();
        }
        int result = 0;
        for(int i = 0; i < n - 1; i ++) {
            int value = data[i];
            for(int j = i + 1; j < n; j ++) {
                if(value != data[j]) {
                    result ++;
                }
            }
        }
        System.out.println(result);*/
    }
}
