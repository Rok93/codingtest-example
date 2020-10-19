package neowizproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem1 {

    public List<String> answerList;

    public long solution(String expression) {
        List<String> expressionList = Arrays.stream(expression.split(""))
                .collect(Collectors.toList());
        answerList = new ArrayList<>();

        play(expressionList);
        return answerList.stream()
                .mapToLong(Problem1::calculator)
                .min()
                .getAsLong();
    }

    private void play(List<String> expressionList) {
        leftSide(expressionList);
    }

    private void leftSide(List<String> expressionList) {
        int size = expressionList.size();
        for (int i = 0; i < size - 2; i++) {
            if (!isOperation(expressionList.get(i))) {
                int inputIndex = i;
                expressionList.add(inputIndex, "(");
                rightSide(expressionList, i + 2);
                expressionList.remove(inputIndex);
            }
        }
    }

    private void rightSide(List<String> expressionList, int current) {
        int size = expressionList.size();
        for (int i = current; i < size; i++) {
            if (!isOperation(expressionList.get(i))) {
                int inputIndex = i + 1;
                expressionList.add(inputIndex, ")");
                answerList.add(new ArrayList<>(expressionList).stream()
                        .collect(Collectors.joining()));
                expressionList.remove(inputIndex);
            }
        }
    }

    private static boolean isOperation(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("x")) {
            return true;
        }
        return false;
    }

    private static long calculator(String s) {
        String[] splitS = s.split("");
        int len = splitS.length;
        StringBuilder sb = new StringBuilder();

        boolean innerStatus = false;
        int firstIdx = 0;
        int secondIdx = 0;

        for (int i = 0; i < len; i++) {
            String currentStr = splitS[i];

            if (currentStr.equals(")")) {
                secondIdx = i;
                innerStatus = false;
                sb.append(calculateInnerNumber(firstIdx, secondIdx, splitS));
                continue;
            }

            if (innerStatus) {
                continue;
            }

            if (currentStr.equals("(")) {
                firstIdx = i;
                innerStatus = true;
                continue;
            }
            sb.append(currentStr);
        }

        return calculate(sb.toString());
    }

    private static long calculateInnerNumber(int first, int second, String[] s) {
        StringBuilder sb = new StringBuilder();
        for (int i = first + 1; i < second; i++) {
            sb.append(s[i]);
        }
        return calculate(sb.toString());
    }

    private static long calculate(String s) {
        List<String> operators = new ArrayList<>();
        List<String> numbers = new ArrayList<>();

        String[] splitS = s.split("");

        String temp = "";
        int len = splitS.length;
        for (int i = 0; i < len; i++) {
            String currentStr = splitS[i];
            if (isOperation(currentStr) && i != 0) {
                numbers.add(temp);
                operators.add(currentStr);
                temp = "";
                continue;
            }
            temp += currentStr;
        }
        numbers.add(temp);


        while (operators.contains("x")) {
            int idx = operators.indexOf("x");
            operators.remove(idx);
            long firstNum = Long.parseLong(numbers.get(idx));
            long secondNum = Long.parseLong(numbers.get(idx + 1));
            numbers.remove(idx);
            numbers.remove(idx);
            numbers.add(idx, calculateOnly(firstNum, secondNum, "x") + "");
        }


        int numberSize = numbers.size();
        long value = 0L;
        for (int i = 0; i < numberSize - 1; i++) {
            String operator = operators.get(i);

            long firstNum = Long.parseLong(numbers.get(i));
            long secondNum = Long.parseLong(numbers.get(i + 1));

            value += calculateOnly(firstNum, secondNum, operator);
        }


        return value;
    }

    private static long calculateOnly(long firstNum, long secondNum, String operator) {
        if (operator.equals("+")) {
            return firstNum + secondNum;
        }

        if (operator.equals("-")) {
            return firstNum - secondNum;
        }
        return firstNum * secondNum;
    }
}
