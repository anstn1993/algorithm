package algorithm.정렬.선택정렬;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
        int[] sortedArray = sortAsc(array);
        for(int i = 0; i < array.length; i ++) {
            System.out.print(sortedArray[i] + " ");
        }
        System.out.println("");
        sortedArray = sortDesc(sortedArray);
        for(int i = 0; i < array.length; i ++) {
            System.out.print(sortedArray[i] + " ");
        }

    }

    private static int[] sortAsc(int[] array) {
        int min, temp, index = 0, i, j;

        for(i = 0; i < array.length; i ++) {
            min = 9999;
            for(j = i; j < array.length; j ++) {
                if(min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            temp = array[i];
            array[i] = min;
            array[index] = temp;
        }
        return array;
    }

    private static int[] sortDesc(int[] array) {
        int i, j, index = 0, max, temp;

        for(i = 0; i < array.length; i ++) {
            max = -1;
            for(j = i; j < array.length; j ++) {
                if(max < array[j]) {
                    max = array[j];
                    index = j;
                }
            }
            temp = array[i];
            array[i] = max;
            array[index] = temp;
        }
        return array;
    }

}
