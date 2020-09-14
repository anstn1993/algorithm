package algorithm.구현.문자열압축;

import java.util.*;

public class Main {
    public int solution(String str) {
        int answer = 0;
        /*답안 풀이*/
        answer = str.length();
        //1개 단위부터 압축 단위를 늘려가면서 확인한다.
        for (int step = 1; step < str.length() / 2 + 1; step++) {
            String compressed = "";
            String prev = str.substring(0, step);//앞에서부터 step만큼 문자열을 뽑아낸다.
            int count = 1;
            //단위 크기만큼 증가시키며 이전 문자열과 비교
            for (int j = step; j < str.length(); j += step) {
                //단위만큼 prev문자열 다음 문자열을 뽑아낸다.
                String sub = "";
                for (int k = j; k < j + step; k++) {
                    if (k < str.length()) {
                        sub += str.charAt(k);
                    }
                }
                //두 문자열이 같다면
                if (prev.equals(sub)) {
                    count++;
                }
                //두 문자열이 다르다면 prev를 sub값으로 바꿔주고 sub도 다음 단위 문자열로 바꿔준다.
                else {
                    compressed += (count >= 2) ? count + prev : prev;
                    sub = "";
                    for (int k = j; k < j + step; k++) {
                        if (k < str.length()) {
                            sub += str.charAt(k);
                        }
                    }
                    prev = sub;
                    count = 1;
                }
            }
            //남은 문자열을 넣어준다.
            compressed += (count >= 2) ? count + prev : prev;
            answer = Math.min(answer, compressed.length());
        }
        return answer;

        /*
         * 나의 최초 풀이
         * */
     /*  //문자열의 길이가 1인 경우 1을 반환
//       if(str.length() == 1) {
//            return 1;
//        }
//        char[] chars = str.toCharArray();
//        int unit = chars.length / 2;//들어온 문자열로 설정할 수 있는 최대 단위 수
//        int min = 9999;//최소 자리수
//        Queue<String> strQueue = new LinkedList<>();//단위별로 쪼갠 문자열을 담을 큐
//        //단위를 1부터 늘려가면서 최소 문자열의 길이를 구한다.
//        for (int i = 1; i <= unit; i++) {
//            //i단위로 문자열을 잘라서 리스트에 넣어준다.
//            int remain = chars.length;//아직 쪼개지지 않은 문자열
//            for (int j = 0; j < chars.length; j += i) {
//                String s = null;
//                if (remain >= i) {//남은 문자열의 길이가 단위보다 크거나 같은 경우
//                    s = String.valueOf(chars, j, i);//단위만큼 문자를 문자열을 구성한다.
//                } else {
//                    s = String.valueOf(chars, j, remain);//남은 문자열
//                }
//                remain -= i;//남은 문자열의 수를 단위만큼 빼준다.
//                strQueue.add(s);//큐에 삽입
//                if (remain <= 0) {//남은 문자열이 더 이상 없다면 반복문 탈출
//                    break;
//                }
//            }
//
//            int count = 1;//같은 문자열의 개수
//            StringBuilder sb = new StringBuilder();//압축 문자열을 저장할 String builder
//            String s1 = strQueue.poll();//첫 번째 문자열을 뽑아내서 비교의 기준으로 삼는다.
//            while (!strQueue.isEmpty()) {
//                String s2 = strQueue.poll();
//                if (s1.equals(s2)) {//s1, s2가 같다면
//                    count++;//같은 문자열의 개수만 증가시켜준다.
//                } else {//두 문자열이 다르다면
//                    sb.append((count>=2)?count + s1 : s1);//압축된 문자열을 넣어주고
//                    count = 1;
//                    s1 = s2;//비교의 기준이 되는 문자열 s1을 s2로 바꿔준다.
//                }
//            }
//            //마지막으로 남은 문자열을 넣어준다.
//            sb.append((count>=2)?count + s1 : s1);//압축된 문자열을 넣어주고
//
//            min = Math.min(min, sb.length());
//        }
//        answer = min;
//        return answer;*/
    }
}
