package algorithm.기타그래프알고리듬.서로소집합.탑승구;

import java.util.Arrays;
import java.util.Scanner;

//나의 최초 풀이
public class Main {

    //각각 탑승구 수, 비행기 수
    public static int g, p;
    public static int result = 0;
    public static int[] indegree = new int[100001];//각 게이트로 들어오는 비행기 수
    public static int[] plane = new int[100001];//각 비행기가 도킹할 수 있는 게이트 범위

    private static void process() {
        for (int i = 1; i <= p; i++) {
            for (int j = plane[i]; j >= 1; j--) {
                if(indegree[j] == 0) {
                    indegree[j] += 1;
                    result ++;
                    break;
                }
                if(j == 1) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        g = sc.nextInt();
        p = sc.nextInt();

        Arrays.fill(plane, 100000);

        for (int i = 1; i <= p; i++) {
            plane[i] = sc.nextInt();
        }

        process();
        System.out.println(result);
    }
}
