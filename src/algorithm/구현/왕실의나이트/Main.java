package algorithm.구현.왕실의나이트;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //입력값 받기
        String[] input = sc.next().split("");
        //말의 위치
        int x = Integer.parseInt(input[1]);
        int y = input[0].charAt(0) - 'a' + 1;
        /*아래와 같은 방식으로 y좌표값을 구하지 말자. char형은 결국 숫자이기 때문에 offset인 a를 기준으로 계산을 하면 된다. */
        /*int y = 0;
        char[] columnTypes = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};//열의 알파벳 배열
        //열의 알파벳을 숫자로 변환
        for(int i = 0; i < columnTypes.length; i ++) {
            if(columnTypes[i] == input[0].charAt(0)) {
                y = i + 1;
            }
        }*/
        int[] dx = {2, 2, -1, 1, -2, -2, -1, 1};
        int[] dy = {-1, 1, 2, 2, -1, 1, -2, -2};
        int answer = 0;//경우의 수
        int n = 8;//행과 열의 크기


        for(int i = 0; i < 8; i ++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];
            if(tempX < 1 || tempY < 1 || tempX > 8 || tempY > 8) {
                continue;
            }
            answer ++;
        }
        System.out.print(answer);

    }
}
