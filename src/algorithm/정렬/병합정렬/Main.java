package algorithm.정렬.병합정렬;

public class Main {

    static int[] sorted = new int[8];
    public static void main(String[] args) {
        int[] data = new int[]{7, 6, 5, 8, 3, 5, 9, 1};
        mergeSort(data, 0, data.length - 1);
        for(int i = 0; i < data.length; i ++) {
            System.out.print(data[i] + " ");
        }
    }

    private static void mergeSort(int[] data, int m, int n) {
        if(m < n) {
            int middle = (n + m) / 2;
            mergeSort(data, m, middle);
            mergeSort(data, middle + 1, n);
            merge(data, m, middle, n);
        }
    }

    private static void merge(int[] data, int m, int middle, int n) {
        int i = m;
        int j = middle + 1;
        int k = m;

        while(i <= middle && j <= n) {
            if(data[i] <= data[j]) {
                sorted[k] = data[i];
                i ++;
            }
            else {
                sorted[k] = data[j];
                j ++;
            }
            k ++;
        }
        if(i > middle) {
            for(int t = j; t <= n; t ++) {
                sorted[k] = data[t];
                k ++;
            }
        }
        else {
            for(int t = i; t <= middle; t ++) {
                sorted[k] = data[t];
                k ++;
            }
        }

        for(int t = m; t <= n; t ++) {
            data[t] = sorted[t];
        }

    }
}
