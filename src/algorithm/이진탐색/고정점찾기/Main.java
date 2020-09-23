package algorithm.이진탐색.고정점찾기;

import java.util.Scanner;

public class Main {

    private static int binarySearch(int[] arr, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if(mid == arr[mid]) {
                return mid;
            }
            else if(mid < arr[mid]) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = binarySearch(arr, 0, n - 1);
        System.out.println(result);
    }
}
