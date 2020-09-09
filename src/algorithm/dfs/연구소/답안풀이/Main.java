package algorithm.dfs.연구소.답안풀이;

import java.util.ArrayList;
import java.util.Scanner;

class Combination {
    private int n;
    private int r;
    private int[] now;//현재 조합
    private ArrayList<ArrayList<Position>> result;//모든 조합 리스트

    public ArrayList<ArrayList<Position>> getResult() {
        return result;
    }

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<>();
    }

    public void combination(ArrayList<Position> arr, int depth, int index, int target) {
        if (depth == r) {
            ArrayList<Position> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(arr.get(now[i]));
            }
            result.add(temp);
        }
        if (target == n) return;
        now[index] = target;
        combination(arr, depth + 1, index + 1, target + 1);
        combination(arr, depth, index, target + 1);
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
    public static int n;//복도의 크기
    public static char[][] board = new char[6][6];//복도 정보
    public static ArrayList<Position> teachers = new ArrayList<>();//모든 선생님 위치 정보
    public static ArrayList<Position> spaces = new ArrayList<>();//모든 빈 공간 위치 정보

    private static boolean watch(int x, int y, int direction) {
        //왼쪽 방향 감시
        if(direction == 0) {
            while (y >= 0) {
                if(board[x][y] == 'S') {//학생 발견
                    return true;
                }
                if(board[x][y] == 'O') {//장애물 발견
                    return false;
                }
                y -= 1;
            }
        }
        //오른쪽 방향 감시
        if(direction == 1) {
            while(y < n) {
                if(board[x][y] == 'S') {//학생 발견
                    return true;
                }
                if(board[x][y] == 'O') {//장애물 발견
                    return false;
                }
                y += 1;
            }
        }
        //위쪽 방향 감시
        if(direction == 2) {
            while (x >= 0) {
                if(board[x][y] == 'S') {//학생 발견
                    return true;
                }
                if(board[x][y] == 'O') {//장애물 발견
                    return false;
                }
                x -= 1;
            }
        }
        //아래쪽 방향으로 감시
        if(direction == 3) {
            while (x < n) {
                if (board[x][y] == 'S') { // 학생이 있는 경우
                    return true;
                }
                if (board[x][y] == 'O') { // 장애물이 있는 경우
                    return false;
                }
                x += 1;
            }
        }
        return false;
    }

    private static boolean process() {
        //모든 선생의 위치를 하나씩 확인
        for (int i = 0; i < teachers.size(); i++) {
            int x = teachers.get(i).getX();
            int y = teachers.get(i).getY();
            //4가지 방향으로 학생 탐색 시작
            for (int j = 0; j < 4; j++) {
                if(watch(x, y, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.next().charAt(0);
                //선생님이 존재하는 위치 저장
                if (board[i][j] == 'T') {
                    teachers.add(new Position(i, j));
                }
                //장애물을 설치할 수 있는 빈 공간 위치 저장
                if (board[i][j] == 'X') {
                    spaces.add(new Position(i, j));
                }
            }
        }

        //빈 공간에서 3개를 뽑는 모든 조합 확인
        Combination comb = new Combination(spaces.size(), 3);
        comb.combination(spaces, 0, 0, 0);
        ArrayList<ArrayList<Position>> spaceList = comb.getResult();

        //학생이 한 명도 감지되지 않도록 장애물이 설치 가능한지 여부를 파악한다.
        boolean found = false;
        for (int i = 0; i < spaceList.size(); i++) {
            //장애물들 설치해보기
            for (int j = 0; j < spaceList.get(i).size(); j++) {
                int x = spaceList.get(i).get(j).getX();
                int y = spaceList.get(i).get(j).getY();
                board[x][y] = 'O';
            }
            //학생이 한 명도 감지되지 않는 경우
            if (!process()) {
                //원하는 경우 발견
                found = true;
                break;
            }
            //설치된 장애물 없애주기
            for (int j = 0; j < spaceList.get(i).size(); j++) {
                int x = spaceList.get(i).get(j).getX();
                int y = spaceList.get(i).get(j).getY();
                board[x][y] = 'X';
            }
        }

        if (found) System.out.println("YES");
        else System.out.println("NO");
    }
}
