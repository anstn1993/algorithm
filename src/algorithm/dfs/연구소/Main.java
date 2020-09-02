package algorithm.dfs.연구소;

import java.util.Scanner;

public class Main {

    public static int n, m, result = 0;
    public static int[][] arr = new int[8][8];//초기 맵 배열
    public static int[][] temp = new int[8][8];//벽을 설치한 뒤의 맵 배열

    //4가지 이동 방향에 대한 정보(상, 하, 좌, 우)
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(0);
        System.out.println(result);

    }

    //깊이 우선 탐색을 통해서 각 바이러스가 사방으로 퍼지게 한다.
    private static void virus(int x, int y) {
        for(int i = 0; i < 4; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            //상, 하, 좌, 우 중에 바이러스가 퍼질 수 있는 공간인 경우
            if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if(temp[nx][ny] == 0) {
                    //해당 위치에 바이러스를 배치하고 다시 virus를 수행
                    temp[nx][ny] = 2;
                    virus(nx, ny);
                }
            }
        }
    }

    private static int getScore() {
        int score = 0;
        for(int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if(temp[i][j] == 0) {
                    score ++;
                }
            }
        }
        return score;
    }

    private static void dfs(int count) {
        //울타리가 3개 설치된 경우
        if (count == 3) {
            //현재 맵 상태를 temp에 옮겨준다.
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    temp[i][j] = arr[i][j];
                }
            }
            //바이러스가 있는 자리부터 전파 수행
            for(int i = 0; i < n; i ++) {
                for(int j = 0; j < m; j ++) {
                    if(temp[i][j] == 2) {
                        virus(i, j);
                    }
                }
            }
            //안전 영역의 최대값 계산
            result = Math.max(result, getScore());
            return;
        }
        //아직 설치가 완료되지 않은 경우
        else {
            //이 부분이 핵심
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 0) {
                        arr[i][j] = 1;
                        count++;
                        dfs(count);
                        arr[i][j] = 0;
                        count--;
                    }
                }
            }
        }
    }
}
