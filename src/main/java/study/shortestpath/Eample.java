package study.shortestpath;

import java.util.ArrayList;
import java.util.List;

public class Eample {
    public static final int[] dp = new int[100];

    public static class Node {
        private final int no;
        private final List<Node> lines;

        public Node(int no) {
            this.no = no;
            this.lines = new ArrayList<>();
        }

        public void addNode(Node node) {
            lines.add(node);
        }
    }

    public static void main(String[] args) {
        System.out.println(dp[1]);
    }
}
