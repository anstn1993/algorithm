package algorithm.구현.게임개발;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //입력값 받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int row = sc.nextInt();
        int column = sc.nextInt();
        int d = sc.nextInt();

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        //입력값 받기 끝

        //방향에 따른 행, 열의 좌표 증감 배열을 map에 저장
        HashMap<Integer, int[]> dTypes = new HashMap<>();
        dTypes.put(0, new int[]{-1, 0});//북
        dTypes.put(3, new int[]{0, -1});//서
        dTypes.put(2, new int[]{1, 0});//남
        dTypes.put(1, new int[]{0, 1});//동
        int answer = 1;//캐릭터의 칸 방문 횟수
        map[row][column] = -1;//최초로 주어지는 케릭터의 위치를 방문 처리
        int rotateCount = 0;//캐릭터의 회전 횟수
        while (true) {
            d = (d - 1 < 0) ? 3 : (d - 1);//캐릭터 방향 회전
            int[] dRowColumn = dTypes.get(d);//캐릭터가 이동해야 할 행, 열의 칸 수
            int targetRow = row + dRowColumn[0];//이동 후 행
            int targetColumn = column + dRowColumn[1];//이동 후 열
            //캐릭터가 이동하는 자리가 바다가 아니고 이미 방문한 자리도 아닌 경우
            if(map[targetRow][targetColumn] != 1 && map[targetRow][targetColumn] != -1) {
                answer += 1;//이동 횟수 추가
                //캐릭터 이동
                row = targetRow;
                column = targetColumn;
                map[row][column] = -1;//해당 위치 방문 처리
                rotateCount = 0;//회전 횟수 0으로 초기화
                continue;
            }
            //이동하는 자리가 바다이거나 이미 방문한 자리인 경우
            else {
                rotateCount ++;//회전 횟수 추가
            }
            //4번을 회전했다는 건 캐릭터가 이동하지 못 했음을 의미하기 때문에 캐릭터가 바라보는 방향의 뒤로 이동
            if(rotateCount == 4) {
                //이동해야 할 칸만큼 빼주면 앞으로 가지 않고 뒤로 가진다.
                targetRow = row - dRowColumn[0];
                targetColumn = column - dRowColumn[1];
                if(map[targetRow][targetColumn] == 1) {//만약 이동해야 하는 자리가 바다인 경우 연산 종료
                    break;
                }
                //캐릭터 이동 처리
                row = targetRow;
                column = targetColumn;
                rotateCount = 0;//회전 횟수 0으로 초기화
            }
        }
        System.out.print(answer);
    }

}
