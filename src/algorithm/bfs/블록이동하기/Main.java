package algorithm.bfs.블록이동하기;

import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;

class Node {
    private int pos1X;
    private int pos1Y;
    private int pos2X;
    private int pos2Y;

    public Node(int pos1X, int pos1Y, int pos2X, int pos2Y) {
        this.pos1X = pos1X;
        this.pos1Y = pos1Y;
        this.pos2X = pos2X;
        this.pos2Y = pos2Y;
    }

    public int getPos1X() {
        return pos1X;
    }

    public int getPos1Y() {
        return pos1Y;
    }

    public int getPos2X() {
        return pos2X;
    }

    public int getPos2Y() {
        return pos2Y;
    }
}

class Solution {

    private List<Node> getNextPos(Node currentNode, int[][] newBoard) {
        List<Node> nextPos = new ArrayList<>();
        //상하좌우 이동 정보
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        //상하좌우로 다 이동을 시켜본다.
        for (int i = 0; i < 4; i++) {
            int pos1NextX = currentNode.getPos1X() + dx[i];
            int pos1NextY = currentNode.getPos1Y() + dy[i];
            int pos2NextX = currentNode.getPos2X() + dx[i];
            int pos2NextY = currentNode.getPos2Y() + dy[i];
            //이동하고자 하는 칸이 모두 비어있으면
            if (newBoard[pos1NextX][pos1NextY] == 0 && newBoard[pos2NextX][pos2NextY] == 0) {
                //이동 가능한 경로에 추가
                nextPos.add(new Node(pos1NextX, pos1NextY, pos2NextX, pos2NextY));
            }
        }

        //현재 로봇이 가로로 놓인 경우
        int[] hor = {-1, 1};
        if (currentNode.getPos1X() == currentNode.getPos2X()) {
            for (int i = 0; i < 2; i++) {//위쪽으로 회전하거나 아래쪽으로 회전
                if (newBoard[currentNode.getPos1X() + hor[i]][currentNode.getPos1Y()] == 0 && newBoard[currentNode.getPos2X() + hor[i]][currentNode.getPos2Y()] == 0) {
                    //회전한 위치도 갈 수 있는 위치로 추가해준다.
                    nextPos.add(new Node(currentNode.getPos1X(), currentNode.getPos1Y(), currentNode.getPos1X() + hor[i], currentNode.getPos1Y()));
                    nextPos.add(new Node(currentNode.getPos2X(), currentNode.getPos2Y(), currentNode.getPos2X() + hor[i], currentNode.getPos2Y()));
                }
            }
        }

        //현재 로봇이 세로로 놓인 경우
        int[] ver = {-1, 1};
        if (currentNode.getPos1Y() == currentNode.getPos2Y()) {
            for (int i = 0; i < 2; i++) {//왼쪽이나 오른쪽으로 회전
                //왼쪽이나 오른쪽 두 칸이 모두 비어있는 경우
                if (newBoard[currentNode.getPos1X()][currentNode.getPos1Y() + ver[i]] == 0 && newBoard[currentNode.getPos2X()][currentNode.getPos2Y() + ver[i]] == 0) {
                    //회전한 위치도 갈 수 있는 위치로 추가
                    nextPos.add(new Node(currentNode.getPos1X(), currentNode.getPos1Y(), currentNode.getPos1X(), currentNode.getPos1Y() + ver[i]));
                    nextPos.add(new Node(currentNode.getPos2X(), currentNode.getPos2Y(), currentNode.getPos2X(), currentNode.getPos2Y() + ver[i]));
                }
            }
        }
        return nextPos;
    }

    public int solution(int[][] board) {
        //맵의 외곽에 벽을 두는 형태로 변환해준다.
        int n = board.length;
        int[][] newBoard = new int[n + 2][n + 2];
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(newBoard[i], 1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newBoard[i + 1][j + 1] = board[i][j];
            }
        }
        //bfs를 수행하기 위한 큐
        Node pos = new Node(1, 1, 1, 2);//시작 위치 설정
        List<Node> visited = new ArrayList<>();//방문한 곳을 기록하기 위한 리스트
        Queue<List> q = new LinkedList<>();
        List posAndCost = new ArrayList();
        posAndCost.add(pos);
        posAndCost.add(0);
        q.offer(posAndCost);//시작 위치를 큐에 삽입
        visited.add(pos);//시작 위치를 방문 처리
        //큐가 사라질 때까지 반복
        while (!q.isEmpty()) {
            List current = q.poll();
            Node currentNode = (Node) current.get(0);//현재 위치
            int cost = (int) current.get(1);//현재 총 이동 비용
            //로봇의 위치가 (n, n)인 경우 탐색 종료
            if ((currentNode.getPos1X() == n && currentNode.getPos1Y() == n) || (currentNode.getPos2X() == n && currentNode.getPos2Y() == n)) {
                return cost;
            }
            //현재 위치에서 방문 가능한 위치 리스트 반환받기
            List<Node> nextPos = getNextPos(currentNode, newBoard);
            for (int i = 0; i < nextPos.size(); i++) {
                boolean check = true;//아직 방문하지 않은 위치는 큐에 삽입하고 방문 처리
                Node position = nextPos.get(i);
                for (int j = 0; j < visited.size(); i++) {
                    //현재 위치에 방문한 적이 있는 경우
                    if (position.getPos1X() == visited.get(j).getPos1X() &&
                            position.getPos1Y() == visited.get(j).getPos1Y() &&
                            position.getPos2X() == visited.get(j).getPos2X() &&
                            position.getPos2Y() == visited.get(j).getPos2Y()) {
                        check = false;
                        break;
                    }
                }
                //방문한 적이 없으면
                if (check) {
                    List p = new ArrayList();
                    p.add(position);
                    p.add(cost + 1);
                    q.offer(p);//큐에 삽입 후
                    visited.add(position);//방문 처리
                }
            }
        }
        return 0;
    }
}


public class Main {
    public static void main(String[] args) {

    }
}
