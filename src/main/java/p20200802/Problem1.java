package p20200802;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 프로그래머스 고득전Kit 해시 --> 베스트앨범
public class Problem1 {
    public int[] solution(String[] genres, int[] plays) {
        int genresLen = genres.length;
        List<Music> musics = IntStream.range(0, genresLen)
                .boxed()
                .map(index -> new Music(genres[index], plays[index], index))
                .collect(Collectors.toList());

        Map<String, Integer> playByGenre = musics.stream()
                .collect(Collectors.groupingBy(Music::getGenre, Collectors.summingInt(Music::getPlay)));

        List<Integer> sortedPlayCount = sortPlays(playByGenre);

        List<String> rankOfGenres = rankOfGenres(playByGenre, sortedPlayCount);

        List<Integer> answer = rankPlaysByGenre(musics, rankOfGenres);

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private List<Integer> sortPlays(Map<String, Integer> playByGenre) {
        return playByGenre.values().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private List<String> rankOfGenres(Map<String, Integer> playByGenre, List<Integer> sortedPlayCount) {
        List<String> rankOfGenres = new ArrayList<>();
        for (int playCount : sortedPlayCount) {
            for (String key : playByGenre.keySet()) {
                if (playByGenre.get(key).equals(playCount)) {
                    rankOfGenres.add(key);
                }
            }
        }
        return new ArrayList<>(rankOfGenres);
    }

    private List<Integer> rankPlaysByGenre(List<Music> musics, List<String> rankOfGenres) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (String genre : rankOfGenres) {
            List<Music> collect = musics.stream()
                    .filter(music -> music.isEqualToGenre(genre))
                    .sorted((music1, music2) -> music2.play - music1.play)
                    .limit(2)
                    .collect(Collectors.toList());

            for (Music music : collect) {
                answer.add(music.getIndex());
            }
        }
        return new ArrayList<>(answer);
    }

    public class Music implements Comparable<Music> {
        private String genre;
        private int play;
        private int index;

        @Override
        public int compareTo(Music other) {
            return other.play - play;
        }

        public Music(String genre, int play, int index) {
            this.genre = genre;
            this.play = play;
            this.index = index;
        }

        public String getGenre() {
            return genre;
        }

        public int getPlay() {
            return play;
        }

        public int getIndex() {
            return index;
        }

        public boolean isEqualToGenre(String genre) {
            return this.genre.equals(genre);
        }
    }
}
