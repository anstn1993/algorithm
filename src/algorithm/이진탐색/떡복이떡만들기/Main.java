package algorithm.이진탐색.떡복이떡만들기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] lengths = new int[n];
        for(int i = 0; i < n; i ++) {
            lengths[i] = sc.nextInt();
        }

        int start = 0;
        int end = Arrays.stream(lengths).max().getAsInt();
        int result = 0;
        while(start <= end) {
            int totalLength = 0;
            int mid = (start + end) / 2;
            //잘랐을 때 떡 양 계산
            for(int i = 0; i < lengths.length; i ++) {
                if(lengths[i] > mid) {
                    totalLength += lengths[i] - mid;
                }
            }
            //떡의 양이 부족한 경우 높이를 낮춰서 더 많이 자르게 한다.(왼쪽 탐색)
            if(m > totalLength) {
                end = mid - 1;
            }
            //떡의 양이 충분한 경우 높이를 높여서준다.(오른쪽 탐색)
            else {
                result = mid;//최대한 덜 잘랐을 때가 정답이기 때문에 여기서 result를 기록한다.
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}
