package algorithm.최단경로.플로이드워셜.정확한순위;

import java.util.*;

class Solution {
    private final int INF = (int) 1e9;
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] d = new int[n + 1][n + 1];


        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) d[i][j] = 0;
                else d[i][j] = INF;
            }
        }

        for(int i = 0; i < n; i++) {
            int a = results[i][0];
            int b = results[i][1];
            d[b][a] = 1;
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            int count = 0;
            for(int j = 1; j <= n; j++) {
                if(d[i][j] != INF || d[j][i] != INF) {
                    count ++;
                }
            }
            if(count == n) {
                answer ++;
            }
        }
        return answer;
    }
}

public class Main {

}
