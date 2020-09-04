package algorithm.동적계획법.효율적인화폐구성;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];//화폐 단위 리스트
        for(int i = 0; i < n; i ++) {
            arr[i] = sc.nextInt();
        }

        int[] cache = new int[m + 1];
        /*
        * 답안 풀이
        * */
        cache[0] = 0;
        Arrays.fill(cache, 10001);
        //모든 화폐단위를 돌면서 그 화폐로 만들 수 있는 최소 동전 수를 cache리스트에 게속 업데이트 해준다.
        for(int i = 0; i < n; i ++) {
            for(int j = arr[i]; j <= m; j ++) {
                if(cache[j - arr[i]] != 10001) {
                    cache[j] = Math.min(cache[j], cache[j - arr[i]] + 1);
                }
            }
        }
        //결과 출력
        if(cache[m] == 10001) {//m원을 만들 수 있는 방법이 없는 경우
            System.out.println(-1);
        }
        else {
            System.out.println(cache[m]);
        }

        /*
        * 나의 최초 풀이
        * */
       /* //환폐 단위를 저장할 set
        Set<Integer> coins = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            coins.add(sc.nextInt());
        }

        //1원을 만들 수 있는 최소 화폐 수를 구한다.
        if (coins.contains(1)) {
            cache[1] = 1;
        } else {
            cache[1] = -1;
        }
        //2원부터 시작해서 m원까지 최소 화폐 수를 보텀업 방식으로 구한다.
        for (int i = 2; i <= m; i++) {
            if (coins.contains(i)) {//화폐 단위에 해당 값이 포함되는 경우
                //최소 화폐 수는 1개가 된다.
                cache[i] = 1;
            }
            //화폐 단위에 해당 값이 없는 경우
            else {
                int temp = 10000;
                int mid = i / 2;
                //낮은 값들 중 두 수의 합이 현재 값이 되는 값들의 최소 화폐 수를 더해준다.
                //예를 들면 6원을 만들기 위한 최소 화폐 수는 1, 5원, 2, 4원, 3, 3원의 최소 화폐 수를 합한 값 중에 가장 작은 값이 된다.
                for (int j = 1; j <= mid; j++) {
                    //단 그 두 값 중에 하나라도 -1인 경우에는 제외한다.
                    if(cache[j] != -1 && cache[i - j] != -1) {
                        temp = Math.min(cache[j] + cache[i - j], temp);
                    }
                }
                //temp값이 변하지 않았다는 건 가능한 조합이 없었음을 의미하고 이는 현재 값을 만들기 위한 최소 화폐의 개수도 존재하지 않음을 의미한다.
                if(temp == 10000) {
                    cache[i] = -1;
                }
                else {
                    cache[i] = temp;
                }
            }
        }
        System.out.println(cache[m]);*/
    }
}
