package line2020;

import java.util.Arrays;

public class LineProblem1 {

    private int answer;
    private int[] stocks = new int[1000001];

    public int solution(int[][] boxes) {
        // 창고에 재고로 쌓여있는 상품들을 재포장하려고 한다.
        // **재포장을 완료하기 위해 추가로 구매해야하는 상품이 몇 개인지 구하고자 한다.

        // 창고에는 상품이 2개씩 들어있는 상자가 쌓였있음, 한 상자 안에 들어있는 2개의 상품이 같은 종류인 경우와 아닌 경우 있음,
        // 1 + 1 행사를 위해 모든 상자 안에 같은 종류의 상품을 2개씩 넣고 포장하려고 한다.
        //
        // (1) 일단, 상품의 짝이 맞지 않는 상자끼리 서로 필요한 물건을 교환해서 최대한 많은 짝을 맞춰 재포장한다.
        // (2) 그렇게 했음에도 짝을 맞추기에 수량이 부족한 상품은 **추가 구매**한다. (단, 상자는 원래 창고에 쌓여있던 개수만큼 사용할 수 있으며, 추가로 더 못가져옴)

        answer = 0;

        int length = boxes.length;

        Arrays.stream(boxes)
                .flatMap(arr -> Arrays.stream(arr)
                        .mapToObj(Integer::new))
                .forEach(item -> stocks[item]++);

        for (int i = 0; i < length; i++) {
            find(boxes, i); // find i를 진행하면 i 번째 box는 짝을 맞춘 것이라 생각!
        }

        return answer;
    }

    private void find(int[][] boxes, int index) {
        int firstItem = boxes[index][0];
        int secondItem = boxes[index][1];
        if (isPair(boxes[index])) {
            stocks[firstItem] -= 2; // 재고 2개 감소 (같은거니까!)
            return;
        }

        int length = boxes.length;

        if (stocks[firstItem] % 2 == 0) { //첫번째 원소가 짝이 맞을 때
            for (int i = index + 1; i < length; i++) { // 이전 것은 정렬이 완료되어 있기 때문에 못건든다
                if (boxes[i][0] == firstItem) {
                    // 스왑
                    int temp = boxes[i][0];
                    boxes[i][0] = boxes[index][1];
                    boxes[index][1] = temp;
                    stocks[firstItem] -= 2;
                    break;
                }

                if (boxes[i][1] == firstItem) {
                    // 스왑
                    int temp = boxes[i][1];
                    boxes[i][1] = boxes[index][1];
                    boxes[index][1] = temp;
                    stocks[firstItem] -= 2;
                    break;
                }
            }
            return;
        }

        if (stocks[secondItem] % 2 == 0) { // 두번째 원소가 짝이 맞을 때
            for (int i = index + 1; i < length; i++) { // 이전 것은 정렬이 완료되어 있기 때문에 못건든다
                if (boxes[i][0] == secondItem) {
                    // 스왑
                    int temp = boxes[i][0];
                    boxes[i][0] = boxes[index][0];
                    boxes[index][0] = temp;
                    stocks[secondItem] -= 2;
                    break;
                }

                if (boxes[i][1] == secondItem) {
                    // 스왑
                    int temp = boxes[i][1];
                    boxes[i][1] = boxes[index][0];
                    boxes[index][0] = temp;
                    stocks[secondItem] -= 2;
                    break;
                }
            }

            return;
        }

        // 둘다 짝이 아니라면 !!... answer 하나 증가!
        boxes[index][1] = firstItem; // 첫번째 요소로 구입하자 (상관 없다 했으니까)
        stocks[firstItem]++;
        stocks[secondItem]--;
        answer++;
    }

    private boolean isPair(int[] box) {
        return box[0] == box[1];
    }
}
