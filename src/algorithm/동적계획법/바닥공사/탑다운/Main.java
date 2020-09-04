package algorithm.동적계획법.바닥공사.탑다운;

import java.util.Scanner;

public class Main {

    public static int[] cache = new int[1001];

    public static int getCount(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 3;
        }
        if(cache[n] != 0) {
            return cache[n];
        }
        cache[n] = (getCount(n - 1) + 2 * getCount(n - 2)) % 796796;
        return cache[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getCount(n));
    }
}
