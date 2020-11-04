package p20201023.NHNTest;

public class Problem3 {
    private static void solution(int numOfOrder, String[] orderArr) {
        // 각 세대가 원하는 색을 주문받아 지붕을 페인트로 칠하는 일을 한다!

        // 직원에게 앞 집부터 '순서대로' 주문을 받도록 업무를 주었고,
        // 주문을 받은 직원은 자신만의 방법으로 주문표를 작성했다.

        // **주문표 작성 규은 다음과 같다!**

        // 각 세대로부터 R, G, B 색상을 주문받아, 주문표 작성
        // 주문표에는 대문자 알파벳 R, G, B와 숫자(1 ~ 9), 그리고 특수문자 '(' , ')' 만 존재한다.
        // 주문표는 숫자나 문자로만 시작할 수 있다.
        // 숫자는 연속으로 올 수 없다
        // 숫자 다음에는 문자 또는 '('만 올 수 있다.  [숫자 또는 ')'가 올 수 없다)
        // 괄호 안에 다른 괄호가 존재할 수 있다! (ex: 3(R2(GB))  )
        // '('나 바로 앞에 ')' 나 '('가 오는 경우는 없다.

        for (int i = 0; i < numOfOrder; i++) {
            String order = orderArr[i];

            String beforeOrder = "INITIAL";
            String result = "";

            while (!beforeOrder.equals(order)) {
                beforeOrder = order;

                for (int j = order.length() - 1; j >= 0; j--) {
                    if (order.charAt(j) == '(') {
                        System.out.println("현재 order는: " + order);
                        for (int k = j + 1; k < order.length() - 1; k++) {
                            if (order.charAt(k) == ')') {
                                // j ~ k 안의 값
                                String subStr = order.substring(j + 1, k); //괄호 안의 내용!
                                System.out.println("괄호안의 내용: " + subStr);

                                if (j - 1 < 0) {
                                    continue;
                                }

                                char beforeChar = order.charAt(j - 1);
                                if ('0' <= beforeChar && beforeChar <= '9') {
                                    System.out.println("숫자라서 변경!");
                                    // 숫자라면 !!
                                    int duplicateNumber = beforeChar - '0';
                                    String removeStr = order.charAt(j - 1) + "\\(" + subStr + "\\)";
                                    String substring = order.substring(j - 1, k + 1);
                                    System.out.println("제거할 녀석: " + substring);
                                    order = order.replace(substring, duplecateWord(subStr, duplicateNumber));
                                    System.out.println("제거후: " + order);
                                    break;
                                }

                                System.out.println("앞에 문자라서 변경!");

                                String replacement = beforeChar + subStr + beforeChar;
                                order = order.replace(order.substring(j - 1, k + 1), replacement);
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println(order.replaceAll(" ", ""));
        }
    }

    private static String duplecateWord(String subStr, int duplicateNumber) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < duplicateNumber; i++) {
            sb.append(subStr);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
//        int numOfOrder = 2;
//        String[] orderArr = {"B2(RG)", "3(R2(GB))"};

        int numOfOrder = 3;
        String[] orderArr = {"3(BR2(R))", "B(RGB(RG))", "1B2R3G"};


        solution(numOfOrder, orderArr);
    }
}
