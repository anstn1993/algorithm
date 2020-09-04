package algorithm.동적계획법.바닥공사.보텀업;

import java.util.Scanner;

public class Main {

    public static int[] cache = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        cache[1] = 1;
        cache[2] = 3;
        for (int i = 3; i <= n; i++) {
            cache[i] = (cache[i - 1] + 2 * cache[i - 2]) % 796796;
        }
        System.out.println(cache[n]);
    }
}
