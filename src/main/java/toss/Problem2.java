package toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    private static final int MAX_LOTTONUMBER = 45;
    private static final int MIN_LOTTONUMBER = 1;
    private static final int LOTTONUMBER_LENGTH = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<Integer> lottoNumbers = Arrays.stream(input.split(" "))
                .map(Integer::new)
                .distinct()
                .filter(Problem2::isValidLottoNumberRange)
                .collect(Collectors.toList());

        System.out.println(isValidLottoNumbers(lottoNumbers));
    }

    private static boolean isValidLottoNumberRange(int lottoNumber) {
        return MIN_LOTTONUMBER <= lottoNumber && lottoNumber <= MAX_LOTTONUMBER;
    }

    private static boolean isValidLottoNumbers(List<Integer> lottoNumbers) {
        return isValidLottoNumbersLength(lottoNumbers) && isValidateLottoNumbersOrder(lottoNumbers);
    }

    private static boolean isValidLottoNumbersLength(List<Integer> lottoNumbers) {
        return lottoNumbers.size() == LOTTONUMBER_LENGTH;
    }

    private static boolean isValidateLottoNumbersOrder(List<Integer> lottoNumbers) {
        List<Integer> sortedLottoNumbers = lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
        return lottoNumbers.equals(sortedLottoNumbers);
    }
}
