package algorithm.그리디.만들수없는금액;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for(int i = 0; i < n; i ++) {
            data[i] = sc.nextInt();
        }

        /*
        * 답안 풀이
        * */
        Arrays.sort(data);//오름차순 정렬
        int target = 1;
        for(int i = 0; i < n; i ++) {
            if(target < data[i]) {
                break;
            }
            target += data[i];
        }
        System.out.println(target);

        /*
        * 나의 최초 풀이
        * */
        /*int min = Arrays.stream(data).min().getAsInt();//배열의 최소값
        int sum = Arrays.stream(data).sum();//배열 요소의 합
        int result = 0;
        //동전으로 만들 수 있는 최소값부터 최대값까지 순회를 한다.
        for(int i = min; i <= sum; i ++) {
            int value = i;
            for(int j = 0; j < data.length; j ++) {
                //동전이 값보다 작은 경우 값에서 동전값만큼 빼준다.
                if(value >= data[j]) {
                    value -= data[j];
                }

                if(value == 0) {//값이 0이 되면 동전들로 만들 수 있는 값이기 때문에 연산을 멈추고 반복문을 빠져나간다.
                    break;
                }
            }

            if(value != 0) {//값이 0이 아니면 동전들의 조합으로 만들 수 있는 값이 아니기 때문에 이 값이 최소값이 된다.
                result = i;
                break;
            }
        }

        System.out.println(result);*/
    }
}
