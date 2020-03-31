package skillcheck.day1;

/**
 * 효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다. 칸이 총 4개 있을 때, 효진이는
 * (1칸, 1칸, 1칸, 1칸)
 * (1칸, 2칸, 1칸)
 * (1칸, 1칸, 2칸)
 * (2칸, 1칸, 1칸)
 * (2칸, 2칸)
 * 의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다. 멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내, 여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요. 예를 들어 4가 입력된다면, 5를 return하면 됩니다.
 */
public class Problem1 {
    private final long[] NEXT_STEP = {1L, 2L};
    private final int ZERO = 0;
    private Long count;

    public long solution(int n) {
        count = 0L;
        getSolution((long) n);
        return count % 1234567L;
    }

    private void getSolution(Long sum) {
        if (sum == ZERO) {
            count++;
            return;
        }

        for (int i = 0; i < NEXT_STEP.length; i++) { //재귀의 문제 너무 깊어지면 이렇다..
            if(sum < NEXT_STEP[i]) {
                break;
            }
                getSolution(sum - NEXT_STEP[i]);
        }
    }

    public static void main(String[] args) {
        Problem1 sol = new Problem1();
        int n1 = 9;
        System.out.println(sol.solution(n1));
    }
}
