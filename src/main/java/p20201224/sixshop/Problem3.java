package p20201224.sixshop;

public class Problem3 {
    private static final int[] BOX_CAPACITIES = {5, 3};

    public int solution(int n) { //dp의 느낌이 있음 ..
        // 상자: 옷 3, 5개를 담을 수 있음 (상자 크기 상관없이 상자의 개수로 배송비를 받음)
        // 상자의 개수를 최소한으로 줄이려고 한다.

        //단, 상자를 보내기 위해서는 상자에 반드시 들어갈 수 있는 옷이 모두 들어가야 한다. (2개, 4개 이렇게는 존재 X)
        int answer = 0;

        if (n % BOX_CAPACITIES[0] == 0) {
            return n / BOX_CAPACITIES[0];
        }

        int min = (int)1e9;


        while (n - BOX_CAPACITIES[0] >= 0) {
            answer++;
            n -= BOX_CAPACITIES[0];
        }

        while (n - BOX_CAPACITIES[1] >= 0) {
            answer++;
            n -= BOX_CAPACITIES[1];
        }

        return n == 0 ? answer : -1;
    }
}
