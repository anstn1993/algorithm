package algorithm.그리디.무지의먹방라이브;

import java.util.*;
/*
* 이 문제는 먹는 데 시간이 적게 드는 음식부터 오름차순으로 정렬한 후 음식을 하나씩 꺼내서 남은 k초 이내에 그 음식을 다 먹을 수 있는지 비교한 후
* 다 먹을 수 있으면 그 음식을 큐에서 꺼내서 없애주고 k초에서 그 음식을 다 먹는 데 드는 시간만큼 빼주는 것이다.
* 이 과정을 음식을 다 먹는 데 걸리는 시간보다 k가 적게 남기 전까지 반복해주면 된다.
* */
class Food implements Comparable<Food> {

    private int time;
    private int index;

    public Food(int time, int index) {
        this.time = time;
        this.index = index;
    }

    public int getTime() {
        return this.time;
    }

    public int getIndex() {
        return this.index;
    }

    // 시간이 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Food other) {
        return Integer.compare(this.time, other.time);
    }
}

class Solution {
    public int solution(int[] food_times, long k) {
        int answer = 0;
        long sum = 0;//음식을 모두 먹는 데 걸리는 시간
        for (int i = 0; i < food_times.length; i++) {
            sum += food_times[i];
        }
        //만약 k보다 전체 음식을 먹는 시간이 적거나 같게 걸린다면 모든 음식을 k초 안에 다 먹는 것이기 때문에 -1을 return
        if(sum <= k) {
            return -1;
        }
        PriorityQueue<Food> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < food_times.length; i ++) {
            priorityQueue.offer(new Food(food_times[i], i + 1));//우선순위 큐에 각 food 객체를 넣어준다.
        }
        long remainFoodCount = food_times.length;//남은 음식 수
        while(priorityQueue.peek().getTime() * remainFoodCount <= k) {//큐에서 나온 음식을 다 먹는 데 걸리는 시간이 k보다 작거나 같으면
            k -= priorityQueue.poll().getTime();//큐에서 그 음식을 꺼내고 k에서 그 시간만큼 빼준다.
            remainFoodCount --;//남은 음식 수를 하나 줄인다.
        }
        ArrayList<Food> remainFoods = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            remainFoods.add(priorityQueue.poll());
        }

        Collections.sort(remainFoods, (o1, o2) -> Integer.compare(o1.getIndex(), o2.getIndex()));

        answer = remainFoods.get((int) (k % remainFoodCount)).getIndex();

        return answer;
    }
}
