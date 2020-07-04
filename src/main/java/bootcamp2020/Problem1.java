package bootcamp2020;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    public boolean solution(String[] name_list) {
        List<String> duplicateNameList = new ArrayList<>();

        for (String name : name_list) {
            duplicateNameList.add(name + "" + name);
        }

        int nameListLength = name_list.length;
        for (int i = 0; i < nameListLength; i++) {
            for (int j = 0; j < nameListLength; j++) {
                if (i == j) {
                    continue;
                }

                if (duplicateNameList.get(j).contains(name_list[i])) {
                    return true;
                }

            }
        }
        return false;
    }
}
