package algorithm.정렬.계수정렬;

public class Main {
    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
        int[] count = new int[10];//array의 각 요소가 몇 개 있는지 표시하기 위한 배열로 이 배열의 index가 array의 요소 값이 된다. count[3]에는 array에 있는 3의 개수가 들어간다.

        for(int i = 0; i < array.length; i ++) {
            count[array[i]] += 1;
        }

        for(int i = 0; i < count.length; i ++) {
            for(int j = 0; j < count[i]; j ++) {
                System.out.print(i + " ");
            }
        }
    }
}
