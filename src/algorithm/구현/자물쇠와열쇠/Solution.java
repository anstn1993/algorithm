package algorithm.구현.자물쇠와열쇠;


import java.util.Arrays;

public class Solution {
    //열쇠 행렬을 90도 회전
    public void rotateMatrixBy90Degree(int[][] matrix) {
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

    //자물쇠 행렬의 모든 값이 1이 되는지 확인
    public boolean check(int[][] tripleSizedLock) {
        int n = tripleSizedLock.length / 3;
        for (int i = n; i < 2 * n; i++) {
            for (int j = n; j < 2 * n; j++) {
                if(tripleSizedLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solution(int[][] key, int[][] lock) {

        int n = lock.length;//자물쇠 행렬의 행, 열 크기
        int m = key.length;//열쇠 행렬의 행, 열 크기

        //자물쇠 행렬 크기의 3배가 되는 행렬을 만든다.
        int[][] tirpleSizedLock = new int[3 * n][3 * n];
        //새롭게 만들어진 자물쇠의 중앙부분에 기존의 자물쇠 행렬의 값을 넣어준다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tirpleSizedLock[n + i][n + j] = lock[i][j];
            }
        }
        //자물쇠를 4가지 방향으로 돌려가면서 확인
        for (int rotation = 0; rotation < 4; rotation++) {
            rotateMatrixBy90Degree(key);//열쇠 회전
            for (int x = 0; x < 2 * n; x++) {
                for (int y = 0; y < 2 * n; y++) {
                    //자물쇠에 열쇠 삽입
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            tirpleSizedLock[x + i][y + j] += key[i][j];
                        }
                    }
                    //열쇠와 자물쇠가 맞아떨어지는지 검사
                    if (check(tirpleSizedLock)) return true;
                    //자물쇠에서 열쇠 빼기
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            tirpleSizedLock[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }
        }

        return false;
    }
}
