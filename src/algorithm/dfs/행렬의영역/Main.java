package algorithm.dfs.행렬의영역;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int count = 0;//영역의 개수
    private static List<Integer> sizeList = new ArrayList<>();//각 영역의 크기
    //상하좌우 정보
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    //자신의 상하좌우 칸에 1이 있는지 탐색하고 1의 총 개수를 반환
    private static int dfs(int[][] matrix, int x, int y, int size) {
        matrix[x][y] = 0;//현재 칸의 숫자를 0으로 바꿔준다.
        size ++;//영역의 크기를 1늘려준다.
        //상하좌우의 영역의 숫자가 1이면 그 영역에 대한 dfs수행
        for(int i = 0; i < 4; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            //행렬 영역 안에 있을 때만 수행
            if(nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix.length) {
                //인접 영역의 값이 1인 경우
                if(matrix[nx][ny] == 1) {
                    size = dfs(matrix, nx, ny, size);
                }
            }
        }
        return size;
    }

    private static void solution(int sizeOfMatrix, int[][] matrix) {
        // TODO: 이곳에 코드를 작성하세요.
        for (int i = 0; i < sizeOfMatrix; i++) {
            for(int j = 0; j < sizeOfMatrix; j++) {
                if(matrix[i][j] == 1) {
                    count ++;//영역의 개수 +1
                    sizeList.add(dfs(matrix, i, j, 0));
                }
            }
        }

        if (sizeList.size() == 0) {
            System.out.println(0);
            return;
        }

        Collections.sort(sizeList);//오름차순 정렬
        System.out.println(count);
        for (int i = 0; i < sizeList.size(); i++) {
            if (i != sizeList.size() - 1) {
                System.out.print(sizeList.get(i) + " ");
            } else {
                System.out.println(sizeList.get(i));
            }
        }
    }

    private static class InputData {
        int sizeOfMatrix;
        int[][] matrix;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
            for (int i = 0; i < inputData.sizeOfMatrix; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.sizeOfMatrix; j++) {
                    inputData.matrix[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.sizeOfMatrix, inputData.matrix);
    }
}