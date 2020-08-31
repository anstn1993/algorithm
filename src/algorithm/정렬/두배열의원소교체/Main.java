package algorithm.정렬.두배열의원소교체;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);//오름차순 정렬
        Arrays.sort(b, Collections.reverseOrder());//내림차순 정렬

        for (int i = 0; i < k; i++) {
            if (a[i] < b[i]) {
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            }
            else {
                break;//a의 원소가 b의 원소보다 크다는 건 이미 그 뒤로는 값을 바꿀 필요가 없어짐을 의미하기 때문에 반복문 탈출
            }
        }

        int sum = Arrays.stream(a).sum();
        System.out.println(sum);
    }
}
