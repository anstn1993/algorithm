package algorithm.이진탐색.공유기설치;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//집의 개수
        int c = sc.nextInt();//공유기의 개수

        //집의 좌표를 저장하는 리스트
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        //두 집의 거리가 가장 짧은 값 찾기
        int start = (int) 1e9;
        for (int i = 0; i < n - 1; i++) {
            int difference = Math.abs(arr[i] - arr[i + 1]);
            start = Math.min(start, difference);
        }
        //두 집의 거리가 가장 긴 값
        int end = arr[n - 1] - arr[0];
        int result = 0;
        //이진 탐색
        while (start <= end) {
            //이 값은 두 집 사이의 거리를 의미한다.
            int mid = (start + end) / 2;
            int value = arr[0];//공유기가 설치된 집의 좌표
            int count = 1;//설치된 공유기 개수
            for (int i = 1; i < n; i++) {
                //다음 설치된 집과 이전에 설치된 집과의 거리가 mid보다 크거나 같은 경우
                if(arr[i] >= value + mid) {
                    value = arr[i];
                    count ++;
                }
            }

            //공유기가 c개보다 많이 설치 가능한 경우
            if(count >= c) {
                result = mid;
                start = mid + 1;
            }
            //공유기가 c개보다 많이 설치 불가능한 경우
            else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
