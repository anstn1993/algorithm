package algorithm.퀵정렬;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
        int[] sortedArray = sortAsc(array, 0, array.length - 1);

        for(int i = 0; i < array.length; i ++) {
            System.out.print(sortedArray[i] + " ");
        }
        System.out.println("");

        sortedArray = sortDesc(array, 0, array.length - 1);

        for(int i = 0; i < array.length; i ++) {
            System.out.print(sortedArray[i] + " ");
        }
    }

    private static int[] sortAsc(int[] array, int start, int end) {
        if(start >= end) {
            return array;
        }

        int pivotIndex = start;
        int i = start + 1;
        int j = end;
        int temp;

        while(i <= j) {
            while(i <= end && array[pivotIndex] <= array[i]) {
                i ++;
            }
            while(j > start && array[pivotIndex] >= array[j]) {
                j --;
            }
            if(i > j) {
                temp = array[pivotIndex];
                array[pivotIndex] = array[j];
                array[j] = temp;
            }
            else {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        sortAsc(array, start, j - 1);
        sortAsc(array, j + 1, end);
        return array;
    }

    private static int[] sortDesc(int[] array, int start, int end) {
        if(start >= end) {
            return array;
        }

        int pivotIndex = start;
        int i = start + 1;
        int j = end;
        int temp;

        while(i <= j) {
            while(i <= end && array[pivotIndex] >= array[i]) {
                i ++;
            }
            while(j > start && array[pivotIndex] <= array[j]) {
                j --;
            }
            if(i > j) {
                temp = array[pivotIndex];
                array[pivotIndex] = array[j];
                array[j] = temp;
            }
            else {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        sortDesc(array, start, j - 1);
        sortDesc(array, j + 1, end);
        return array;
    }
}
