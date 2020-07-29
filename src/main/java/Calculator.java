import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        List<int[]> answer = new ArrayList<>();
        int cnt = 0;
        for(int i = 0; i < 3; i++) {
            int[] temp;
            if (N % 3 == (i + 1)) {
                temp = new int[(N / 3) * 2 + 1];
            } else {
                temp = new int[(N / 3) * 2];
            }
            int index = 0;
            for(int j = i; j <N; j++) {
                if(cnt == 2) {
                    cnt = 0;
                    continue;
                }

                temp[index++] = j;
                cnt++;
            }
            answer.add(temp);
        }
        int maxValue = answer.stream()
                .mapToInt(wines -> sum(wines, list))
                .max()
                .getAsInt();
        System.out.println(maxValue);
    }

    private static int sum(int[] wineIndexs, List<Integer> wines) {
        int sum = 0;
        for (int i = 0; i < wineIndexs.length; i++) {
            if (i != 0 && wineIndexs[i] == 0) {
                continue;
            }
            sum += wines.get(wineIndexs[i]);
        }
        return sum;
    }
}

