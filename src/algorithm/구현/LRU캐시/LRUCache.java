package algorithm.구현.LRU캐시;

import java.util.HashMap;
import java.util.Map;

/*
* LRU Cache problem
* 출처: leet code
* */
public class LRUCache {

    private int capacity;//캐시 size
    CacheItem head;
    CacheItem tail;
    Map<Integer, CacheItem> map;//각 노드 포인터를 저장해서 탐색시 O(1) 시간 복잡도로 접근하기 위한 map

    //캐시에 저장될 노드 클래스
    class CacheItem {
        private int key;
        private int value;
        private CacheItem prev;//이전 노드 레퍼런스
        private CacheItem next;//다음 노드 레퍼런스

        public CacheItem(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = null;
        tail = null;
        map = new HashMap<>();
    }

    public int get(int key) {
        //map에 해당 키의 노드가 없는 경우 -1 return
        if (!map.containsKey(key)) {
            return -1;
        }
        //해당 키의 데이터가 있는 경우
        else {
            CacheItem cur = map.get(key);//현재 노드의 포인터
            //참조된 노드가 헤드가 아닌 경우
            if (cur != head) {
                //참조된 노드가 테일인 경우 테일의 prev 노드를 테일로 만든다.
                if (cur == tail) {
                    tail = tail.prev;
                }
                //참조된 노드를 헤드로 끌고 온다.
                //head ...cur.prev cur cur.next...
                //cur head .... cur.prev cur.next
                if (cur.prev != null) cur.prev.next = cur.next;
                if (cur.next != null) cur.next.prev = cur.prev;
                cur.next = head;
                cur.prev = null;
                head.prev = cur;
                head = cur;
            }

            //현재 노드의 value return
            return cur.value;
        }
    }

    public void put(int key, int value) {
        if (get(key) == -1) {//새로운 key가 삽입되는 경우
            //가장 앞에 삽입
            //head ......
            //new head .....
            CacheItem cur = new CacheItem(key, value);

            //가장 처음 삽입되는 경우
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.prev = cur;
                head = cur;
            }

            //map에 해당 노드 추가
            map.put(key, cur);

            //capacity를 초과하면 가장 마지막 노드를 제거
            //.....tail.prev tail
            //.....tail.prev
            if (map.size() > capacity) {
                map.remove(tail.key);
                tail.prev.next = null;
                tail = tail.prev;
            }

        } else {//이미 존재하는 key가 삽입되는 경우
            //update
            map.get(key).value = value;
        }
    }

    public void show() {
        if(head == null) {
            System.out.println("no data");
        }
        else {
            CacheItem cur = head;
            while(cur != null) {
                System.out.print("(" +cur.key + ", " + cur.value + ") ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
}
