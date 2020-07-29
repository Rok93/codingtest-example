package p20200610;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Study2 {
    private static int A, B, N, M, result = 0;
    private static boolean visit[] = new boolean[100001];


    public static void main(String[] args) { //Point 클래스도 괜찮네 ~
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        A = Integer.parseInt(inputs[0]);
        B = Integer.parseInt(inputs[1]);
        N = Integer.parseInt(inputs[2]); // 동규의 위치
        M = Integer.parseInt(inputs[3]); // 주미의 위치

        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(N, 0));
        visit[N] = true; //현재 위치 방문 한 것으로 처리
        while (!queue.isEmpty()) {

            Point po = queue.poll();

            if (po.x == M) {
                result = po.y;
                return;
            }

            if (po.x + 1 < 100001 && !visit[po.x + 1]) {
                visit[po.x + 1] = true;
                queue.add(new Point(po.x + 1, po.y + 1));
            }
            if (po.x - 1 >= 0 && !visit[po.x - 1]) {
                visit[po.x - 1] = true;
                queue.add(new Point(po.x - 1, po.y + 1));
            }
            if (po.x + A < 100001 && !visit[po.x + A]) {
                visit[po.x + A] = true;
                queue.add(new Point(po.x + A, po.y + 1));
            }
            if (po.x - A >= 0 && !visit[po.x - A]) {
                visit[po.x - A] = true;
                queue.add(new Point(po.x - A, po.y + 1));
            }
            if (po.x + B < 100001 && !visit[po.x + B]) {
                visit[po.x + B] = true;
                queue.add(new Point(po.x + B, po.y + 1));
            }
            if (po.x - B >= 0 && !visit[po.x - B]) {
                visit[po.x - B] = true;
                queue.add(new Point(po.x - B, po.y + 1));
            }
            if (po.x * A < 100001 && !visit[po.x * A]) {
                visit[po.x * A] = true;
                queue.add(new Point(po.x * A, po.y + 1));
            }
            if (po.x * B < 100001 && !visit[po.x * B]) {
                visit[po.x * B] = true;
                queue.add(new Point(po.x * B, po.y + 1));
            }
        }
    }
}
