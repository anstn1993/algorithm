package algorithm.정렬.힙정렬;

public class Main {
    public static void main(String[] args) {
        int[] heap = {7, 6, 5, 8, 3, 5, 9, 1, 6};
        int number = 9;

        //힙 구조 형성(상향식)
        for(int i = 1; i < number; i ++) {
            int child = i;
            do {
                int root = (child - 1) / 2;
                //root보다 child의 값이 크면 교체
                if(heap[root] < heap[child]) {
                    int temp = heap[root];
                    heap[root] = heap[child];
                    heap[child] = temp;
                }
                child = root;
            } while (child != 0);
        }

        //정렬 및 힙구조 형성(하향식)의 반복
        for(int i = number - 1; i >= 0; i --) {
            //최상위 노드와 마지막 노드 값 교체
            int temp = heap[i];
            heap[i] = heap[0];
            heap[0] = temp;

            int root = 0;
            int child = 1;
            do {
                child = 2 * root + 1;
                //자식 노드 중에 더 큰 값을 child index로 설정
                if(child < i - 1 && heap[child] < heap[child + 1]) {
                    child ++;
                }
                //root보다 child노드 값이 크면 교체
                if(child < i && heap[child] > heap[root]){
                    temp = heap[child];
                    heap[child] = heap[root];
                    heap[root] = temp;
                }
                root = child;
            } while (child < i);
        }
        for(int i = 0; i < number; i ++) {
            System.out.print(heap[i] + " ");
        }
    }
}
