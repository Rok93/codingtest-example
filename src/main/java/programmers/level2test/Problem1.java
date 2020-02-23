package programmers.level2test;

import java.util.stream.IntStream;

/* 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다.
숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때
 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
 */
public class Problem1 {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrimeNumber(sum)) {
                        System.out.println(i + " " + j + " " + k);
                        System.out.println("sum=" + sum);
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public boolean isPrimeNumber(int number) {
        return IntStream.rangeClosed(2, number - 1)
                .noneMatch(n -> number % n == 0);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 7, 6, 4};

        Problem1 sol = new Problem1();
        System.out.println(sol.solution(nums1));
        System.out.println(sol.solution(nums2));

    }
}
