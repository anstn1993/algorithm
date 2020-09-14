package algorithm.기타그래프알고리듬.서로소집합.여행계획;

import java.util.Scanner;

public class Main {
    public static int n, m;//각각 노드 수, 방문할 노드 수
    public static int[] parents = new int[501];//각 노드의 부모 노드 테이블
    public static int[][] graph = new int[501][501];//노드 그래프
    public static int[] plan = new int[501];//방문할 노드를 담을 리스트
    //자신이 속한 집합 찾기
    public static int findParent(int x) {
        if (parents[x] != x) {
            parents[x] = findParent(parents[x]);
        }
        return parents[x];
    }

    //두 노드를 한 집합으로 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parents[b] = a;
        else parents[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        //그래프 값 설정
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        //방문할 노드 받기
        for (int i = 0; i < m; i++) {
            plan[i] = sc.nextInt();
        }

        //parents테이블의 초기 값을 각 노드 자신으로 설정
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        //합치기 연산 수행
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                //두 노드가 연결된 경우
                if (graph[i][j] == 1) {
                    unionParent(i, j);
                }
            }
        }

        boolean isPossible = true;
        //여행지 노드의 부모가 모두 같으면 방문이 가능하다.
        for (int i = 0; i < m - 1; i++) {
            if(findParent(plan[i]) != findParent(plan[i + 1])) {
                isPossible = false;
                break;
            }
        }
        //결과 출력
        if(isPossible) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
