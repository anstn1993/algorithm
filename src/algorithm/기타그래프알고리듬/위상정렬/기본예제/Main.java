package algorithm.기타그래프알고리듬.위상정렬.기본예제;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    //시작부터 노드의 개수(최대 100000)와 간선의 개수
    public static int v, e;
    //모든 노드에 대한 진입차수를 0으로 초기화
    public static int[] indegree = new int[100001];
    //각 노드에 연결된 간선 정보를 담기 위한 인접 리스트 초기화
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    //위상 정렬 함수
    public static void topologySort() {
        //알고리즘 수행 결과를 담을 리스트
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        //처음 시작시에는 진입 차수가 0인 노드를 큐에 삽입한다.
        for (int i = 1; i <= v; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        //큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            int now = q.poll();//큐에서 원소를 꺼낸다.
            result.add(now);//결과 리스트에 추가
            //해당 원소와 연결된 노드들의 진입차수에서 1을 뺀다.
            for (int i = 0; i < graph.get(now).size(); i++) {
                indegree[graph.get(now).get(i)] -= 1;
                //새롭게 진입차수가 0이 되는 노드를 큐에 넣어준다.
                if(indegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }

        //결과 출력
        for(int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        //그래프 초기화
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        //방향 그래프의 모든 간선 정보를 입력 받기
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);//a노드에서 b노드로 이동 가능
            //진입차수 1 증가
            indegree[b] += 1;
        }
        //위상정렬 수행
        topologySort();
    }
}
