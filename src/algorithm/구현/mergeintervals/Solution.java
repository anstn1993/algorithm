package algorithm.구현.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        //interval 배열을 오름차순으로 정렬
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] < b[0]) return -1;
            else if(a[0] == b[0]) {
                if(a[1] < b[1]) return -1;
                else if(a[1] == b[1]) return 0;
                else return 1;
            }
            else return 1;
        });
        //첫 번째 interval은 list에 추가하고 시작
        list.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            int[] target = list.get(list.size() - 1);
            //두 interval이 겹치지 않는 경우
            if(target[1] < intervals[i][0]) {
                list.add(intervals[i]);//현재 interval을 리스트에 추가
            }
            else {
                //리스트에 있던 interval과 현재 interval을 합친다.
                target[1] = target[1] >= intervals[i][1]? target[1] : intervals[i][1];
            }
        }
        int[][] result = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
    }
}
