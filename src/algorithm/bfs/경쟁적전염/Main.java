package algorithm.bfs.경쟁적전염;

import java.util.*;

class Virus implements Comparable<Virus> {
    private int num;
    private int x;
    private int y;
    private int second;

    public Virus(int num, int x, int y, int second) {
        this.num = num;
        this.x = x;
        this.y = y;
        this.second = second;
    }

    public int getNum() {
        return num;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public int compareTo(Virus other) {
        return Integer.compare(this.num, other.num);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//시험관 크기
        int k = sc.nextInt();//바이러스의 종류 수
        int[][] arr = new int[n + 1][n + 1];//시험관 정보
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int s = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        //상하좌우 위치 이동 정보
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        //큐로 바이러스의 번호가 낮은 애들부터 들어가게 한다.
        List<Virus> virusList = new ArrayList<>();
        Queue<Virus> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(arr[i][j] != 0) {
                    virusList.add(new Virus(arr[i][j], i, j, 0));
                }
            }
        }

        Collections.sort(virusList);
        for(int i = 0; i < virusList.size(); i ++) {
            q.offer(virusList.get(i));
        }

        while(!q.isEmpty()) {
            Virus currentVirus = q.poll();//가장 번호가 낮은 바이러스부터 뽑아낸다.
            //입력받은 초가 됐을 때 반복문 탈출
            if(currentVirus.getSecond() == s) {
                break;
            }
            //상하좌우로 조건을 만족하는 경우에 바이러스 전염
            for(int i = 0; i < 4; i ++) {
                int nx = currentVirus.getX() + dx[i];
                int ny = currentVirus.getY() + dy[i];
                //현재 바이러스의 인접한 칸의 위치가 시험관 범위 안에 있는 경우
                if(nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
                    //아직 바이러스에 전염되지 않은 경우
                    if(arr[nx][ny] == 0) {
                        //바이러스를 감염시키고
                        arr[nx][ny] = currentVirus.getNum();
                        //큐에 해당 위치에 대한 바이러스 객체를 추가해준다.
                        q.offer(new Virus(arr[nx][ny], nx, ny, currentVirus.getSecond() + 1));
                    }
                }
            }
        }
        System.out.println(arr[x][y]);
    }
}
