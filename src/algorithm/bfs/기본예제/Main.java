package algorithm.bfs.기본예제;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();


    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);//큐에 시작 노드 삽입
        while(!queue.isEmpty()) {//큐에 노드가 존재하는 경우
            int x = queue.poll();//값 꺼내기
            System.out.print(x + " ");
            visited[x] = true;
            for(int i = 0; i < graph.get(x).size(); i ++) {
                int y = graph.get(x).get(i);//x와 인접한 노드
                if(visited[y] == false) {//인접 노드가 아직 방문하지 않은 노드인 경우
                    visited[y] = true;
                    queue.offer(y);
                }
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

        bfs(1);
    }
}
