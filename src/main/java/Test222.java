import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test222 {
    public static void main(String[] args) {
        System.out.println("123".chars()
                .noneMatch(numberCharacter -> numberCharacter <= '0' || numberCharacter > '9'));

        String str = "123456";

        List<Integer> arr = Arrays.stream(str.split(""))
                .map(Integer::new)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(arr);
    }
}
