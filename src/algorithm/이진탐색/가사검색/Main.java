package algorithm.이진탐색.가사검색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {


    private int findLeftIndex(List<String> list, String target, boolean front, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;

        boolean exist = false;
        //와일드 카드가 접두사인 경우
        if (front) {
            exist = list.get(mid).endsWith(target);
            //중간값이 와일드 카드에 부합하면서 중간값의 index가 0이거나 중간값의 왼쪽 값이 중간 값과 다른 경우
            if (exist && (mid == 0 || list.get(mid - 1).compareTo(target) < 0)) {
                return mid;
            } else if (list.get(mid).compareTo(target) >= 0) {
                return findLeftIndex(list, target, front, start, mid - 1);
            } else {
                return findLeftIndex(list, target, front, mid + 1, end);
            }
        }
        //와일드 카드가 접미사인 경우
        else {
            exist = list.get(mid).startsWith(target);
            List<String> copy = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                StringBuffer sb = new StringBuffer(list.get(i));
                copy.add(sb.reverse().toString());
            }
            StringBuffer reverseTarget = new StringBuffer(target);

            //중간값이 와일드 카드에 부합하면서 중간값의 index가 0이거나 중간값의 왼쪽 값이 중간 값과 다른 경우
            if (exist && (mid == 0 || !list.get(mid - 1).startsWith(target))) {
                return mid;
            } else if (copy.get(mid).compareTo(reverseTarget.reverse().toString()) > 0) {
                return findLeftIndex(list, target, front, start, mid - 1);
            } else {
                return findLeftIndex(list, target, front, mid + 1, end);
            }
        }
    }

    private int findLastIndex(List<String> list, String target, boolean front, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;

        boolean exist = false;
        //와일드 카드가 접두사인 경우
        if (front) {
            exist = list.get(mid).endsWith(target);
            //중간값이 와일드 카드에 부합하면서 중간값의 index가 0이거나 중간값의 왼쪽 값이 중간 값과 다른 경우
            if (exist && (mid == 0 || list.get(mid - 1).compareTo(target) > 0)) {
                return mid;
            } else if (list.get(mid).compareTo(target) >= 0) {
                return findLeftIndex(list, target, front, start, mid - 1);
            } else {
                return findLeftIndex(list, target, front, mid + 1, end);
            }
        }
        //와일드 카드가 접미사인 경우
        else {
            exist = list.get(mid).startsWith(target);
            List<String> copy = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                StringBuffer sb = new StringBuffer(list.get(i));
                copy.add(sb.reverse().toString());
            }
            StringBuffer reverseTarget = new StringBuffer(target);

            //중간값이 와일드 카드에 부합하면서 중간값의 index가 0이거나 중간값의 왼쪽 값이 중간 값과 다른 경우
            if (exist && (mid == 0 || !list.get(mid - 1).startsWith(target))) {
                return mid;
            } else if (copy.get(mid).compareTo(reverseTarget.reverse().toString()) >= 0) {
                return findLeftIndex(list, target, front, start, mid - 1);
            } else {
                return findLeftIndex(list, target, front, mid + 1, end);
            }
        }
    }

    private int countByValue(List<String> list, String target, boolean front, int start, int end) {
        int frontIndex = findLeftIndex(list, target, front, start, end);

        if (frontIndex == -1) {
            return 0;
        }

        int lastIndex = findLastIndex(list, target, front, start, end);
        return lastIndex - frontIndex + 1;
    }

    public int[] solution(String[] words, String[] queries) {

        List<String>[] wordsList = new List[100001];//가사의 길이별로 가사를 모아두는 리스트의 배열
        for (int i = 0; i < wordsList.length; i++) {
            wordsList[i] = new ArrayList();
        }

        //단어 길이 index에 해당하는 리스트에 해당 단어 추가해주기
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            wordsList[word.length()].add(word);
        }

        //각 리스트를 오름차순으로 정렬해준다.
        for (int i = 0; i < wordsList.length; i++) {
            if (wordsList[i].size() > 1) {
                Collections.sort(wordsList[i]);
            }
        }


        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];//키워드
            int length = queries.length;
            boolean front = true;//키워드의 와일드카드가 접두사에 붙는지, 접미사에 붙는지 확인
            if (!query.startsWith("?")) {
                front = false;
            }
            query = query.replace("?", "");
            int count = countByValue(wordsList[length], query, front, 0, wordsList[length].size() - 1);
            answer[i] = count;
        }

        return answer;
    }
}

public class Main {

}
