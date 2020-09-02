package algorithm.구현.뱀;

import java.util.*;

/*답안 풀이
 * 나의 최초 풀이와의 핵심적인 차이점은 뱀이 차지하고 있는 공간의 좌표를 리스트에 하나하나 넣어두지 않고 그냥 이차원 배열 상에서 그 공간의 값을 2로 표현하고
 * 뱀의 머리가 있는 좌표의 값이 2면 자신의 몸과 부딫힌 것이라고 판단했다는 것이다.
 * */
class Node {
    private int second;
    private char direction;

    public Node(int second, char direction) {
        this.second = second;
        this.direction = direction;
    }

    public int getSecond() {
        return second;
    }

    public char getDirection() {
        return direction;
    }
}

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
    public static int n, k, l;
    public static int[][] arr = new int[101][101];//맵 정보
    public static List<Node> info = new ArrayList<>();//방향 회전 정보
    //방향별 이동 좌표 정보(동, 남, 서, 북)
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static int turn(int direction, char c) {
        if (c == 'L') {
            direction = (direction == 0) ? 3 : direction - 1;
        }
        else {
            direction = (direction + 1) % 4;
        }
        return direction;
    }

    public static int simulate() {
        int x = 1, y = 1;//뱀의 머리 위치
        arr[x][y] = 2;//뱀이 존재하는 위치를 2로 표시
        int direction = 0;//처음에는 동쪽을 향한다.
        int time = 0;//게임 시간
        int index = 0;//다음에 회전할 정보
        //뱀이 차지하고 있는 위치 정보(꼬리가 앞쪽)
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x, y));

        while (true) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            //맵의 범위 안에 있고 뱀의 몸통이 없는 위치라면
            if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && arr[nx][ny] != 2) {
                //사과가 없다면 이동 후 꼬리 제거
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = 2;
                    q.offer(new Position(nx, ny));
                    Position prev = q.poll();
                    arr[prev.getX()][prev.getY()] = 0;
                }
                //사과가 있으면 이동 후에 꼬리 그대로 두기
                else {
                    arr[nx][ny] = 2;
                    q.offer(new Position(nx, ny));
                }
            }
            //벽이나 뱀의 몸통과 부딪혔다면
            else {
                time += 1;
                break;
            }
            //다음 위치로 머리 이동
            x = nx;
            y = ny;
            time += 1;
            //회전할 시간인 경우 회전
            if (index < 1 && time == info.get(index).getSecond()) {
                direction = turn(direction, info.get(index).getDirection());
                index += 1;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        //맵 정보(사과가 있는 곳은 1로 표시)
        for(int i = 0; i < k; i ++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
        }

        //방향 회전 정보 입력
        l = sc.nextInt();
        for(int i = 0; i < l; i ++) {
            int x = sc.nextInt();
            char c = sc.next().charAt(0);
            info.add(new Node(x, c));
        }

        System.out.println(simulate());
    }
}

/*최초 풀이*/
/*public class Main {

    static class MoveInfo {
        private int second;
        private String direction;

        public MoveInfo(int second, String direction) {
            this.second = second;
            this.direction = direction;
        }

        public int getSecond() {
            return second;
        }

        public String getDirection() {
            return direction;
        }
    }

    private static void updateSnakePosition(List<int[]> snakeBody, int nx, int ny) {
        for (int i = snakeBody.size() - 2; i >= 0; i--) {
            snakeBody.get(i + 1)[0] = snakeBody.get(i)[0];
            snakeBody.get(i + 1)[1] = snakeBody.get(i)[1];
        }
        snakeBody.get(0)[0] = nx;
        snakeBody.get(0)[1] = ny;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<int[]> applePositions = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int[] position = {sc.nextInt() - 1, sc.nextInt() - 1};
            applePositions.add(position);
        }
        int l = sc.nextInt();
        MoveInfo[] moveInfos = new MoveInfo[l];
        for (int i = 0; i < moveInfos.length; i++) {
            int second = sc.nextInt();
            String direction = sc.next();
            moveInfos[i] = new MoveInfo(second, direction);
        }

        int second = 0;//게임 시간
        int head = 1;//뱀이 향하는 방향(우)
        boolean isLive = true;
        //이동 방향 정보(상우하좌)
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        List<int[]> snakeBody = new ArrayList<>();//뱀의 몸이 위치하고 있는 좌표들의 모음
        snakeBody.add(new int[]{0, 0});
        while (isLive) {
            second++;//초 증가
            //뱀의 진행 방향 회전

            //뱀의 머리 이동
            int[] snakeHead = snakeBody.get(0);
            int nx = snakeHead[0] + dx[head];
            int ny = snakeHead[1] + dy[head];

            //뱀의 머리가 벽인지 판정
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                isLive = false;
            }
            //뱀의 머리가 자신의 몸과 같은 위치에 있는지 판정
            for (int i = 1; i < snakeBody.size(); i++) {
                if (snakeBody.get(i)[0] == nx && snakeBody.get(i)[1] == ny) {
                    isLive = false;
                    break;
                }
            }

            int applePositionIndex = -1;
            for (int i = 0; i < applePositions.size(); i++) {
                //뱀의 머리가 위치한 곳에 사과가 있는 경우
                if (applePositions.get(i)[0] == nx && applePositions.get(i)[1] == ny) {
                    //뱀이 위치한 좌표를 추가해준다.
                    snakeBody.add(0, new int[]{nx, ny});
                    applePositionIndex = i;
                    break;
                }
            }
            //사과를 뱀이 먹었으면 해당 사과의 위치 값을 리스트에서 지워준다.
            if (applePositionIndex != -1) {
                applePositions.remove(applePositionIndex);
            }
            //뱀이 사과를 먹지 않았으면 뱀의 위치 좌표를 그냥 갱신만 해준다.
            else {
                updateSnakePosition(snakeBody, nx, ny);
            }

            //방향 전환을 해준다.
            for (int i = 0; i < moveInfos.length; i++) {
                if (moveInfos[i].getSecond() == second) {
                    if (moveInfos[i].getDirection().equals("D")) {
                        head = head == 3 ? 0 : head + 1;
                    } else {
                        head = head == 0 ? 3 : head - 1;
                    }

                }
            }
        }
        System.out.println(second);
    }

}*/
