package algorithm.알고리즘연습장;


class Solution {

    private boolean result = true;

    private void dfs(int firstIndex, int secondIndex, int count, String[] phone_book) {
        //선택된 인덱스가 두 개인 경우
        if (count == 2) {
            String firstNumber = phone_book[firstIndex];
            String secondNumber = phone_book[secondIndex];
            if(firstNumber.length() > secondNumber.length()) {
                if(firstNumber.startsWith(secondNumber)) result = false;
            }
            else {
                if(secondNumber.startsWith(firstNumber)) result = false;
            }
        } else {
            while(true) {
                //두번째 비교 값의 색인이 마지막 인덱스까지 도달하는 경우
                if (secondIndex == phone_book.length - 1) {
                    firstIndex++;//첫 번째 비교 값의 색인을 +1
                    secondIndex = firstIndex + 1;//두 번째 비교 값의 색인은 첫 번째 비교 값의 색인 +1
                }
                //그렇지 않은 경우
                else {
                    secondIndex++;
                }
                count++;
                dfs(firstIndex, secondIndex, count, phone_book);
                if(firstIndex == phone_book.length - 2 && secondIndex == phone_book.length - 1) return;
                if(!result) return;//result가 false인 경우 완전 탐색 종료
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

public class Main {
    public static void main(String[] args) {

    }
}
