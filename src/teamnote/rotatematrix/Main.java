package teamnote.rotatematrix;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //행렬을 시계방향으로 90도 회전
    public static void rotateMatrixBy90Degree(int[][] matrix) {
        int n = matrix.length;
        //깊은 복사
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            copy[i] = Arrays.copyOf(matrix[i], n);
        }
        //90도 회전
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = copy[matrix.length - 1 - j][i];
            }
        }
    }

    //행렬을 반시계방향으로 90도 회전
    public static void rotateBy90DegreeToReverseDirection(int[][] matrix) {
        int n = matrix.length;
        //깊은 복사
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            copy[i] = Arrays.copyOf(matrix[i], n);
        }
        //90도 회전
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = copy[j][matrix.length - 1 - i];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        //행렬 90도 회전
        rotateMatrixBy90Degree(matrix);
        //출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


    }
}
