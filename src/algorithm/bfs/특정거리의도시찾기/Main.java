package algorithm.bfs.특정거리의도시찾기;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//도시의 개수
        int m = sc.nextInt();//도로의 개수
        int k = sc.nextInt();//만족해야 할 최단 거리
        int x = sc.nextInt();//출발 도시 번호
        List<List<Integer>> roadInfos = new ArrayList<>();//도시 간의 관계를 나타내는 그래프
        boolean[] visited = new boolean[n];//도시 방문 여부
        for(int i = 0; i < n; i ++) {
            roadInfos.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i ++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            roadInfos.get(start - 1).add(end - 1);
        }

        List<Integer> result = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x - 1, 0});//시작 도시부터 bsf탐색
        while(!q.isEmpty()) {
            int[] currentCity = q.poll();
            if(currentCity[1] == k) {
                result.add(currentCity[0]);
            }
            List<Integer> adjacentCities = roadInfos.get(currentCity[0]);//인접 도시 번호 리스트
            for(int i = 0; i < adjacentCities.size(); i ++) {
                Integer cityNum = adjacentCities.get(i);
                if(visited[cityNum] == false) {
                    visited[cityNum] = true;
                    q.offer(new int[]{cityNum, currentCity[1] + 1});
                }
            }
        }
        Collections.sort(result);
        if(result.size() == 0) {
            System.out.println(-1);
            return;
        }
        for(int i = 0; i < result.size(); i ++) {
            System.out.println(result.get(i) + 1);
        }
    }
}
