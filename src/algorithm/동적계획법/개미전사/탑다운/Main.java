package algorithm.동적계획법.개미전사.탑다운;

import java.util.Scanner;

public class Main {
    //각 창고 위치마다 빼앗을 수 있는 식량의 최대값을 저장할 캐싱 리스트
    public static int[] cache = new int[101];
    public static int[] arr = new int[101];

    //탑 다운 방식으로 최대 식량 값 도출
    private static int getMaxCount(int n) {
        if(n == 1) {
            return arr[1];
        }
        if(n == 2) {
           return Math.max(arr[1], arr[2]);
        }
        //n번째 창고까지의 최대 식량 값이 캐싱되어 있으면 그 값을 리턴
        if(cache[n] != 0) {
            return cache[n];
        }
        cache[n] = Math.max(getMaxCount(n - 1), getMaxCount(n - 2) + arr[n]);
        return cache[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(getMaxCount(n));
    }
}
