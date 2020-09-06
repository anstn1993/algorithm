package algorithm.그리디.모험가길드;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

        //오름차순 정렬
        Arrays.sort(data);
        int result = 0;//총 그룹 수
        int count = 0;//현재 그룹에 포함된 모험가 수
        for (int i = 0; i < n; i++) {
            count ++;//모험 참여자 수 증가
            //현재 모험 참여자 수가 현재 공포도보다 크거나 같으면 그룹 만들기
            if(count >= data[i]) {
                result ++;//그룹 수 증가
                count = 0;//현재 그룹의 모험가 수 초기화
            }
        }
        System.out.println(result);
    }
}
