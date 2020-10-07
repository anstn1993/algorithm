package algorithm.dfs.전화번호접두어;

//출처: 프로그래머스 문제
public class Solution {
    private boolean result = true;//결과를 반환

    //두 전화번호중 하나가 다른 하나의 접두어가 되는 경우를 완전 탐색
    private void dfs(int firstIndex, int secondIndex, int count, String[] phone_book) {
        //선택된 전화번호가 두 개인 경우
        if (count == 2) {
            String firstNumber = phone_book[firstIndex];
            String secondNumber = phone_book[secondIndex];
            if(firstNumber.length() > secondNumber.length()) {
                if(firstNumber.startsWith(secondNumber)) result = false;
            }
            else {
                if(secondNumber.startsWith(firstNumber)) result = false;
            }
        } else {//선택된 전화번호가 하나인 경우
            while(true) {
                //두번째 전화번호의 색인이 마지막 인덱스까지 도달하는 경우
                if (secondIndex == phone_book.length - 1) {
                    firstIndex++;//첫 번째 비교 값의 색인을 +1
                    secondIndex = firstIndex + 1;//두 번째 비교 값의 색인은 첫 번째 비교 값의 색인 +1
                }
                //그렇지 않은 경우
                else {
                    secondIndex++;//두 번째 전화번호의 색인만 +1
                }
                count++;//비교 전화번호 개수 +1
                dfs(firstIndex, secondIndex, count, phone_book);
                //완전탐색이 끝난 경우 탐색 종료
                if(firstIndex == phone_book.length - 2 && secondIndex == phone_book.length - 1) return;
                //하나의 번호가 다른 하나의 번호의 접두어인 경우가 나온 경우 탐색 종료
                if(!result) return;
                count--;
            }
        }
    }

    public boolean solution(String[] phone_book) {
        int count = 1;
        if(phone_book.length == 1) {
            return true;
        }
        dfs(0, 0, count, phone_book);
        return result;
    }
}
