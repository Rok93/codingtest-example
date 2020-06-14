package p20200523;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem3 {
    public int[] solution(int total_sp, int[][] skills) {
        int[] skillArr = Arrays.stream(skills)
                .flatMapToInt(arr -> Arrays.stream(arr))
                .distinct()
                .sorted()
//                .mapToObj(number -> new Skill(number))
                .toArray();

        Skill[] skillArray = new Skill[skillArr.length + 1];
        int skillArrayLen = skillArray.length;
        for (int i = 0; i < skillArrayLen; i++) { //0번은 null로 설정
            skillArray[i] = new Skill(i);
        }

        for (int[] arr : skills) {
            int upperSkill = arr[0];
            int lowerSkill = arr[1];
            skillArray[upperSkill].addLowerSkill(skillArray[lowerSkill]);
            skillArray[lowerSkill].setUpperSkill(skillArray[upperSkill]);
        }

        List<Skill> skillList = Arrays.stream(skillArray)
                .collect(Collectors.toList());
        skillList.remove(0);

        skillList.stream()
                .filter(skill -> skill.isLowestSkill())
                .forEach(skill -> {
                    if (skill.getSkillNumber() != 0) {
                        skill.setSkillPoint(1);
                    }
                });

        List<Skill> filterSkillList = getNotAssignSkills(skillList);

        while (isNotAssigned(filterSkillList)) {
            filterSkillList.stream()
                    .forEach(skill -> {

                        if (skill.getLowerSkills().stream()
                                .anyMatch(Problem3::isNotRightSkillPoint)) {
                            System.out.println("아직!!...");
                        } else {
                            skill.setSkillPoint(skill.lowerSkills.stream()
                                    .mapToInt(Skill::getSkillPoint)
                                    .sum());
                        }
                    });
            filterSkillList = getNotAssignSkills(skillList);
        }

        int[] answer = new int[skillList.size()];

        int len = answer.length;
        for (int i = 0; i < len; i++) {
            answer[i] = skillList.get(i).skillPoint;
        }

        int sum = Arrays.stream(answer)
                .sum();
        int skillPoint = total_sp / sum;

        for (int i = 0; i < len; i++) {
            answer[i] *= skillPoint;
        }
        return answer;
    }

    private List<Skill> getNotAssignSkills(List<Skill> skillList) {
        return skillList.stream()
                .filter(skill -> skill.getSkillPoint() == 0)
                .collect(Collectors.toList());
    }

    private boolean isNotAssigned(List<Skill> skillList) { //하나라도 배치 안됐으면!
        return skillList.stream()
                .anyMatch(Problem3::isNotRightSkillPoint);
    }

    private static boolean isNotRightSkillPoint(Skill skill) {
        return skill.getSkillPoint() == 0;
    }

    public class Skill {
        private final int skillNumber;
        private int skillPoint;
        private Skill upperSkill;
        private List<Skill> lowerSkills;

        public Skill(int skillNumber) {
            this.skillNumber = skillNumber;
            lowerSkills = new ArrayList<>();
        }

        public boolean isHighestSkill() {
            return upperSkill == null;
        }

        public void setUpperSkill(Skill upperSkill) {
            this.upperSkill = upperSkill;
        }

        public Skill getUpperSkill() {
            return upperSkill;
        }

        public int getSkillPoint() {
//            if (lowerSkills.isEmpty()) {
            return skillPoint;
//            }
//            return lowerSkills.stream()
//                    .mapToInt(Skill::getSkillPoint)
//                    .sum();
        }

        public void setSkillPoint(int skillPoint) {
            this.skillPoint = skillPoint;
        }

        public List<Skill> getLowerSkills() {
            return lowerSkills;
        }

        public void addLowerSkill(Skill lowerSkill) {
            lowerSkills.add(lowerSkill);
        }

        public boolean isLowestSkill() {
            return getLowerSkills().isEmpty();
        }

        public int getSkillNumber() {
            return skillNumber;
        }
    }
}
