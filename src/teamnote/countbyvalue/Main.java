package teamnote.countbyvalue;

import java.util.Scanner;

public class Main {

    //각각 주어지는 정수의 개수, 찾아야 할 수
    public static int n, x;

    //x의 개수
    public static int count = 0;

    private static int findFirstIndex(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        //중간 값이 x값이면서 중간 인덱스가 0이거나 중간값이 x면서 중간값 바로 왼쪽 값이 x가 아닌 경우
        //현재 중간 인덱스가 x값의 시작 인덱스가 된다.
        if (arr[mid] == target && (mid == 0 || arr[mid - 1] < target)) {
            return mid;
        }
        //중간 값이 x값보다 크거나 같은 경우
        else if (arr[mid] >= target) {
            return findFirstIndex(arr, target, start, mid - 1);
        }
        //중간 값이 x값보다 작은 경우
        else {
            return findFirstIndex(arr, target, mid + 1, end);
        }
    }


    private static int findLastIndex(int[] arr, int target, int start, int end) {
        if(start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        //중간 값이 x이면서 중간 인덱스가 마지막 인덱스거나 중간 값이 x이면서 바로 오른쪽 값이 x가 아닌 경우
        if(arr[mid] == target && (mid == n - 1 || arr[mid + 1] > target)) {
            return mid;
        }
        //중간 값이 x보다 큰 경우 경우
        else if(arr[mid] > target) {
            return findLastIndex(arr, target, start, mid - 1);
        }
        else {
            //중간 값이 x보다 작거나 같은 경우
            return findLastIndex(arr, target, mid + 1, end);
        }
    }

    private static int countByValue(int[] arr, int x) {

        int firstIndex = findFirstIndex(arr, x, 0, n - 1);//x가 등장하는 첫 번째 인덱스

        //x인 인덱스가 존재하지 않으면
        if (firstIndex == -1) {
            return 0;//x가 리스트에 없는 것이기 때문에 바로 0 return
        }

        int lastIndex = findLastIndex(arr, x, 0, n - 1);//x가 등장하는 마지막 인덱스

        //개수 반환
        return lastIndex - firstIndex + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = countByValue(arr, x);//값이 x인 데이터의 개수 구하기

        //결과 출력
        if (count == 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}
