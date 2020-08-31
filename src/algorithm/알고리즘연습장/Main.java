package algorithm.알고리즘연습장;

import java.util.*;

public class Main {

    public static int[] array = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};
    public static void quickSort(int[] array, int start, int end) {
        if(start >= end) {//리스트의 원소가 하나인 경우 재귀 함수 종료
            return;
        }

        int pivot = start;//pivot 인덱스
        int left = start + 1;//리스트의 왼쪽부터 출발하는 인덱스
        int right = end;//리스트의 오른쪽부터 출발하는 인덱스
        int temp;

        //정렬을 통한 분할
        while(left <= right) {
            while(left <= end && array[pivot] >= array[left]) {
                left ++;
            }
            while(right >= start && array[pivot] <= array[right]) {
                right --;
            }
            if(left > right) {
                temp = array[right];
                array[right] = array[pivot];
                array[pivot] = temp;
            }
            else {
                temp = array[right];
                array[right] = array[left];
                array[left] = temp;
            }
        }
        //분할이 완료되면 좌, 우 리스트에 대한 퀵 정렬 다시 시작
        quickSort(array, 0, right - 1);
        quickSort(array, right + 1, end);

    }
    public static void main(String[] args) {
        quickSort(array, 0, array.length - 1);

        for(int i = 0; i < array.length; i ++) {
            System.out.print(array[i] + " ");
        }
    }
}
