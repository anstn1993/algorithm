package algorithm.알고리즘연습장;

import java.util.*;

public class Main {

    public static int n, x;
    public static int[] arr = new int[1000001];

    private static int findFirstIndex(int[] arr, int target, int start, int end) {
        if(start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if(arr[mid] == target && (mid == 0 || arr[mid - 1] < target)) {
            return mid;
        }
        else if(arr[mid] >= target) {
            return findFirstIndex(arr, target, start, mid - 1);
        }
        else {
            return findFirstIndex(arr, target, mid + 1, end);
        }
    }

    private static int findLastIndex(int[] arr, int target, int start, int end) {
        if(start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if(arr[mid] == target && (mid == n - 1 || arr[mid + 1] > target)) {
            return mid;
        }
        else if(arr[mid] > target) {
            return findLastIndex(arr, target, start, mid - 1);
        }
        else {
            return findLastIndex(arr, target, mid + 1, end);
        }
    }

    private static int countByValue(int[] arr, int target) {

        int firstIndex = findFirstIndex(arr, target, 0, n - 1);
        int lastIndex = findLastIndex(arr, target, 0, n - 1);

        if(firstIndex == -1) {
            return 0;
        }

        return lastIndex - firstIndex + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        x = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = countByValue(arr, x);

        if(count == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(count);
        }
    }
}
