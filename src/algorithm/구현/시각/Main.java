package algorithm.구현.시각;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int answer = 0;
        //00시 00분 00초부터 23시 59분 59초까지 전부 순회해도 86400밖에 되지 않기 때문에 3중 반복문으로 해결을 해도 충분히 제한 시간 안에 연산이 가능하다.
        for(int i = 0; i < n + 1; i ++) {
            for(int j = 0; j < 60; j ++) {
                for(int k = 0; k < 60; k ++) {
                    String value = String.valueOf(i) + String.valueOf(j) + String.valueOf(k);
                    if(value.contains("3")) {
                        answer += 1;
                    }
                }
            }
        }
        System.out.print(answer);
    }
}
