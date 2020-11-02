package algorithm.구현.빗물;

import java.util.Scanner;

/*
* 백준 14719번
* */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int[] blocks = new int[w];
        int result = 0;
        for (int i = 0; i < w; i++) {
            blocks[i] = sc.nextInt();
        }

        //평면의 각 칸을 순회한다.
        for (int i = 1; i < w - 1; i++) {
            int currentHeight = blocks[i];//현재 칸의 높이
            int leftMaxHeight = 0;//현재 칸을 기준으로 왼쪽 칸들 중 최대 높이 값
            int rightMaxHeight = 0;//현재 칸을 기준으로 오른쪽 칸들 중 최대 높이 값
            //현재 칸의 왼쪽 칸들 중 최대 높이 값을 구한다.
            for (int left = i - 1; left >= 0; left--) {
                if (blocks[left] > leftMaxHeight) {
                    leftMaxHeight = blocks[left];
                }
            }
            //현재 칸의 오른쪽 칸들 중 최대 높이 값을 구한다.
            for (int right = i + 1; right < w; right++) {
                if (blocks[right] > rightMaxHeight) {
                    rightMaxHeight = blocks[right];
                }
            }
            //현재 칸의 높이가 좌, 우의 최대 높이값들보다 모두 작은 경우에만 빗물이 찰 수 있다.
            if (currentHeight < leftMaxHeight && currentHeight < rightMaxHeight) {
                //빗물이 채워지는 칸의 수는 좌, 우의 높이 값 중에 더 작은 값에서 현재 칸의 높이를 뺀 만큼이다.
                result += ((leftMaxHeight >= rightMaxHeight) ? rightMaxHeight : leftMaxHeight) - currentHeight;
            }
        }
        System.out.println(result);
    }
}
