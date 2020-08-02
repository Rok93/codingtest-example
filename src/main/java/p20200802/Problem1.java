package p20200802;

import java.util.*;
import java.util.stream.Collectors;

// 프로그래머스 고득전Kit 해시 --> 베스트앨범
public class Problem1 {
    public int[] solution(String[] genres, int[] plays) {
        int genresLen = genres.length;
        List<Music> musics = new ArrayList<>();
        for (int i = 0; i < genresLen; i++) {
            String genre = genres[i];
            int play = plays[i];
            musics.add(new Music(genre, play, i));
        }

        Map<String, Integer> playByGenre = musics.stream()
                .collect(Collectors.groupingBy(Music::getGenre, Collectors.summingInt(Music::getPlay)));

        List<Integer> sortedPlayCount = playByGenre.values().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        List<String> rankOfGenres = new ArrayList<>();
        for (int playCount : sortedPlayCount) {
            for (String key : playByGenre.keySet()) {
                if (playByGenre.get(key).equals(playCount)) {
                    rankOfGenres.add(key);
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (String genre : rankOfGenres) {
            List<Music> collect = musics.stream()
                    .filter(music -> music.isEqualToGenre(genre))
                    .sorted((music1, music2) -> {
                        int music1Index = music1.getIndex();
                        int music2Index = music2.getIndex();

                        if (music1Index < music2Index)
                            return 1;

                        if (music1Index > music2Index) {
                            return -1;
                        }

                        return 0;
                    })
                    .limit(2)
                    .collect(Collectors.toList());

            for (Music music : collect) {
                answer.add(music.getIndex());
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public class Music implements Comparable {
        private String genre;
        private int play;
        private int index;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Music music = (Music) o;
            return play == music.play &&
                    Objects.equals(genre, music.genre);
        }

        @Override
        public int hashCode() {
            return Objects.hash(genre, play, index);
        }

        @Override
        public int compareTo(Object o) {
            Music music = (Music) o;

            if (this.play < music.play) {
                return 1;
            }

            if (this.play > music.play) {
                return -1;
            }

            return 0;
        }
    }
}
