package algorithm.구현.기둥과보설치;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Frame implements Comparable<Frame> {
    private int type;//0: 보, 1: 기둥
    private int x;
    private int y;

    public Frame(int type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public int getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Frame other) {
        if (this.x < other.x) {
            return -1;
        } else if (this.x > other.x) {
            return 1;
        }
        //x좌표가 같은 경우
        else {
            if (this.y < other.y) {
                return -1;
            } else if (this.y > other.y) {
                return 1;
            }
            //y좌표가 같은 경우
            else {
                if (this.type < other.type) {
                    return -1;
                } else if (this.type > other.type) {
                    return 1;
                }
            }
        }
        return -1;
    }
}

class Solution {

    //현재 구조물이 조건에 부합하는지 검사
    public boolean isPossible(List<Frame> tempAnswer) {
        for (int i = 0; i < tempAnswer.size(); i++) {
            int x = tempAnswer.get(i).getX();
            int y = tempAnswer.get(i).getY();
            int type = tempAnswer.get(i).getType();

            //기둥인 경우
            if (type == 0) {
                boolean check = false;
                //바닥에 설치된 경우
                if (y == 0) {
                    check = true;
                }
                for(int j = 0; j < tempAnswer.size(); j++) {
                    //자신의 밑에 기둥이 있는 경우
                    if(x == tempAnswer.get(j).getX() && y - 1 == tempAnswer.get(j).getY() && 0 == tempAnswer.get(j).getType()) {
                        check = true;
                    }
                    //보의 한쪽 끝 부분 위인 경우
                    if(x - 1 == tempAnswer.get(j).getX() && y == tempAnswer.get(j).getY() && 1 == tempAnswer.get(j).getType()) {
                        check = true;
                    }
                    if(x == tempAnswer.get(j).getX() && y == tempAnswer.get(j).getY() && 1 == tempAnswer.get(j).getType()) {
                        check = true;
                    }
                }
                //조건을 만족하지 않는 경우가 나오면 그냥 종료
                if(check == false) return false;
            }
            //보인 경우
            else {
                boolean check = false;
                boolean left = false;
                boolean right = false;
                for(int j = 0; j < tempAnswer.size(); j ++) {
                    //한쪽 끝 부분이 기둥 위인 경우
                    if(x == tempAnswer.get(j).getX() && y - 1 == tempAnswer.get(j).getY() && 0 == tempAnswer.get(j).getType()) {
                        check = true;
                    }
                    if(x + 1 == tempAnswer.get(j).getX() && y - 1 == tempAnswer.get(j).getY() && 0 == tempAnswer.get(j).getType()) {
                        check = true;
                    }
                    //양 옆이 보인 경우
                    if(x - 1 == tempAnswer.get(j).getX() && y == tempAnswer.get(j).getY() && 1 == tempAnswer.get(j).getType()) {
                        left = true;
                    }
                    if(x + 1 == tempAnswer.get(j).getX() && y == tempAnswer.get(j).getY() && 1 == tempAnswer.get(j).getType()) {
                        right = true;
                    }
                }
                //조건을 만족하지 않는 경우가 나오면 그냥 종료
                if(left && right) check = true;
                if(check == false) return false;
            }
        }
        return true;
    }

    public int[][] solution(int n, int[][] build_frame) {

        List<Frame> tempAnswer = new ArrayList<>();

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int type = build_frame[i][2];//0이면 기둥, 1이면 보
            int installOrDelete = build_frame[i][3];//0이면 삭제, 1이면 설치
            //설치인 경우
            if (installOrDelete == 1) {
                //설치해보고
                tempAnswer.add(new Frame(type, x, y));
                //구조가 조건에 위배되는 경우에는 다시 되돌린다.
                if (!isPossible(tempAnswer)) {
                    tempAnswer.remove(tempAnswer.size() - 1);
                }
            }
            //제거인 경우
            else {
                Frame removed = null;
                //제거해보고
                for (int j = 0; j < tempAnswer.size(); j++) {
                    if (tempAnswer.get(j).getX() == x && tempAnswer.get(j).getY() == y && tempAnswer.get(j).getType() == type) {
                        removed = tempAnswer.remove(j);
                        break;
                    }
                }
                //구조가 조건에 위배되는 경우에는 다시 되돌린다.
                if (!isPossible(tempAnswer)) {
                    tempAnswer.add(removed);
                }
            }
        }

        Collections.sort(tempAnswer);
        int[][] answer = new int[tempAnswer.size()][3];
        for (int i = 0; i < tempAnswer.size(); i++) {
            answer[i][0] = tempAnswer.get(i).getX();
            answer[i][1] = tempAnswer.get(i).getY();
            answer[i][2] = tempAnswer.get(i).getType();
        }
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] build_frame = new int[m][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 4; j++) {
                build_frame[i][j] = sc.nextInt();
            }
        }

        Solution solution = new Solution();
        solution.solution(n, build_frame);
    }
}
