package p20200802;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 프로그래머스 고득전Kit 해시 --> 베스트앨범 (모범답안)
public class Problem1_2 {

    public class Music implements Comparable<Music> {
        private String genre;
        private int play;
        private int index;

        public Music(String genre, int play, int index) {
            this.genre = genre;
            this.play = play;
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public String getGenre() {
            return genre;
        }

        public int getPlay() {
            return play;
        }

        @Override
        public int compareTo(Music other) {
            if (this.play == other.play) {
                return this.index - other.index;
            }

            return other.play - this.play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        int length = genres.length;
        Set<Map.Entry<String, List<Music>>> entries = IntStream.range(0, length)
                .mapToObj(index -> new Music(genres[index], plays[index], index))
                .collect(Collectors.groupingBy(Music::getGenre))
                .entrySet(); // 이어서 작성할 수 있지만, 이렇게 이해하기 쉽게 쪼갰음

        return entries.stream()
                .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
                .flatMap(musics -> musics.getValue().stream().sorted().limit(2))
                .mapToInt(Music::getIndex).toArray();
    }

    private int sum(List<Music> value) {
        return value.stream()
                .mapToInt(Music::getPlay)
                .sum();
    }
}
