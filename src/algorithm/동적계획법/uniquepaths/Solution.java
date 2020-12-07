package algorithm.동적계획법.uniquepaths;
/*
 * 출처: leetcode
 * 문제 이름: Unique Paths
 * */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] d = new int[m + 1][n + 1];
        d[1][1] = 1;
        //m, n중 하나가 1인 경우에는 경우의 수가 1이다.
        for(int i = 2; i <= m; i++) {
            d[i][1] = 1;
        }
        for(int i = 2; i <= n; i++) {
            d[1][i] = 1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                d[i][j] = d[i - 1][j] + d[i][j - 1];
            }
        }
        return d[m][n];
    }
}
