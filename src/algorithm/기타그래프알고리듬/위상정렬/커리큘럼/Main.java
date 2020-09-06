package algorithm.기타그래프알고리듬.위상정렬.커리큘럼;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    private int number;//노드 번호
    private int time;//강의 시간
}

public class Main {

    public static int n;//과목 수
    public static int[] indegree = new int[501];//과목들의 진입차수 테이블
    public static int[] timeTable = new int[501];//과목별 강의 시간 테이블
    //과목들 간의 그래프 정보를 담는 인접 리스트
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        //그래프, 선수과목 리스트 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        //그래프에 노드 정보 초기화
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            timeTable[i] = x;
            while (true) {
                x = sc.nextInt();//선수 과목 번호
                if (x == -1) break;
                graph.get(x).add(i);
                indegree[i] += 1;//진입차수 1 증가
            }
        }
        //과목 이수에 걸리는 최소 시간을 저장할 배열
        int[] result = new int[501];
        for (int i = 1; i <= n; i++) {
            result[i] = timeTable[i];
        }

        Queue<Integer> q = new LinkedList<>();
        //진입차수가 0인 과목들을 큐에 삽입
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int now = q.poll();//현재 과목 번호
            //선행과목이 now인 과목들의 진입차수 값을 -1
            for (int i = 0; i < graph.get(now).size(); i++) {
                result[graph.get(now).get(i)] = Math.max(result[graph.get(now).get(i)], result[now] + timeTable[graph.get(now).get(i)]);
                indegree[graph.get(now).get(i)] -= 1;
                //진입차수가 0인 과목을 큐에 삽입
                if (indegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }

        //결과 출력
        for (int i = 1; i <= n; i++) {
            System.out.println(result[i]);
        }
    }
}
