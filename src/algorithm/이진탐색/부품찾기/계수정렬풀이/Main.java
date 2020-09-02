package algorithm.이진탐색.부품찾기.계수정렬풀이;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] parts = new int[n];
        for (int i = 0; i < n; i++) {
            parts[i] = sc.nextInt();
        }
        int[] count = new int[1000001];
        for(int i = 0; i < n; i ++) {
            count[parts[i]] += 1;
        }
        int m = sc.nextInt();
        int[] requests = new int[m];
        for (int i = 0; i < m; i++) {
            requests[i] = sc.nextInt();
        }

        for(int i = 0; i < m; i ++) {
            if(count[requests[i]] != 0) {
                System.out.print("yes ");
            }
            else {
                System.out.print("no ");
            }
        }

    }
}
