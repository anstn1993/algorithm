package algorithm.정렬.안테나;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        int[] result = new int[n];//거리 총합 값을 담을 리스트
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        //오름차순 정렬
        Arrays.sort(data);

        //중간 값 인덱스
        int mid = (data.length - 1) / 2;

        System.out.println(data[mid]);
    }
}
