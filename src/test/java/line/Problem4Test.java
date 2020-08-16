//package line;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class Problem4Test {
//
//    Problem4 sol = new Problem4();
//
//    @Test
//    public void 테스트하다() {
//
//        String[][] snapshots = {
//                {"ACCOUNT1", "100"},
//                {"ACCOUNT2", "150"}
//        };
//
//        String[][] transactions = {
//                {"1", "SAVE", "ACCOUNT2", "100"},
//                {"2", "WITHDRAW", "ACCOUNT1", "50"},
//                {"1", "SAVE", "ACCOUNT2", "100"},
//                {"4", "SAVE", "ACCOUNT3", "500"},
//                {"3", "WITHDRAW", "ACCOUNT2", "30"}
//        };
//
//        String[][] result = {
//                {"ACCOUNT1", "50"},
//                {"ACCOUNT2", "220"},
//                {"ACCOUNT3", "500"}
//        };
//
//        assertThat(result).isEqualTo(sol.solution(snapshots, transactions));
//    }
//}