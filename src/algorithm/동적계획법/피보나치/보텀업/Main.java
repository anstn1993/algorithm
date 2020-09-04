package algorithm.동적계획법.피보나치.보텀업;

public class Main {
    //DP 테이블
    public static long[] cache = new long[100];
    /*
    * 반복문을 통한 구현은 작은 문제부터 차근차근 답을 도출하기 때문에 보텀업 방식이라고 칭한다. 상향식이라고도 한다.
    * 보텀업 방식이 다이나믹 프로그래밍의 전형적인 형태다. 그리고 보텀업 방식에서는 탑다운의 메모이제이션 대신 결과 저장용 리스트를 'DP테이블'이라고 부른다.
    * */
    public static void main(String[] args) {
        //첫 번째, 두 번째 항의 값은 1로 저장한다.
        cache[1] = 1;
        cache[2] = 1;
        int n = 50;//50번째 피보나치 수
        for(int i = 3; i <= n; i ++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        System.out.println(cache[n]);
    }
}
