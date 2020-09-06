package algorithm.기타그래프알고리듬.서로소집합.팀결성;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //부모 노드 찾기
    public static int findParent(int[] parents, int x) {
        if (parents[x] != x) {
            parents[x] = findParent(parents, parents[x]);
        }
        return parents[x];
    }

    //팀 합치기
    public static void unionParent(int[] parents, int a, int b) {
        a = parents[a];
        b = parents[b];
        if (a < b) parents[b] = a;
        else parents[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//노드의 수
        int m = sc.nextInt();//연산 횟수(같은 팀 여부 or 팀 합치기)
        List<String> result = new ArrayList<>();
        int[] parents = new int[n + 1];//부모 노드 테이블
        //부모 노드 테이블의 초기 값 초기화
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        //연산 작업
        for (int i = 0; i < m; i++) {
            int operation = sc.nextInt();//연산의 종류
            //팀 a, b
            int a = sc.nextInt();
            int b = sc.nextInt();

            //팀 합치기 연산
            if (operation == 0) {
                unionParent(parents, a, b);
            }
            //같은 팀 여부 확인 연산
            else {
                //같은 팀인 경우
                if (findParent(parents, a) == findParent(parents, b)) {
                    result.add("YES");
                }
                //같은 팀이 아닌 경우
                else {
                    result.add("NO");
                }
            }
        }

        //결과 출력
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}
