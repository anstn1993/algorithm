package algorithm.기타그래프알고리듬.위상정렬.courseschedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 * 출처: leetcode
 * 문제 이름: Course Schedule
 * */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //과목이 하나인 경우에는 그냥 true
        if(numCourses == 1) return true;

        int[] indegree = new int[numCourses];//각 과목의 진입차수를 저장할 배열
        List<List<Integer>> graph = new ArrayList<>();//인접 리스트 그래프
        //그래프 초기화
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        //그래프 완성
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            //진입차수 설정
            indegree[prerequisites[i][0]] += 1;
        }

        //bfs로 처리
        Queue<Integer> q = new LinkedList<>();
        //진입차수가 0인 과목부터 큐에 삽입 후 시작
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int current = q.poll();//현재 과목
            //현재 과목에 할당된 진입 차수를 제거한다.
            for (int i = 0; i < graph.get(current).size(); i++) {
                indegree[graph.get(current).get(i)] -= 1;
                if(indegree[graph.get(current).get(i)] == 0) q.offer(graph.get(current).get(i));
            }
        }

        //진입 차수가 하나라도 0이 아니라면 완료 불가능
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
