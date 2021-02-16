package etc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GroupDistributor {
    private static final int GROUP_MEMBER_SIZE = 6;

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "이창환", "고언약", "윤동회", "전상현", "문병학", "김보배", "정다은", "한석현", "최문경", "최상현", "김규민", "전성환"
        );

        Collections.shuffle(names);

        int groupNumber = names.size() / GROUP_MEMBER_SIZE;
        for (int i = 0; i < groupNumber; i++) {
            String groupMember = names.subList(i * GROUP_MEMBER_SIZE, (i + 1) * GROUP_MEMBER_SIZE).stream()
                    .map(name -> name + "님")
                    .collect(Collectors.joining(", "));
            System.out.println((i + 1) + "조: " + groupMember);
        }
    }
}
