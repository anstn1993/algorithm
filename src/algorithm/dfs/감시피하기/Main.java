package algorithm.dfs.감시피하기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int n;
    public static char[][] graph = new char[7][7];
    public static String result = "NO";

    //위쪽 방향으로 탐색
    private static boolean monitorTop(int x, int y) {
        //현재 위치가 복도 맵의 범위에 있는 경우
        if (x >= 1 && x <= n && y >= 1 && y <= n) {
            //학생이 있는 경우 탐색 종료
            if (graph[x][y] == 'S') {
                return true;
            }
            //장애물이 있는 경우 탐색 종료
            else if (graph[x][y] == 'O') {
                return false;
            }
            //나머지 경우에는 계속 위쪽으로 탐색을 이어간다.
            else {
                return monitorTop(x - 1, y);
            }
        }
        //범위에서 벗어난 경우 탐색 종료
        else {
            return false;
        }
    }

    //아래쪽 방향으로 탐색
    private static boolean monitorDown(int x, int y) {
        //현재 위치가 복도 맵의 범위에 있는 경우
        if (x >= 1 && x <= n && y >= 1 && y <= n) {
            //학생이 있는 경우 탐색 종료
            if (graph[x][y] == 'S') {
                return true;
            }
            //장애물이 있는 경우 탐색 종료
            else if (graph[x][y] == 'O') {
                return false;
            }
            //나머지 경우에는 계속 아래쪽으로 탐색을 이어간다.
            else {
                return monitorDown(x + 1, y);
            }
        }
        //범위에서 벗어난 경우 탐색 종료
        else {
            return false;
        }
    }

    private static boolean monitorLeft(int x, int y) {
        //현재 위치가 복도 맵의 범위에 있는 경우
        if (x >= 1 && x <= n && y >= 1 && y <= n) {
            //학생이 있는 경우 탐색 종료
            if (graph[x][y] == 'S') {
                return true;
            }
            //장애물이 있는 경우 탐색 종료
            else if (graph[x][y] == 'O') {
                return false;
            }
            //나머지 경우에는 계속 왼쪽으로 탐색을 이어간다.
            else {
                return monitorLeft(x, y - 1);
            }
        }
        //범위에서 벗어난 경우 탐색 종료
        else {
            return false;
        }
    }

    private static boolean monitorRight(int x, int y) {
        //현재 위치가 복도 맵의 범위에 있는 경우
        if (x >= 1 && x <= n && y >= 1 && y <= n) {
            //학생이 있는 경우 탐색 종료
            if (graph[x][y] == 'S') {
                return true;
            }
            //장애물이 있는 경우 탐색 종료
            else if (graph[x][y] == 'O') {
                return false;
            }
            //나머지 경우에는 계속 오른쪽으로 탐색을 이어간다.
            else {
                return monitorRight(x, y + 1);
            }
        }
        //범위에서 벗어난 경우 탐색 종료
        else {
            return false;
        }
    }

    private static void dfs(int count) {
        //장애물이 3개가 된 경우
        if (count == 3) {
            int caughtCount = 0;
            //선생님이 있는 자리에서부터 상하좌우로 학생 탐색 시작
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][j] == 'T') {
                        //상하좌우 방향 중 한 방향으로라도 학생을 찾은 경우
                        if (monitorTop(i - 1, j) ||
                                monitorDown(i + 1, j) ||
                                monitorLeft(i, j - 1) ||
                                monitorRight(i, j + 1)) {
                            caughtCount ++;
                        }
                    }
                }
            }
            //어떤 선생님도 학생을 발견하지 못 한 경우
            if(caughtCount == 0) {
                result = "YES";
            }
        }
        //아직 장애물이 다 설치되지 못 한 경우
        else {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    //장애물 설치가 가능한 공간인 경우
                    if (graph[i][j] == 'X') {
                        graph[i][j] = 'O';//장애물 설치
                        count++;//장애물 수 증가
                        dfs(count);
                        graph[i][j] = 'X';
                        count--;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = sc.next().charAt(0);
            }
        }

        dfs(0);

        System.out.println(result);
    }
}
