package algorithm.dfs.기본예제;

import java.util.ArrayList;

public class Main {

    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void dfs(int v) {
        visited[v] = true;//해당 노드 방문 처리
        System.out.print(v + " ");
        for(int i = 0; i < graph.get(v).size(); i ++) {
            if(visited[graph.get(v).get(i)] == false) {//아직 방문하지 않은 노드인 경우
                dfs(graph.get(v).get(i));
            }
        }
    }

    public static void main(String[] args) {
        //그래프 초기화
        for(int i = 0; i < 9; i ++) {
            graph.add(new ArrayList<>());
        }

        //노드 1과 연결된 노드들을 추가
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        //노드 2와 연결된 노드들 추가
        graph.get(2).add(1);
        graph.get(2).add(7);

        //노드 3과 연결된 노드들 추가
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        //노드 4와 연결된 노드들 추가
        graph.get(4).add(3);
        graph.get(4).add(5);

        //노드 5와 연결된 노드들 추가
        graph.get(5).add(3);
        graph.get(5).add(4);

        //노드 6괴 연결된 노드들 추가
        graph.get(6).add(7);

        //노드 7괴 연결된 노드들 추가
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        //노드 8괴 연결된 노드들 추가
        graph.get(8).add(1);
        graph.get(8).add(7);

        dfs(1);
    }
}
