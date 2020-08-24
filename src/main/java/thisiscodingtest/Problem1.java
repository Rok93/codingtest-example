package thisiscodingtest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 문제 해결 아이디어는 일단 입력값 중에서 가장 큰수와 두 번째로 큰 수만 저장하면 된다. 연속으로 더할 수 있는 횟수는 최대 K번이므로
 * '가장 큰 수를 K번 더하고 두 번째로 큰 수를 한 번 더하는 연산'을 반복하면 된다.
 */
// '이것이 코딩테스트다' 그리디 문제 : 큰 수의 법칙
public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberAmount = sc.nextInt();
        int M = sc.nextInt(); // 더해지는 횟수
        int K = sc.nextInt(); // 배열의 특정한 인덱스(번호)에 해당하는 수가 연속해서 K번을 초과하여 더해질 수 없는 것이 이 법칙의 특징

        int[] numbers = new int[numberAmount];
        for (int i = 0; i < numberAmount; i++) {
            numbers[i] = sc.nextInt();
        }

        Integer[] largestNumbers = Arrays.stream(numbers)
                .mapToObj(Integer::new)
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .toArray(Integer[]::new); // 불필요함 그냥 numbers를 sort하고 제일 큰값, 그 다음 큰 값 가져오면 된다.

//        Arrays.sort(numbers, Collections.reverseOrder()); // 이거 써먹을려면 int 아닌 Integer[] 타입이어야 한다.

        int largestNumberUsingNumber = 0;
        int sum = 0;
        for (int i = 0; i < M; i++) {
            if (largestNumberUsingNumber < K) { //이 부분은 가장 큰 수를 K번 더하는 것도 좋은 방법이다! (while이나 for문 이용해서)
                largestNumberUsingNumber++;
                sum += largestNumbers[0];
                continue;
            }

            sum += largestNumbers[1];
            largestNumberUsingNumber = 0;
        }
        System.out.println(sum);
    }
}
/**
 * 심화학습 (+)
 * 이 문제는 M이 10,000 이하이므로 이 방식으로도 문제를 해결할 수 있지만, M의 크기가 100억 이상처럼 커진다면 시간 초과 판정을 받을 것이다.
 * 간단한 수학적 아이디어를 이용해 더 효율적으로 문제를 해결해보자. 예를 들어 N이 5이고 입력값이 다음과 같이 주어졌다고 가정하자.
 * 이때 가장 큰 수와 두 번째로 큰 수를 선택하면 다음과 같다.
 * 가장 큰 수 : 6 / 두 번째로 큰 수 : 5
 * 이 문제를 풀려면 가장 먼저 "반복되는 수열에 대해서 파악"해야 한다. 가장 큰 수와 두 번째로 큰 수가 더해질 때는 특정한 수열 형태로
 * 일정하게 반복해서 더해지는 특징이 있다. 위의 예시에서는 수열 {6,6,6,5}가 반복된다. 그렇다면 반복되는 수열의 길이는 어떻게 될까?
 * 바로 (K + 1)로 위의 예시에서는 4가 된다. 따라서 M을 (K + 1)로 나눈 몫이 수열이 반복되는 횟수가 된다. 다시 여기에 K를 곱해주면서 가장 큰 수가
 * 등장하는 횟수가 된다. 이때 M이 (K + 1)로 나누어떨어지지 않는 경우는 M을 (K + 1)로 나눈 나머지만큼 가장 큰 수가 추가로 더해지므로 이를 고려해주어야
 * 한다. 즉, 가장 큰 수가 추가로 더해지므로 이를 고려해주어야 한다. ( 이 풀이는 1-2
 */
