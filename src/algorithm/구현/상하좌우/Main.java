package algorithm.구현.상하좌우;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// 1 <= n <= 100
        sc.nextLine();//버퍼 비우기
        String[] plans = sc.nextLine().split(" ");


        int[] dx = {0, 0, -1, 1};//plan에 따른 x축 이동값
        int[] dy = {-1, 1, 0, 0};//plan에 따른 y축 이동값

        char[] playTypes = {'L', 'R', 'U', 'D'};

        //여행자의 위치 좌표
        int x = 1;
        int y = 1;

        for(int i = 0; i < plans.length; i ++) {
            char plan = plans[i].charAt(0);//계획서에 적힌 이동 방향
            for(int j = 0; j < playTypes.length; j ++) {
                int nx = 0, ny = 0;
                if(plan == playTypes[j]) {//계획서에 적힌 이동 방향에 해당할 때
                    //이동한 결과를 임시 변수에 저장
                    nx = x + dx[j];
                    ny = y + dy[j];
                }

                //임시 결과 좌표가 좌표 공간 바깥으로 벗어나는 경우 연산 결과 무시
                if(nx < 1 || ny < 1 || nx > n || ny > n) {
                    continue;
                }
                //실제 좌표 값에 연산 결과 값 대입
                x = nx;
                y = ny;
            }
        }
        System.out.println(x + " " + y);

        /*
        * 아래 코드는 위의 정답 코드 외에 내가 생각해본 다른 풀이법이다.
        * n x n크기의 정사각형을 일자로 쭉 나열한 형태로 표현해서 L, R, U, D을 좌우로만 이동시키는 것이다.
        * 가령 5 x 5 정사각형을 일자로 나열하면 총 25칸이 생긴다. 이 형태에서 L, R는 좌로 1칸, 우로 1칸이고 U은 좌로 5칸, D은 우로 5칸이다. 그리고 위치가 1보다 작아지거나, 25보다 커지는 경우 무시하면 된다.
        * 반복문을 한 번만 타기 때문에 소요 시간도 더 적다.
        * */

        /*int minScope = 1;
        int maxScope = n * n;

        //여행자의 시작 위치
        int position = 1;

        //결과를 출력할 좌표값
        x = 0;
        y = 0;

        for(int i = 0; i < plans.length; i ++) {
            char plan = plans[i].charAt(0);
            int tempPosition = 0;//여행자의 위치를 임시 저장할 변수
            switch (plan) {
                case 'L':
                    tempPosition = position - 1;
                    break;
                case 'R':
                    tempPosition = position +1;
                    break;
                case 'U':
                    tempPosition = position - n;
                    break;
                case 'D':
                    tempPosition = position + n;
                    break;
            }
            //범위를 벗어나는 경우
            if(tempPosition < minScope || tempPosition > maxScope) {
                continue;
            }

            position = tempPosition;
        }

        x = position / n + 1;
        y = position % n;

        System.out.print(x + " " + y);*/
    }
}
