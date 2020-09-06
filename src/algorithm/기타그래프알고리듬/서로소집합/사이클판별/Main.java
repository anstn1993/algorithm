package algorithm.기타그래프알고리듬.서로소집합.사이클판별;

import java.util.Scanner;

public class Main {
    //앞에서부터 노드의 수, 간선의 수
    //노드의 개수는 최대 100000개라고 가정
    public static int v, e;
    public static int[] parents = new int[100001];//부모 노드 테이블

    //특정 원소가 속한 집합 찾기(경로 압축)
    public static int findParent(int x) {
        //현재 노드와 부모 노드가 다른 경우
        if(x != parents[x]) {
            parents[x] = findParent(parents[x]);//부모 노드의 부모 노드
        }
        return parents[x];
    }

    //두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a < b) parents[b] = a;
        else parents[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        //부모 테이블에서 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parents[i] = i;
        }

        boolean cycle = false;//사이클 발생 여부

        //Union 연산을 각각 수행
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            //사이클이 발생한 경우 종료
            if(findParent(a) == findParent(b)) {
                cycle = true;
                break;
            }
            //사이클이 발생하지 않았다면 합집합 연산 수행
            else {
                unionParent(a, b);
            }
        }

        if(cycle) System.out.println("사이클이 발생했습니다.");
        else System.out.println("사이클이 발생하지 않았습니다.");

    }
}
