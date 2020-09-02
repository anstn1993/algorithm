package algorithm.이진탐색.부품찾기.set자료형풀이;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> parts = new HashSet<>();
        for (int i = 0; i < n; i++) {
            parts.add(sc.nextInt());
        }
        int m = sc.nextInt();
        int[] requests = new int[m];
        for (int i = 0; i < m; i++) {
            requests[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            if(parts.contains(requests[i])) {
                System.out.print("yes ");
            }
            else {
                System.out.print("no ");
            }
        }
    }
}
