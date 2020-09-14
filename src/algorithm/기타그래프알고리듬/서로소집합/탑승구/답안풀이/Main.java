package algorithm.기타그래프알고리듬.서로소집합.탑승구.답안풀이;

import java.util.Scanner;

public class Main {


    public static int g, p;
    //각 탑승구의 부모 탑승구 테이블
    public static int[] parents = new int[100001];

    public static int findParent(int x) {
        if (x != parents[x]) {
            parents[x] = findParent(parents[x]);
        }
        return parents[x];
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parents[b] = a;
        else parents[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        g = sc.nextInt();
        p = sc.nextInt();

        //부모노드 테이블 초기화
        for (int i = 0; i <= g; i++) {
            parents[i] = i;
        }

        int result = 0;
        for (int i = 0; i < p; i++) {
            int x = sc.nextInt();
            int root = findParent(x);//현재 탑승구의 부모 탑승구 확인
            if(root == 0) break;//부모 탑승구가 0이면 더 이상 해당 탑승구 이하의 탑승구에는 도킹 불가
            unionParent(root, root - 1);//왼쪽 집합과 합치기
            result ++;
        }
        System.out.println(result);
    }
}
