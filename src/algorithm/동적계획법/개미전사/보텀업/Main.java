package algorithm.동적계획법.개미전사.보텀업;

import java.util.Scanner;

public class Main {
    //각 창고 위치마다 빼앗을 수 있는 식량의 최대값을 저장할 DP 테이블
    public static int[] cache = new int[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        //첫 번째 식량창고까지 털 때의 식량 최대값은 첫 번째 창고의 값과 동일
        cache[1] = arr[0];
        //두 번째 식략창고까지 털 때의 식량 최대값은 첫 번째, 두 번째 창고 중에 식량이 더 많은 창고의 값과 동일
        cache[2] = Math.max(arr[0], arr[1]);
        for (int i = 3; i <= n; i++) {
            //i번째 창고를 털 때의 최대값은 바로 앞 창고까지 털었을 때의 식량 최대값과 2칸 앞의 창고까지 털었을 때 최대값에 i번째 창고의 값을 더한 값 중 더 큰 값이 된다.
            cache[i] = Math.max(cache[i - 1], cache[i - 2] + arr[i - 1]);
        }
        System.out.println(cache[n]);
    }
}
