package algorithm.이진탐색.부품찾기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static boolean binarySearch(int[] parts, int target, int start, int end) {
        if(start > end) {
            return false;
        }
        int mid = (start + end) / 2;
        if(parts[mid] == target) {
            return true;
        }
        else if(target < parts[mid]) {
            return binarySearch(parts, target, start, mid - 1);
        }
        else {
            return binarySearch(parts, target, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] parts = new int[n];
        for (int i = 0; i < n; i++) {
            parts[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] requests = new int[m];
        for (int i = 0; i < m; i++) {
            requests[i] = sc.nextInt();
        }

        //오름차순 정렬
        Arrays.sort(parts);
        for(int i = 0; i < m; i ++) {
            if(binarySearch(parts, requests[i], 0, n - 1)) {
                System.out.print("yes ");
            }
            else {
                System.out.print("no ");
            }
        }
    }
}
