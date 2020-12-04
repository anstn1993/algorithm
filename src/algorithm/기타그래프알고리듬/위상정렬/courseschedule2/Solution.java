package algorithm.기타그래프알고리듬.위상정렬.courseschedule2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 출처: leetcode
 * 문제 이름: Course Schedule 2
 * */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) return new int[]{0};//과목이 하나인 경우 바로 return
        int[] indegree = new int[numCourses];//각 노드의 진입차수를 저장하기 위한 배열
        List<List<Integer>> graph = new ArrayList<>();//인접 리스트 그래프
        int[] result = new int[numCourses];//결과 배열
        int index = 0;
        //그래프 초기화
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        //그래프 값 채우기
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]] += 1;//진입차수 추가
        }
        //큐에 진입차수가 0인 수업들만 넣어준다.
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int current = q.poll();
            result[index++] = current;//결과 배열에 과목 추가
            for (int i = 0; i < graph.get(current).size(); i++) {
                //진입 차수를 1씩 줄여준다.
                indegree[graph.get(current).get(i)] -= 1;
                //진입차수가 0이 된 과목이 있으면 큐에 삽입
                if (indegree[graph.get(current).get(i)] == 0) {
                    q.offer(graph.get(current).get(i));
                }
            }
        }
        if(index == numCourses) return result;
        return new int[]{};
    }
}
