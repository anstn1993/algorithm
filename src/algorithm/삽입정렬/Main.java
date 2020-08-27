package algorithm.삽입정렬;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
        int[] sortedArray = sortAsc(array);

        for(int i = 0; i < array.length; i ++) {
            System.out.print(sortedArray[i] + " ");
        }
        System.out.println("");

        sortedArray = sortDesc(array);

        for(int i = 0; i < array.length; i ++) {
            System.out.print(sortedArray[i] + " ");
        }
    }

    private static int[] sortAsc(int[] array) {
        int temp, i, j;

        for(i = 0; i < array.length - 1; i ++) {
            j = i;
            while(j >= 0 && array[j] > array[j + 1]) {
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                j --;
            }
        }
        return array;
    }

    private static int[] sortDesc(int[] array) {
        int i, j, temp;

        for(i = 0; i < array.length - 1; i ++) {
            j = i;
            while (j >= 0 && array[j] < array[j + 1]) {
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                j --;
            }
        }

        return array;
    }
}
