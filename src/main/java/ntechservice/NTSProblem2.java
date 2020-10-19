package ntechservice;

public class NTSProblem2 {
    public int solution(int N) {
        int answer = 0;

        // 직사각형 모양의 테이블의 한쪽변에 N 명씩, 마주 보는 양변에 총 2 x N 명의 사람이 일정한 간격으로 마주보고 앉아있다.
        // 회의 시작전 악수 --> 한 사람은 한 번에 한 명과 악수 할 수 있고, 모든 악수는 동시에 진행
        // 악수할 때, 모든 사람이 참여 + 악수하는 사람들의 팔이 교차 X, 대각선 방향에 위치한 사람과도 악수해서는 X
        // todo: 악수는 자신의 왼쪽, 오른쪽 혹은 맞은편 사람과만 악수할 수 있다.
        int[] dpTable = new int[46];
        dpTable[1] = 1;
        dpTable[2] = 2;

        for (int i = 3; i <= N; i++) {
            dpTable[i] = dpTable[i - 1] + dpTable[i - 2];
        }

        return dpTable[N];
    }
}
