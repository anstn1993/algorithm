package algorithm.구현.치킨배달;

import java.util.ArrayList;
import java.util.Scanner;

class Combination {
    private int n;//전체 원소 개수
    private int r;//조합할 원소 개수
    private int[] now; //현재 조합된 원소를 담을 배열
    private ArrayList<ArrayList<Position>> result; // 모든 조합 결과를 담을 리스트

    public ArrayList<ArrayList<Position>> getResult() {
        return result;
    }

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Position>>();
    }

    public void combination(ArrayList<Position> arr, int depth, int index, int target) {
        if (depth == r) {
            ArrayList<Position> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(arr.get(now[i]));
            }
            result.add(temp);
            return;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    //순서대로 맵의 크기, 남길 치킨 집 수
    public static int n, m;
    public static ArrayList<Position> chicken = new ArrayList<>();//치킨집의 위치를 담을 리스트
    public static ArrayList<Position> home = new ArrayList<>();//집의 위치를 담을 리스트

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                int value = sc.nextInt();
                if (value == 1) {//집인 경우
                    home.add(new Position(i, j));
                }
                if (value == 2) {//치킨집인 경우
                    chicken.add(new Position(i, j));
                }
            }
        }

        int result = 9999;//도시의 치킨 거리 최소값
        //m개의 치킨집을 만들 수 있는 모든 조합을 만든다.
        Combination combination = new Combination(chicken.size(), m);
        combination.combination(chicken, 0, 0, 0);
        //m개의 조합으로 이루어진 치킨집 좌표를 모두 담은 리스트
        ArrayList<ArrayList<Position>> remainChicken = combination.getResult();

        for (int i = 0; i < remainChicken.size(); i++) {
            int tempResult = 0;//현재 조합에서의 도시의 치킨 거리
            for(int k = 0; k < home.size(); k ++) {
                Position current = home.get(k);//현재 집
                int min = 9999;
                //현재 집과 모든 치킨 집과의 거리 중 최소 거리를 찾는다.
                for (int j = 0; j < remainChicken.get(i).size(); j++) {
                    Position chicken = remainChicken.get(i).get(j);
                    int distance = Math.abs(current.getX() - chicken.getX()) + Math.abs(current.getY() - chicken.getY());
                    min = Math.min(distance, min);
                }
                tempResult += min;//치킨 거리 중 가장 작은 값을 더해준다.
            }
            result = Math.min(tempResult, result);
        }
        //결과 출력
        System.out.println(result);
    }
}
