package p20201023.NHNTest;

import netscape.javascript.JSUtil;

import java.util.Arrays;

public class Problem1 {
    private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame) {

        int groupSize = numOfAllPlayers - 1;
        People[] peoples = new People[groupSize];
        for (int i = 0; i < numOfAllPlayers - 1; i++) {
            peoples[i] = new People((char) ('B' + i), 0);
        }

        People currentTagger = new People('A', 1);
        int currentPosition = 0; // 처음 술래 위치! (+ A의 위치!)

        for (int i = 0; i < numOfGames; i++) {
            if (numOfMovesPerGame[i] > 0) { // 시계방향 진행!
                currentPosition = (currentPosition + numOfMovesPerGame[i]) % groupSize;

                if (isQuickPlayer(namesOfQuickPlayers, peoples, currentTagger, currentPosition)) {
                    currentTagger.chosenTagger();
                    continue;
                }

                People temp = currentTagger;
                currentTagger = peoples[currentPosition];
                peoples[currentPosition] = temp;
                currentTagger.chosenTagger();
                continue;
            }

            // 반시계방향 진행!
            System.out.println("currentPosition: " + currentPosition + " numOfMovesPerGame: " + numOfMovesPerGame[i]);
            currentPosition = (currentPosition + numOfMovesPerGame[i] + groupSize) % groupSize;
            System.out.println("반시계방향으로 간 위치: " + currentPosition);

            if (isQuickPlayer(namesOfQuickPlayers, peoples, currentTagger, currentPosition)) {
                currentTagger.chosenTagger();
                continue;
            }

            People temp = currentTagger;
            currentTagger = peoples[currentPosition];
            peoples[currentPosition] = temp;
            currentTagger.chosenTagger();
        }

        Arrays.stream(peoples)
                .forEach(people -> System.out.println(people.getName() + " " + people.getTaggerNumber()));
        System.out.println(currentTagger.getName() + " " + currentTagger.getTaggerNumber());
    }

    private static boolean isQuickPlayer(char[] namesOfQuickPlayers, People[] peoples, People currentTagger, int currentPosition) {
        for (char QuickPlayerName : namesOfQuickPlayers) {
            if (QuickPlayerName == peoples[currentPosition].getName()) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        int numOfAllPlayers = 6;
//        int numOfQuickPlayers = 2;
//        char[] namesOfQuickPlayers = {'B', 'C'};
//        int numOfGames = 2;
//        int[] numOfMovesPerGame = {3, -2};
        int numOfAllPlayers = 17;
        int numOfQuickPlayers = 5;
        char[] namesOfQuickPlayers = {'B', 'D', 'I', 'M', 'P'};
        int numOfGames = 11;
        int[] numOfMovesPerGame = {3, -4, 5, 6, -7, -8, 10, -12, -15, -20, 23};


        solution(numOfAllPlayers, numOfQuickPlayers, namesOfQuickPlayers, numOfGames, numOfMovesPerGame);

    }

    public static class People {
        private final char name;
        private int taggerNumber;

        public People(char name, int taggerNumber) {
            this.name = name;
            this.taggerNumber = taggerNumber;
        }

        public void chosenTagger() {
            taggerNumber++;
        }

        public char getName() {
            return name;
        }

        public int getTaggerNumber() {
            return taggerNumber;
        }
    }
}
