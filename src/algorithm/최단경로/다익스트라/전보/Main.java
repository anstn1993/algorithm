package algorithm.최단경로.다익스트라.전보;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.distance, other.distance);
    }
}

public class Main {
    public static final int INF = (int) 1e9;
    //순서대로 노드의 수, 간선의 수, 도시 c의 번호
    public static int n, m, c;
    //각 노드별로 c로부터 최단 거리를 저장할 테이블
    public static int[] d = new int[30001];
    //각 노드와 연결된 노드와 거리 정보를 저장할 리스트
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();


    private static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();//우선순위 큐
        q.offer(new Node(start, 0));
        d[start] = 0;
        while (!q.isEmpty()) {
            Node currentNode = q.poll();//현재 노드
            int now = currentNode.getIndex();//현재 노드 번호
            //이미 방문한 노드인 경우 넘어간다.
            if (d[now] < currentNode.getDistance()) continue;
            for (int i = 0; i < graph.get(now).size(); i++) {
                int distance = d[now] + graph.get(now).get(i).getDistance();
                if(distance < d[graph.get(now).get(i).getDistance()]) {
                    d[graph.get(now).get(i).getIndex()] = distance;
                    q.offer(new Node(graph.get(now).get(i).getIndex(), distance));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();


        //그래프 초기화
        for(int i = 0; i <= n; i ++) {
            graph.add(new ArrayList<>());
        }
        //그래프 정보 입력
        for (int i = 0; i < m; i++) {
            //a노드에서 b노드까지 d만큼의 시간이 걸린다는 의미
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();
            graph.get(a).add(new Node(b, d));
        }
        //최단 거리 테이블 값 무한으로 초기화
        Arrays.fill(d, INF);

        //다익스트라 알고리즘 수행
        dijkstra(c);

        //메세지가 도착할 수 있는 도시의 수
        int count = 0;
        //메세지가 도착할 수 있는 도시 중 c로부터 가장 먼 도시와의 거리
        int maxDistance = 0;
        for(int i = 1; i <= n; i ++) {
            if(d[i] != 0 && d[i] != INF) {
                count ++;
                maxDistance = Math.max(maxDistance, d[i]);
            }
        }

        System.out.println(count + " " + maxDistance);

    }
}
