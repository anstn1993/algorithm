package algorithm.구현.자물쇠와열쇠;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] key = new int[3][3];
        key[0][0] = 0;
        key[0][1] = 0;
        key[0][2] = 0;
        key[1][0] = 1;
        key[1][1] = 0;
        key[1][2] = 0;
        key[2][0] = 0;
        key[2][1] = 1;
        key[2][2] = 1;
        int[][] lock = new int[3][3];
        lock[0][0] = 1;
        lock[0][1] = 1;
        lock[0][2] = 1;
        lock[1][0] = 1;
        lock[1][1] = 1;
        lock[1][2] = 0;
        lock[2][0] = 1;
        lock[2][1] = 0;
        lock[2][2] = 1;

        ArrayList<int[]> holePosition = new ArrayList<>();
        for(int i = 0; i < lock.length; i ++) {
            for(int j = 0; j < lock.length; j ++) {
                if(lock[i][j] == 0) {
                    holePosition.add(new int[]{i, j});
                }
            }
        }

        int firstRow = 0;
        int lastRow = 0;
        int firstColumn = 0;
        int lastColumn = 0;
//        for(int i = 0; i < holePosition.size(); i ++) {
//            if(firstRow > holePosition.get(i)[0]) {
//                fir
//            }
//        }

    }
}
