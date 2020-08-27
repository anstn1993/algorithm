package algorithm.그리디.숫자카드게임;

import java.util.Scanner;
/*
* 각 행의 최소값 중에서 가장 큰 값을 찾는 문제다.
* */
public class NumberCardGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //더 효율적인 풀이
        int result = 0;
        for(int i = 0; i < n; i ++) {
            //현재 행에서 최소값 찾기
            int min = 100001;
            for(int j = 0; j < m; j ++) {
                int value = sc.nextInt();
                //입력받은 값과 현재 최소 값을 비교해서 받은 값이 더 작으면 그 값으로 최소값 교체
                min = Math.min(value, min);
            }
            //가장 큰 값 찾기
            result = Math.max(result, min);
        }
        System.out.print(result);
//나의 최초 풀이
//        각 행의 값들 오름차순 정렬
//        for(int i = 0; i < n; i ++) {
//            Arrays.sort(data[i]);
//        }
//        int max = 0;
//        for(int i = 0; i < n; i ++) {
//            if(max < data[i][0]) {
//                max = data[i][0];
//            }
//        }


        System.out.print(result);
    }
}
