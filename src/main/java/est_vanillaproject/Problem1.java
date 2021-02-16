package est_vanillaproject;

import java.util.Arrays;

public class Problem1 {
    private static final int CREDIT_CARD_NUMBERS_LENGTH = 16;

    public int[] solution(String[] card_numbers) {
        Boolean[] answer = Arrays.stream(card_numbers)
                .map(this::validateCreditCardNumbers)
                .toArray(Boolean[]::new);

        int[] a = new int[answer.length];
        int cnt = 0;
        for (Boolean bool : answer) {
            a[cnt++] = bool ? 1 : 0;
        }

        return a;
    }

    public boolean validateCreditCardNumbers(String cardNumbers) {
        if (cardNumbers.contains("-")) {
            if (isNotValidateHypenCreditNumbers(cardNumbers)) {
                return false;
            }
        }

        String filteredCardNumbers = cardNumbers.replaceAll("-", "");

        int cardNumbersLength = filteredCardNumbers.length();
        if (cardNumbersLength != CREDIT_CARD_NUMBERS_LENGTH) {
            return false;
        }

        int[] cardNumbers2 = Arrays.stream(filteredCardNumbers.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int evenNumbersSum = 0;

        for (int i = 0; i < cardNumbersLength; i+= 2) { // 짝수 확인
            int temp = 2 * cardNumbers2[i];

            while (temp >= 10) {
                temp = Arrays.stream(String.valueOf(temp).split(""))
                        .mapToInt(Integer::parseInt)
                        .sum();
            }

            evenNumbersSum += temp;
        }



        int oddNumbersSum = 0;
        for (int i = 1; i < cardNumbersLength; i+= 2) { // 홀수
            oddNumbersSum += cardNumbers2[i];
        }

        return (evenNumbersSum + oddNumbersSum) % 10 == 0;
    }

    private boolean isNotValidateHypenCreditNumbers(String cardNumbers) {
        if (cardNumbers.length() - cardNumbers.replaceAll("-", "").length() != 3) {
            return true;
        }

        String[] eachSectionCardNumbers = cardNumbers.split("-");
        for (String eachSectionCardNumber : eachSectionCardNumbers) {
            if (eachSectionCardNumber.length() != 4) {
                return true;
            }
        }

        return false;
    }
}
