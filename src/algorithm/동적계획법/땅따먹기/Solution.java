package algorithm.동적계획법.땅따먹기;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 0) land[i][j] = land[i][j] + Math.max(land[i - 1][j + 1], Math.max(land[i - 1][j + 2], land[i - 1][j + 3]));
                else if (j == 1) land[i][j] = land[i][j] + Math.max(land[i - 1][j - 1], Math.max(land[i - 1][j + 1], land[i - 1][j + 2]));
                else if (j == 2) land[i][j] = land[i][j] + Math.max(land[i - 1][j - 2], Math.max(land[i - 1][j - 1], land[i - 1][j + 1]));
                else land[i][j] = land[i][j] + Math.max(land[i - 1][j -3], Math.max(land[i - 1][j - 2], land[i - 1][j - 1]));

                if(i == land.length - 1) {
                    answer = Math.max(answer, land[i][j]);
                }
            }
        }
        return answer;
    }
}