package algorithm.알고리즘연습장;

import java.util.*;

class Frame implements Comparable<Frame> {
    private int x;
    private int y;
    private int type;

    public Frame(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getType() {
        return type;
    }

    @Override
    public int compareTo(Frame o) {
        if (this.x < o.x) {
            return -1;
        } else if (this.x > o.x) {
            return 1;
        } else {
            if (this.y < o.y) {
                return -1;
            } else if (this.y > o.y) {
                return 1;
            } else {
                if (this.type < o.type) {
                    return -1;
                } else if (this.type > o.type) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}

class Solution {
    private boolean check(List<Frame> frames) {
        for (int i = 0; i < frames.size(); i++) {
            int type = frames.get(i).getType();//기둥 or 보
            int x = frames.get(i).getX();
            int y = frames.get(i).getY();
            //기둥인 경우
            if (type == 0) {
                boolean check = false;
                //바닥에 설치된 경우
                if (y == 0) {
                    check = true;
                }
                for(int j = 0; j < frames.size(); j++) {
                    //기둥의 위쪽에 설치된 경우
                    if(x == frames.get(j).getX() && y - 1 == frames.get(j).getY() && 0 == frames.get(j).getType()) {
                        check = true;
                    }
                    //보의 왼쪽 쪽 끝부분 위에 있는 경우
                    if(x == frames.get(j).getX() && y == frames.get(j).getY() && 1 == frames.get(j).getType()){
                        check = true;
                    }
                    //보의 오른쪽 끝 부분 위에 있는 경우
                    if(x - 1 == frames.get(j).getX() && y == frames.get(j).getY() && 1 == frames.get(j).getType()){
                        check = true;
                    }
                }
                if(!check) return false;
            }
            //보인 경우
            else {
                boolean check = false;
                boolean left = false;
                boolean right = false;
                for(int j = 0; j < frames.size(); j++) {
                    //자신의 왼쪽을 기둥이 받치고 있는 경우
                    if(x == frames.get(j).getX() && y - 1 == frames.get(j).getY() && 0 == frames.get(j).getType()) {
                        check = true;
                    }
                    //자신의 오른쪽을 기둥이 받치고 있는 경우
                    if(x + 1 == frames.get(j).getX() && y - 1 == frames.get(j).getY() && 0 == frames.get(j).getType()){
                        check = true;
                    }
                    //보의 좌우가 보로 이어지는 경우
                    if(x - 1 == frames.get(j).getX() && y == frames.get(j).getY() && 1 == frames.get(j).getType()){
                        left = true;
                    }
                    if(x + 1 == frames.get(j).getX() && y == frames.get(j).getY() && 1 == frames.get(j).getType()){
                        right = true;
                    }
                }
                if(left && right) check = true;
                if(!check) return false;
            }
        }
        return true;
    }

    public int[][] solution(int n, int[][] build_frame) {

        List<Frame> frames = new ArrayList<>();

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int type = build_frame[i][2];
            int operation = build_frame[i][3];

            //설치
            if (operation == 1) {
                frames.add(new Frame(x, y, type));
                //조건에 맞지 않는 경우 삭제
                if (!check(frames)) frames.remove(frames.size() - 1);
            }
            //삭제
            else {
                Frame removed = null;
                for (int j = 0; j < frames.size(); j++) {
                    if (frames.get(j).getX() == x && frames.get(j).getY() == y && frames.get(j).getType() == type) {
                        removed = frames.remove(j);
                        break;
                    }
                }
                //조건에 맞지 않으면 다시 추가
                if (!check(frames)) frames.add(removed);
            }
        }
        Collections.sort(frames);
        int[][] answer = new int[frames.size()][3];
        for (int i = 0; i < frames.size(); i++) {
            answer[i][0] = frames.get(i).getX();
            answer[i][1] = frames.get(i).getY();
            answer[i][2] = frames.get(i).getType();
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] key = new int[3][3];
        int[][] lock = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                key[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                lock[i][j] = sc.nextInt();
            }
        }
        Solution solution = new Solution();
//        solution.solution(key, lock);
    }
}
