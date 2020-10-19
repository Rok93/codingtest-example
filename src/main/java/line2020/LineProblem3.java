package line2020;

import java.util.ArrayList;
import java.util.List;

public class LineProblem3 {
    private List<int[]> answers;

    public int[] solution(int n) {
        // n 은 10억 이하의 자연수 (int 범위 조건)
        // 덧셈 기호를 가장 적게 사용해 n을 한 자릿수로 만들 때, 덧셈 기호 사용 횟수 a와 연산 과정 끝에 만들어진 한 자릿수 b를 배열에 담아 [a, b] 형식으로 return
        // a가 가장 작은게 핵심이다 !

        String str = String.valueOf(n);
        answers = new ArrayList<>();

        if (str.length() == 1) { // n이 한 자릿수 일 때,
            return new int[]{0, n};
        }

        // 발상 --> +을 첫번째 숫자 뒤에 넣냐, 두번째 숫자 뒤에 넣냐 세번째 혹은 네번째에 넣냐 !
        // 혹시나 값이 두자리수 일때부터는 무조건 반!

        // 예외: 덧셈 기호 사용을 최소로 하는 방법이 여러 개일 경우, 그 결과로 만들어진 한자리 수는 어떤 것을 반환해도 상관없습니다. (신경 쓰지 말자 하나만 나오면 됌)

        // 예외:  0을 제외하고 07 또는 007과 같이 '0'으로 시작하는 수는 유효하지 않기 때문에 (10007) → (1000 + 7)과 같이 덧셈 기호를 7
        // 바로 앞에 삽입해야 합니다. 이후 단계에서도 같은 조건을 따르면, 덧셈 기호 사용 횟수 4와 한 자릿수 8을 구할 수 있습니다.

        for (int i = 1; i < 3; i++) {
            System.out.println(i + "씩 쪼갬 !! ");
            dfs(i, 0, str);
        }

        int minValue = answers.stream()
                .mapToInt(arr -> arr[0])
                .min()
                .getAsInt();

        return answers.stream()
                .filter(arr -> arr[0] == minValue)
                .findAny()
                .get();
    }

    private void dfs(int index, int tryNumber, String str) {
        if (str.length() == 2) {
            String firstNumber = str.substring(0, 1);
            String secondNumber = str.substring(1);
            int sum = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
            dfs(index, tryNumber + 1, String.valueOf(sum));
        }

        if (str.length() == 1) {
            answers.add(new int[]{tryNumber, Integer.parseInt(str)});
            return;
        }

        if (index >= str.length()) {
            return;
        }


        String firstNumber = str.substring(0, index);
        String secondNumber = str.substring(index);

        int tempIndex = index;
        while (secondNumber.startsWith("0")) {
            firstNumber = str.substring(0, ++tempIndex);
            secondNumber = str.substring(tempIndex);
        }

        System.out.println("first: " + firstNumber);
        System.out.println("second: " + secondNumber);

        int sum = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);

        System.out.println("sum: " + sum);

        dfs(index, tryNumber + 1, String.valueOf(sum));
    }
}
