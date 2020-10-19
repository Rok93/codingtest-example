package naver2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NaverProblem3 {

    private Node[] nodes;
    private int minValue;

    public class Node {
        private final int id;
        private List<Node> childs;
        private int childNumber = 0;
        private int depth;

        public Node(int id) {
            this.id = id;
            childs = new ArrayList<>();
        }

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }

        public void addChild(Node child) {
            childs.add(child);
        }

        public int countChildNumber() {
            if (childs.isEmpty()) {
                return 0;
            }

            for (Node child : childs) {
                childNumber += child.countChildNumber();
            }

            return childNumber + childs.size();
        }
    }


    public int solution(int n, int[][] edges) {
        //0 번부터 시작!
        nodes = new Node[n];
        minValue = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        for (int[] edge : edges) {
            int id = edge[0];
            Node child = nodes[edge[1]];
            nodes[id].addChild(child);
        }

        System.out.println(nodes[0].countChildNumber());

        Node node = nodes[0];
        int depth = 1;
        node.setDepth(depth);
        while (!node.childs.isEmpty()) { // 전략은 뎁스를 알게 되면, 뎁스 하나씩 증가시키면서
            final int beforeDepth = depth;
            depth++;
            List<Node> beforeDepthNodes = Arrays.stream(nodes)
                    .filter(currentNode -> currentNode.getDepth() == beforeDepth)
                    .collect(Collectors.toList());

            final int currentDepth = depth;
            beforeDepthNodes.stream()
                    .flatMap(list -> list.childs.stream()
                    ).forEach(child -> child.setDepth(currentDepth));
        }

        return minValue;
    }
}
