package algorithm.백트래킹.validsudoku;

import java.util.Arrays;

/*
 * 출처: leetcode
 * 문제 이름: Valid Sudoku
 * */
public class Solution {
//    public boolean isValidSudoku(char[][] board) {
//        //행 검사
//        for (int i = 0; i < 9; i++) {
//            //행과 열의 중복 숫자를 체크하기 위한 해쉬맵
//            HashMap<Integer, Integer> rowMap = new HashMap<>();
//            HashMap<Integer, Integer> columnMap = new HashMap<>();
//            for (int j = 0; j < 9; j++) {
//                if(Character.isDigit(board[i][j])) rowMap.put(board[i][j] - '0', rowMap.getOrDefault(board[i][j] - '0', 0) + 1);
//                if(Character.isDigit(board[j][i])) columnMap.put(board[j][i] - '0', columnMap.getOrDefault(board[j][i] - '0', 0) + 1);
//                //sub box 체크
//                if(i % 3 == 0 && j % 3 == 0) {
//                    HashMap<Integer, Integer> subBoxMap = new HashMap<>();
//                    for (int p = i; p < i + 3; p++) {
//                        for (int q = j; q < j + 3; q++) {
//                            if(Character.isDigit(board[p][q])) subBoxMap.put(board[p][q] - '0', subBoxMap.getOrDefault(board[p][q] - '0', 0) + 1);
//                        }
//                    }
//                    //sub box의 중복 체크
//                    for (int key : subBoxMap.keySet()) {
//                        if (subBoxMap.get(key) > 1) {
//                            return false;
//                        }
//                    }
//                }
//            }
//            //행의 중복 체크
//            for (int key : rowMap.keySet()) {
//                if (rowMap.get(key) > 1) {
//                    return false;
//                }
//            }
//            //열의 중복 체크
//            for (int key : columnMap.keySet()) {
//                if (columnMap.get(key) > 1) {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }


    public boolean isValidSudoku(char[][] board) {
        //각 규칙에 대한 검증 과정에서 등장한 숫자에 대해서 true 처리
        boolean[] b = new boolean[10];
        //각 규칙
        for (int rule = 0; rule < 2; rule++) {
            for (int i = 0; i < 9; i++) {
                Arrays.fill(b, false);
                for (int j = 0; j < 9; j++) {
                    char c = '.';
                    if (rule == 0) {//가로
                        c = board[i][j];
                    } else if (rule == 1) {//세로
                        c = board[j][i];
                    } else {//sub box
                        c = board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3];
                    }
                    if(c == '.') continue;
                    int value = c - '0';
                    if (b[value]) return false;//이미 등장한 숫자인 경우 false return
                    b[value] = true;//처음 등장한 숫자에 대해서 true 처리
                }
            }
        }
        return true;
    }
}
