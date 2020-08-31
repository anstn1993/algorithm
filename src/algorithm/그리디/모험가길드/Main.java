package algorithm.그리디.모험가길드;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

        //오름차순 정렬
        Arrays.sort(data);

        int index = 0;
        int result = 0;
        int max = -1;
        for (int i = data.length - 1; i >= 0; i--) {
            int value = data[i];
            if (value > i + 1) {
                continue;
            }
            i = i - value;
            if(i == 0) {
                break;
            }
            result++;
        }
//        while (true) {
//            if(index < data.length) {
//                result ++;
//                int value = data[index];
//                index += value;
//            }
//            else {
//                break;
//            }
//        }
        System.out.println(result);
    }
}
