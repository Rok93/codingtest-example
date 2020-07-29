package practice.kakao2021.intern;

public class Problem5 {
    public int solution(int[] stones, int k) {
        int answer = 0;

        while (true) {
            if (!isContinued(stones, k)) {
                break;
            }

            answer++;
            minusOne(stones);
        }
        return answer;
    }

    private void minusOne(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] != 0) {
                --arr[i];
            }
        }
    }

    private boolean isContinued(int[] arr, int k) {
        int maxDistance = 0;
        int cnt = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] != 0) {
                maxDistance = maxDistance < cnt ? cnt : maxDistance;
                cnt = 0;
            }
            cnt++;
        }
        return k >= maxDistance;
    }
}
