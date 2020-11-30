package algorithm.알고리즘연습장;


public class Main {

    private static int[] array = new int[]{1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
    private static void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    private static void quickSort(int start, int end) {
        if(start >= end) {
            return;
        }

        int pivot = start;
        int i = start + 1;
        int j = end;
        int temp;
        while(i < j) {
            while(i <= end && array[pivot] >= array[i]) {
                i ++;
            }
            while(j > start && array[pivot] <= array[j]) {
                j --;
            }
            if(i > j) {
                temp = array[pivot];
                array[pivot] = array[j];
                array[j] = temp;
                quickSort(start, j - 1);
                quickSort(j + 1, end);
            }
            else {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }
    public static void main(String[] args) {
        quickSort(0, array.length - 1);
        print();
    }
}