
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;




public class Main {

    public static void main(String[] args) {
        // reduce ( начальное значение ( накопительная переменная, новый элеменит потока )
        int resoult = Stream.of(1, 2, 3, 4, 5).reduce(0, (accumulator, streamElement) -> accumulator + streamElement);
        System.out.println(resoult);

        //------------------------------------------------------------------------------------------------------------------

        List<Track> trackList = Arrays.asList( new Track("Return Of The Warlord", 319, 1),
                                        new Track("I Surrender", 245, 2),
                                        new Track("Mr. Crowley", 295, 1),
                                        new Track("Test", 245, 1));
         // пример нахождения минимального значения , по разным полям
        Track shortestTrack = trackList.stream().min(Comparator.comparing(Track::getLength).thenComparing(Track::getValue)).get();
        System.out.println(shortestTrack);

        //------------------------------------------------------------------------------------------------------------------

        List<Album> albums = Arrays.asList(new Album("First Album", Arrays.asList(new Track("Song 1", 300 , 1),
                                                                           new Track("Song 2", 240 ,2))),
                                    new Album("Second Album", Arrays.asList(new Track("Song from second album", 288, 1),
                                                                           new Track("Song from second album", 245, 2))));

        // пример использования flatMap , из каждого элеманта получаем несколько объектов и из них делаем новый поток
        List<String> trackNames = albums.stream()
                .flatMap(album -> album.getTrackList().stream())
                .map(Track::getName)
                .collect(Collectors.toList());

        System.out.println(trackNames);

        //------------------------------------------------------------------------------------------------------------------

        // нахождение количества повторяюзихся строк в массиве
        Map<String, Long> stringsCount = Stream.of("a", "a", "b", "c").collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        //------------------------------------------------------------------------------------------------------------------

        // нахождения максимальной длины строки
        int maxStringLength = Stream.of("aab", "abcd", "b", "cc").max(Comparator.comparing(String::length)).get().length();

        //------------------------------------------------------------------------------------------------------------------

        // распараллеливание выполнения задач в цикле;
        IntStream.range(0,100).parallel().forEach(x -> doSomeWork(x) );

    }



    public static Map<Artist, List<Album>> groupAlbumsByArtist(List<Album> albums) {
       // группирока альбомов по артистам
       return albums.stream().collect(Collectors.groupingBy(Album::getArtist));
    }

    public static Map<Artist, List<String>> groupAlbums_ByArtist(List<Album> albums) {
        // группирока названий альбомов по артистам
        return albums.stream()
                .collect(Collectors.groupingBy(Album::getArtist, Collectors.mapping(Album::getName, Collectors.toList())));
    }




    private static void doSomeWork(int x) {

    }

}
