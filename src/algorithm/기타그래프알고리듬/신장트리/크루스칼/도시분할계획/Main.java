package algorithm.기타그래프알고리듬.신장트리.크루스칼.도시분할계획;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge implements Comparable<Edge> {

    private int distance;
    private int nodeA;
    private int nodeB;

    public Edge(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance() {
        return distance;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.distance, other.distance);
    }
}

public class Main {
    //각각 노드의 수와 간선의 수
    public static int n, m;
    //부모 노드 테이블
    public static int[] parents = new int[100001];
    //간선 정보를 담은 리스트
    public static ArrayList<Edge> edges = new ArrayList<>();

    public static int findParent(int x) {
        if (parents[x] != x) {
            parents[x] = findParent(parents[x]);
        }
        return parents[x];
    }

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
        int result = 0;
        int maxCost = 0;
        //간선 정보 초기화
        for (int i = 0; i < m; i++) {
            //a, b노드 사이의 이동 비용이 c라는 의미다.
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges.add(new Edge(c, a, b));
        }

        //부모 노드 테이블 값 설정
        for(int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        //거리를 기준으로 오름차순 정렬
        Collections.sort(edges);

        for (int i = 0; i < m; i++) {
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();
            //두 노드 사이의 간선이 사이클을 만들지 않는 경우에
            if (findParent(a) != findParent(b)) {
                unionParent(a, b);//두 집합을 합친다.
                result += cost;
                maxCost = cost;
            }
        }

        //최소 비용으로 마을 두 개를 분리하기 위해서 신장 트리 노드 중 가장 큰 값을 빼준다.
        result -= maxCost;
        System.out.println(result);
    }
}
