package ntechservice;

public class NTSProblem3 {
    public int solution(int[] histogram) { // todo: 효율성 딸리는 문제 풀이!
        int maxArea = 0;

        int histogramLength = histogram.length;
        int pl = 0;
        int pr = histogramLength - 1;
        while (true) {

            int nextPl = pl;
            while (nextPl < histogramLength - 1) {
                int next = ++nextPl;
                if ((pl - next) + (histogram[next] - histogram[pl]) > 1) {
                    pl = next;
                }
            }

            int nextPr = pr;
            while (nextPr > 0) {
                int next = --nextPr;

                if ((nextPr - pr) + (histogram[next] - histogram[pr]) > 1) {
                    pr = next;
                }
            }

            int width = pr - pl - 1;
            int height = Math.min(histogram[pr], histogram[pl]);
            maxArea = width * height;
        }
    }

//    public int solution(int[] histogram) {
//
//        PriorityQueue<Stick> sticks = new PriorityQueue<>();
//
//        int length = histogram.length;
//        for (int i = 0; i < length; i++) {
//            sticks.add(new Stick(i, histogram[i]));
//        }
//
//        //최초 2개 뽑기
//        Stick stick1 = sticks.poll();
//        Stick stick2 = sticks.poll();
//
//        int maxArea = getArea(stick1, stick2);
//
//
//        Stick left = null;
//        Stick right = null;
//        while (!sticks.isEmpty()) {
////            if (stick1.getIndex() > stick2.getIndex()) {
////                left
////            }
//            System.out.println("");
//
//            Stick nextStick = sticks.poll();
//            System.out.println("현재 들어온 index: " + nextStick.getIndex());
//
//            int gap1 = (nextStick.getHeight() - stick1.getHeight()) + Math.abs(nextStick.getIndex() - stick1.getIndex());
//            int gap2 = (nextStick.getHeight() - stick2.getHeight()) + Math.abs(nextStick.getIndex() - stick2.getIndex());
//
//            if (gap1 <= 0 && gap2 <= 0) {
//                // 이번 꺼는 더 넓이가 큰 사례가 없음
//                continue;
//            }
//
//            if (gap1 > gap2) {
//                stick1 = nextStick;
//            } else if (gap1 < gap2){
//                stick2 = nextStick;
//            }
//
//            maxArea = Math.max(maxArea, getArea(stick1, stick2));
//            System.out.println("stick1 index: " + stick1.getIndex());
//            System.out.println("stick2 index: " + stick2.getIndex());
//            System.out.println("area: " + getArea(stick1, stick2));
//        }
//
//
//        return maxArea;
//    }

    private int getArea(Stick stick1, Stick stick2) {
        int width = Math.abs(stick1.getIndex() - stick2.getIndex()) - 1;
        int height = Math.min(stick1.getHeight(), stick2.getHeight());

        return width * height;
    }

    public class Stick implements Comparable<Stick> {
        private final int index;
        private final int height;

        public Stick(int index, int height) {
            this.index = index;
            this.height = height;
        }

        public int getIndex() {
            return index;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public int compareTo(Stick o) {
            if (this.height < o.height) {
                return 1;
            }

            return -1;
        }
    }
}
