package nhngodocodingtest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NhnGodoProblem2 {
    public int solution(int page, int[] broken) {
        int currentPage = 100;
        if (currentPage == page) { // 이동하기 원하는 페이지가 현재 페이지와 같다면 클릭 할 필요가 없다.
            return 0;
        }

        int clickNumberOfOnlyPlusOrMinusBtn = Math.abs(page - currentPage); // 현재 페이지로부터 + 혹은 - 버튼으로만 이동한 횟수!

        List<Integer> buttons = IntStream.rangeClosed(0, 9) //버튼은 0 ~ 9 까지 있다.
                .mapToObj(Integer::new)
                .collect(Collectors.toList());

        for (int brokenButton : broken) { // 고장난 버튼을 제거한다!
            buttons.remove(new Integer(brokenButton));
        }

        if (buttons.isEmpty()) { // 모든 버튼이 고장났다면 ! 초기 페이지로부터 목표하는 페이지까지의 + 또는 - 버튼으로만 이동간 값 반환
            return clickNumberOfOnlyPlusOrMinusBtn;
        }


        List<Integer> eachPageNumbers = Arrays.stream(String.valueOf(page).split(""))
                .mapToInt(Integer::parseInt)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());

        String tempNumber = "";
        int clickCountNumber = String.valueOf(page).length();
        for (int i = 0; i < eachPageNumbers.size(); i++) { // page의 맨 앞자리부터 하나씩 검사
            Integer currentPageNumber = eachPageNumbers.get(i);
            if (buttons.contains(currentPageNumber)) { // 정삭작동하는 번호와 일치하다면 1번 클릭 (이 숫자로는 1번의 클릭으로 이동가능하다!)
                tempNumber += currentPageNumber + "";
                eachPageNumbers.remove(i--); // 해당하는 앞자리 수를 제거한다!
                continue;
            }

            break; // 일치하지 않는 순간 바로 +, - 계산 식으로 들어간다.
        }

        if (eachPageNumbers.size() == 0) { // page 각 숫자가 모든 고장나지 않은 버튼에 해당한다면
            return Math.min(clickCountNumber, clickNumberOfOnlyPlusOrMinusBtn);
        }

        int buttonTotalNumber = buttons.size();

        int nearNumber = 499999;
        if (buttonTotalNumber > 1) {
            Integer firstPageNumber = eachPageNumbers.get(0);

            int upGap = 499999;
            int downGap = 499999;

            boolean isUpValuePresent = buttons.stream() // eachPageNumbers의 첫번째 값 보다 큰 값이 존재하는가?
                    .anyMatch(button -> firstPageNumber < button);

            if (isUpValuePresent) {
                int nearUpButton = buttons.stream() // eachPageNumbers의 첫번째 값 보다 큰 버튼 중 가장 작은 값 (큰 값중 가까운 값)
                        .filter(button -> firstPageNumber < button)
                        .mapToInt(Integer::intValue)
                        .min()
                        .getAsInt();
                upGap = nearUpButton - firstPageNumber;
            }

            boolean isDownValuePresent = buttons.stream() // eachPageNumbers의 첫번째 값 보다 작은 값이 존재하는가?
                    .anyMatch(button -> firstPageNumber > button);

            if (isDownValuePresent) {
                int nearDownButton = buttons.stream() // eachPageNumbers의 첫번째 값 보다 작은 버튼 중 가장 값 (작은 값중 가까운 값)
                        .filter(button -> firstPageNumber > button)
                        .mapToInt(Integer::intValue)
                        .max()
                        .getAsInt();
                downGap = firstPageNumber - nearDownButton;
            }

            eachPageNumbers.remove(0); // 이 페이지는 비교를 했기 때문에 필요없다!

            if (upGap < downGap) { // 위로의 차이가 더 적을 떄!
                tempNumber += upGap;

                int minButton = buttons.stream()
                        .mapToInt(Integer::intValue)
                        .min()
                        .getAsInt();

                for (int i = 0; i < eachPageNumbers.size(); i++) {
                    tempNumber += minButton;
                }

                nearNumber = Math.abs(Integer.parseInt(tempNumber) - page) + clickCountNumber;
            } else { // 아래로의 차이가 더 적을 때! (같은 경우도 이 값으로 계산, 어짜피 같다)
                tempNumber += firstPageNumber - downGap;
                int maxButton = buttons.stream()
                        .mapToInt(Integer::intValue)
                        .max()
                        .getAsInt();

                for (int i = 0; i < eachPageNumbers.size(); i++) {
                    tempNumber += maxButton;
                }

                nearNumber = Math.abs(Integer.parseInt(tempNumber) - page) + clickCountNumber;
            }
        }

        int minusNumber = 499999;
        int pageLength = String.valueOf(page).length();
        if (pageLength < 6) { // page보다 한자리수 많고 버튼으로 입력 가능한 최소 크기 값에서 차이값을 구한다
            int minButton = buttons.stream()
                    .filter(button -> !button.equals(0))
                    .mapToInt(Integer::intValue)
                    .min()
                    .getAsInt();

            String value = minButton + "";
            for (int i = 0; i < pageLength; i++) {
                value += buttons.contains(0) ? 0 : minButton;
            }

            minusNumber = (pageLength + 1) + Math.abs(Integer.parseInt(value) - page);
        }

        int plusNumber = 499999;
        if (pageLength > 1) { // page보다 한자리수 적고 버튼으로 입력 가능한 최대 크기 값에서 차이값을 구한다
            int maxButton = buttons.stream()
                    .filter(button -> !button.equals(0))
                    .mapToInt(Integer::intValue)
                    .max()
                    .getAsInt();

            String value = "";
            for (int i = 0; i < pageLength - 1; i++) {
                value += maxButton;
            }

            plusNumber = (pageLength - 1) + Math.abs(Integer.parseInt(value) - page);
        }

        return Math.min(clickNumberOfOnlyPlusOrMinusBtn, Math.min(nearNumber, Math.min(plusNumber, minusNumber)));
    }
}
