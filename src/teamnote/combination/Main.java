package teamnote.combination;

import java.util.ArrayList;
import java.util.List;

class Combination {
    private int n;//전체 원소 개수
    private int r;//조합할 원소 개수
    private int[] now; //현재 조합의 인덱스를 담는 배열
    private ArrayList<ArrayList<Integer>> result; // 모든 조합 결과를 담을 리스트

    public ArrayList<ArrayList<Integer>> getResult() {
        return result;
    }

    public Combination(int n, int r) {
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Integer>>();
    }

    /*
    * param 0: 전체 원소
    * param 1: 선택된 수가 r개인지 체크하는 변수
    * parma 2: 선택된 수의 인덱스를 저장하는 now배열의 인덱스(r이 2라면 0, 1이 index값으로 반복되고 저 인덱스에 target값을 계속 저장)
    * param 3: 전체 원소 중에서 현재 조합에 포함해야 하는 원소의 인덱스(now 배열에 저장되는 수)
    * */
    public void combination(ArrayList<Integer> arr, int depth, int index, int target) {
        if (depth == r) {
            ArrayList<Integer> temp = new ArrayList<>();
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

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Combination combination = new Combination(4, 2);
        combination.combination(list, 0, 0, 0);
        ArrayList<ArrayList<Integer>> result = combination.getResult();
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
