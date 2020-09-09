package algorithm.bfs.인구이동;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {
    //순서대로 땅의 크기, 최소 인구차, 최대 인구차
    public static int n, l, r;
    //각 땅의 인구 수를 담는 테이블
    public static int[][] a = new int[51][51];
    //연합 정보를 나타내는 테이블
    public static int[][] unions = new int[51][51];
    //연합 국가들끼리 모아두기 위한 리스트
    public static ArrayList<ArrayList<Integer>> union = new ArrayList<>();
    //상하좌우 이동방향 정보
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    //특정 국가에서 시작해서 모든 연합을 bfs로 탐색한 후 데이터 갱신
    private static void process(int x, int y, int unionNum) {
        //현재 국가와 연합인 나라 위치를 담는 리스트
        ArrayList<Position> united = new ArrayList<>();
        united.add(new Position(x, y));//현재 위치를 추가
        //너비 우선 탐색을 위한 큐
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x, y));
        unions[x][y] = unionNum;//현재 국가에 연합 번호 부여
        int summary = a[x][y];//현재 연합의 전체 인구수
        int count = 1;//현재 연합국 숫자
        while (!q.isEmpty()) {
            Position current = q.poll();
            x = current.getX();
            y = current.getY();
            //현재 위치에서 상하좌우 국가를 확인하고 조건에 맞는 경우 큐에 삽입
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                //좌표가 범위에 포함되고 아직 연합이 없는 경우에만
                if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && unions[nx][ny] == -1) {
                    int gap = Math.abs(a[x][y] - a[nx][ny]);
                    //두 국가의 차이가 l 이상, r 이하인 경우에만
                    if (gap >= l && gap <= r) {
                        q.offer(new Position(nx, ny));//큐에 추가
                        unions[nx][ny] = unionNum;//연합번호 할당
                        summary += a[nx][ny];//전체 인구수 증가
                        count++;//현재 연합의 연합국 숫자 증가
                        united.add(new Position(nx, ny));
                    }
                }
            }
        }
        //연합국끼리 인구 분배
        for (int i = 0; i < united.size(); i++) {
            x = united.get(i).getX();
            y = united.get(i).getY();
            a[x][y] = summary / count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        //각 땅의 인구수 설정
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        //연합국 리스트 초기화
        for (int i = 0; i <= n * n; i++) {
            union.add(new ArrayList<>());
        }

        int result = 0;
        //인구 이동이 불가능할 때까지 반복
        while (true) {
            int unionNum = 0;//연합 번호
            //연합 정보 초기화
            for (int x = 1; x <= n; x++) {
                for (int y = 1; y <= n; y++) {
                    unions[x][y] = -1;
                }
            }

            for (int x = 1; x <= n; x++) {
                for (int y = 1; y <= n; y++) {
                    //해당 국가가 아직 처리되지 않은 경우
                    if (unions[x][y] == -1) {
                        process(x, y, unionNum);
                        unionNum++;
                    }
                }
            }
            if (unionNum == n * n) break;//연합국 번호가 n*n까지 올라갔다는 건 연합이 하나도 일어나지 않았음을 의미한다.
            result ++;
        }
        System.out.println(result);
    }
}
