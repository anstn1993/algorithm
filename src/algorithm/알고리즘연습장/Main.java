package algorithm.알고리즘연습장;

import java.util.Scanner;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        String[] cache = new String[cacheSize];
        //초기 데이터 캐시에 넣어주기
        for (int i = 0; i < cacheSize; i++) {
            cache[i] = cities[i].toLowerCase();
            answer += 5;//캐시 미스
        }
        int cacheIndex = 0;//캐시 테이블 상에서 교체 대상 데이터의 index
        for (int i = cacheSize; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            boolean cacheHit = false;
            for (int j = 0; j < cacheSize; j++) {
                if (cache[j].equals(city)) {
                    cacheHit = true;//캐시 히드
                    break;
                }
            }
            if (cacheHit) answer++;//캐시 히트인 경우 실행 시간 +1
            else {//캐시 미스인 경우
                answer += 5;//실행 시간 +5
                if (cacheSize != 0) {//캐시 크기가 0이 아닌 경우에 한해서
                    cache[cacheIndex] = city;//캐시에 데이터 교체
                    cacheIndex = (cacheIndex == cacheSize - 1) ? 0 : cacheIndex + 1;//교체 대상 인덱스 +1
                }
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        int n = 10;
        String[] cities = new String[n];
        for (int i = 0; i < n; i++) {
            cities[i] = sc.nextLine();
        }
        solution.solution(3, cities);
    }
}
