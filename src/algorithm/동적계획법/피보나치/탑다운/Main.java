package algorithm.동적계획법.피보나치.탑다운;

public class Main {

    //한 번 계산된 결과를 메모이제이션(캐싱)하기 위한 리스트
    public static long[] cache = new long[100];

    /*
    * 재귀 함수를 이용한 다이나믹프로그래밍 방식은 큰 문제를 해결하기 위해서 작은 문제를 호출하기 때문에 탑다운 방식이라고 한다.
    * 정리하자면 메모이제이션 기법은 탑다운 방식에 국한되어 사용되는 표현법이고 탑다운은 하향식이라고도 한다.
    * */
    public static long fibo(int x) {
        //종료 조건
        if(x == 1 || x == 2) {
            return 1;
        }
        //캐싱된 데이터라면 그 값을 바로 반환
        if(cache[x] != 0) {
            return cache[x];
        }
        //아직 계산되지 않은 값인 경우에만 점화식에 따라 연산 수행
        cache[x] = fibo(x - 1) + fibo(x - 2);
        return cache[x];
    }

    public static void main(String[] args) {
        System.out.println(fibo(10));
    }
}
