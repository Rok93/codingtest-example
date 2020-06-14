package programmers.backend;

public class Problem2 {

    private static final int X_INDEX = 0;
    private static final int Y_INDEX = 1;

    private static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // int[0] --> int[1]:right , int[1] --> int[0]: left
    private static int answer = 0;

    public int solution(int[][] office, int r, int c, String[] move) {
        int N = office.length;
        int currentDirectionIndex = 0;

        answer += office[r][c];
        office[r][c] = 0;

        for (String s : move) {

            int[] currentDirection = direction[currentDirectionIndex];

            if (s.equals("left")) {
                --currentDirectionIndex;
                if (currentDirectionIndex < 0) {
                    currentDirectionIndex = direction.length - 1;
                }
                continue;
            }

            if (s.equals("right")) {
                ++currentDirectionIndex;
                if (currentDirectionIndex >= direction.length) {
                    currentDirectionIndex = 0;
                }
                continue;
            }

            if (s.equals("go")) {
                int nextR = r + currentDirection[X_INDEX];
                int nextC = c + currentDirection[Y_INDEX];

                if ((nextC >= 0 && nextC <= N - 1) && (nextR >= 0 && nextR <= N - 1)) { //경계에 걸려서 전진 못하는 경우
                    if (office[nextR][nextC] == -1) { //물건이 있는 경우 SKIP
                        continue;
                    }

                    r = nextR;
                    c = nextC;
                    answer += office[r][c];
                    office[r][c] = 0;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Problem2 sol = new Problem2();
        int[][] office = {{5, -1, 4}, {6, 3, -1}, {2, -1, 1}};
        int r = 1;
        int c = 0;
        String[] move = {"go", "go", "right", "go", "right", "go", "left", "go"};

        int answer = sol.solution(office, r, c, move);
        System.out.println(answer);
    }
}
