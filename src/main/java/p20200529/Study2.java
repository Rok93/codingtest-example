package p20200529;

import java.util.*;

public class Study2 {
    public static int degree;
    private static int totalPeople;
    private static People[] peoples;

    public static void main(String[] args) {
        degree = 0;

        Scanner sc = new Scanner(System.in);
        //노드 갯수
        totalPeople = Integer.parseInt(sc.nextLine().trim());
        peoples = new People[totalPeople + 1];

        for (int i = 1; i < totalPeople + 1; i++) { //인접 리스트 초기화
            peoples[i] = new People(i);
        }

        String[] temp = sc.nextLine().split(" ");
        int target1 = Integer.parseInt(temp[0]); //7
        int target2 = Integer.parseInt(temp[1]); //3

        int relationNumber = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < relationNumber; i++) {
            temp = sc.nextLine().split(" ");

            int parentNumber = Integer.parseInt(temp[0]);
            int childNumber = Integer.parseInt(temp[1]);
            peoples[parentNumber].addChild(peoples[childNumber]);
            peoples[childNumber].setParent(peoples[parentNumber]);
        }
        BFS(target1, target2);
    }

    public static class People {
        private final int number;
        private People parent;
        private List<People> childes = new ArrayList<>();

        public int getNumber() {
            return number;
        }

        public People(int number) {
            this.number = number;
        }

        public People getParent() {
            return parent;
        }

        public void setParent(People parent) {
            this.parent = parent;
        }

        public List<People> getChildes() {
            return childes;
        }

        public void addChild(People child) {
            childes.add(child);
        }
    }

    public static void BFS(int a, int b) {
        // 노드의 방문 여부 판단 (초기값: false)
        boolean visited[] = new boolean[totalPeople + 1];
        // BFS 구현을 위한 큐(Queue) 생성
        LinkedList<Integer> queue = new LinkedList<>();
        // 현재 노드를 방문한 것으로 표시하고 큐에 삽입(enqueue)
        visited[a] = true;
        queue.add(a);
        // 큐(Queue)가 빌 때 까지 반복
        while (queue.size() != 0) {
            // 방문한 노드를 큐에서 추출(dequeue)하고 값을 출력
            a = queue.poll();
            System.out.print(a + " ");
            if (a == b) {
                return;
            }
            // 방문한 노드와 인접한 모든 노드를 가져온다.

            //부모
            if (peoples[a].getParent() != null) {
                People parent = peoples[a].getParent();
                int parentNumber = parent.getNumber();

                if (!visited[parentNumber]) {
                    visited[parentNumber] = true;
                    queue.add(parentNumber);
                }
            }

            //자식들
            List<People> childes = peoples[a].getChildes();
            int childesLen = childes.size();
            for (int i = 0; i < childesLen; i++) {
                People child = childes.get(i);
                int childNumber = child.getNumber();

                if (!visited[childNumber]) {
                    visited[childNumber] = true;
                    queue.add(childNumber);
                }
            }
        }
    }
}