package kakao2020;

public class KakaoProblem1 {
    private static final int ID_MIN_LENGTH = 3;
    private static final int ID_MAX_LENGTH = 15;
    private static final char PERMIT_DOT = '.';
    private static final char PERMIT_UNDER_BAR = '_';
    private static final char PERMIT_HYPHEN = '-';
    private static final int TWO = 2;

    public String solution(String new_id) {
        if (isValidId(new_id)) {
            return new_id;
        }

        new_id = changeLargeAlphabet(new_id);
        new_id = removeNotPermittedSymbol(new_id);
        new_id = reduceDot(new_id);
        new_id = reduceNotPermitDot(new_id);
        new_id = plusAThanEmpty(new_id);
        new_id = subStringIfMoreThanLimitLength(new_id);
        new_id = plusLastLetterWhenIdLengthLessThanTwo(new_id);

        return new_id;

    }

    private String plusLastLetterWhenIdLengthLessThanTwo(String new_id) {
        if (new_id.length() <= TWO) {
            char lastLetter = new_id.charAt(new_id.length() - 1);
            while (new_id.length() < 3) {
                new_id += lastLetter;
            }
        }

        return new_id;
    }

    private String subStringIfMoreThanLimitLength(String new_id) {
        if (new_id.length() > ID_MAX_LENGTH) {

            new_id = new_id.substring(0, ID_MAX_LENGTH);

            while (new_id.endsWith(PERMIT_DOT + "")) {
                new_id = new_id.substring(0, new_id.length() - 1);
            }

            return new_id;
        }

        return new_id;
    }

    private String plusAThanEmpty(String new_id) {
        if (new_id.isEmpty()) {
            return "a";
        }

        return new_id;
    }

    private String reduceNotPermitDot(String new_id) {
        if (new_id.startsWith(PERMIT_DOT + "")) {
            new_id = new_id.substring(1);
        }

        if (new_id.endsWith(PERMIT_DOT + "")) {
            return new_id.substring(0, new_id.length() - 1);
        }

        return new_id;
    }

    private String reduceDot(String new_id) {
        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }

        return new_id;
    }

    private String removeNotPermittedSymbol(String new_id) {
        StringBuilder sb = new StringBuilder();
        char[] chars = new_id.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if ('a' <= chars[i] && chars[i] <= 'z') {
                sb.append(chars[i]);
                continue;
            }

            if ('0' <= chars[i] && chars[i] <= '9') {
                sb.append(chars[i]);
                continue;
            }

            if (chars[i] == PERMIT_DOT || chars[i] == PERMIT_HYPHEN || chars[i] == PERMIT_UNDER_BAR) {
                sb.append(chars[i]);
                continue;
            }
        }

        return sb.toString();
    }

    private String changeLargeAlphabet(String new_id) {
        return new_id.toLowerCase();
    }

    private boolean isValidId(String id) {
        int idLength = id.length();

        if (idLength < ID_MIN_LENGTH || idLength > ID_MAX_LENGTH) { //길이 제한 어기면 false
            return false;
        }

        if (id.startsWith(PERMIT_DOT + "") || id.endsWith(PERMIT_DOT + "")) {
            return false;
        }

        char[] chars = id.toCharArray();
        for (int i = 0; i < idLength; i++) {
            if ('a' <= chars[i] && chars[i] <= 'z') {
                continue;
            }

            if ('0' <= chars[i] && chars[i] <= '9') {
                continue;
            }

            if (chars[i] == PERMIT_DOT || chars[i] == PERMIT_UNDER_BAR || chars[i] == PERMIT_HYPHEN) {
                continue;
            }

            return false;
        }
        return true;
    }
}
