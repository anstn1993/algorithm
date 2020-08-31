package algorithm.정렬.위에서아래로;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] array = new Integer[n];
        for(int i = 0; i < n; i ++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array, Collections.reverseOrder());
        for(int i = 0; i < n; i ++) {
            System.out.print(array[i] + " ");
        }

    }
}
