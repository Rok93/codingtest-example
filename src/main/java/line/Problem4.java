//package line;
//
//import java.util.*;
//
//public class Problem4 {
//    public String[][] solution(String[][] snapshots, String[][] transactions) {
//        // transaction 중복 제거
//        List<String[]> distinctedTransactions = new ArrayList<>(List.of(transactions));
//
//        for (int i = 0; i < distinctedTransactions.size() - 1; i++) {
//            for (int j = i + 1; j < distinctedTransactions.size(); j++) {
//                if (Arrays.equals(distinctedTransactions.get(i), distinctedTransactions.get(j))) {
//                    distinctedTransactions.remove(j);
//                    j--;
//                }
//            }
//        }
//
//        Map<String, Integer> accounts = new HashMap<>();
//        for (int i = 0; i < snapshots.length; i++) {
//            String[] accountInfo = snapshots[i]; // [0]: ID, [1]: 잔고
//            accounts.put(accountInfo[0], Integer.parseInt(accountInfo[1]));
//        }
//
//        for (int i = 0; i < distinctedTransactions.size(); i++) {
//            String[] transactionInfo = distinctedTransactions.get(i);
//            String id = transactionInfo[0]; //id
//            String type = transactionInfo[1]; //트랜잭션 종류
//            String accountName = transactionInfo[2]; // 계좌이름
//            String money = transactionInfo[3].replace(",", "");
//
//            // 계좌번호가 이미 있을 때
//            if (accounts.containsKey(accountName)) {
//                if (type.equals("SAVE")) {
//                    accounts.put(accountName, (accounts.get(accountName) + Integer.parseInt(money)));
//                    continue;
//                }
//
//                if (type.equals("WITHDRAW")) {
//                    accounts.put(accountName, (accounts.get(accountName) - Integer.parseInt(money)));
//                    continue;
//                }
//            }
//
//            //계좌 없을 때 (잔액 - 없으니까 무조건 SAVE 조건!)
//            if (type.equals("SAVE")) {
//                accounts.put(accountName, Integer.parseInt(money));
//            }
//        }
//
//        TreeMap<String, Integer> tm = new TreeMap<>(accounts);
//
//        Iterator<String> iteratorKey = tm.keySet().iterator();
//
//        String[][] answer = new String[tm.size()][2];
//        int cnt = 0;
//        while (iteratorKey.hasNext()) {
//            String key = iteratorKey.next();
//            answer[cnt][0] = key;
//            answer[cnt][1] = String.valueOf(tm.get(key));
//            cnt++;
//        }
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        String[][] transactions = {
//                {"1", "SAVE", "ACCOUNT2", "100"},
//                {"2", "WITHDRAW", "ACCOUNT1", "50"},
//                {"1", "SAVE", "ACCOUNT2", "100"},
//                {"4", "SAVE", "ACCOUNT3", "500"},
//                {"3", "WITHDRAW", "ACCOUNT2", "30"}
//        };
//
//        List<String[]> list = new ArrayList<>(List.of(transactions));
//
//        for (int i = 0; i < list.size() - 1; i++) {
//            for (int j = i + 1; j < list.size(); j++) {
//                if (Arrays.equals(list.get(i), list.get(j))) {
//                    System.out.println("실행중?");
//                    list.remove(j);
//                    j--;
//                }
//            }
//        }
//
//        list.stream()
//                .forEach(a -> {
//                    Arrays.stream(a)
//                            .forEach(b -> System.out.print(b + ", "));
//                    System.out.println();
//                });
//
//
//    }
//}
