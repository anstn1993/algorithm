package algorithm.정렬.실패율;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Stage implements Comparable<Stage> {
    int index;
    double failureRate;//실패율

    public Stage(int index, double failureRate) {
        this.index = index;
        this.failureRate = failureRate;
    }

    public int getIndex() {
        return index;
    }

    public double getFailureRate() {
        return failureRate;
    }

    //실패율을 기준으로 내림차순 정렬
    @Override
    public int compareTo(Stage other) {
        if (this.failureRate < other.failureRate) {
            return 1;
        } else if (this.failureRate > other.failureRate) {
            return -1;
        } else {
            return Integer.compare(this.index, other.index);
        }

    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        //계수 정렬을 위한 리스트
        double[] count = new double[N + 2];
        //각 스테이지의 실패율을 담을 리스트
        List<Stage> failureRateList = new ArrayList<>();
        for (int i = 0; i < stages.length; i++) {
            count[stages[i]] += 1;
        }

        double remain = stages.length;//타겟 스테이지를 방문한 적이 있는 사용자 수
        //계수 정렬 리스트에 각 스테이지별로 머무르고 있는 사람의 수가 들어가기 때문에
        //각 요소를 remain으로 나누어주면 실패율이 나온다. 실패율 계산 후에는 remain을 갱신해준다.
        for (int i = 1; i <= N; i++) {
            failureRateList.add(new Stage(i, count[i] / remain));
            remain -= count[i];
        }

        //실패율 리스트를 오름차순으로 정렬
        Collections.sort(failureRateList);
        //스테이지만 배열에 옮겨준다.
        int[] answer = new int[failureRateList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = failureRateList.get(i).getIndex();
        }
        return answer;
    }
}


