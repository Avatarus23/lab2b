package mk.ukim.finki.lab1b.bootstrap;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletException;
import mk.ukim.finki.lab1b.model.Album;
import mk.ukim.finki.lab1b.model.Artists;
import mk.ukim.finki.lab1b.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artists> performers  = new ArrayList<>();

    public static List<Song> songs  = new ArrayList<>();

    public static List<Album> albums=new ArrayList<>();


    @PostConstruct
    public void init() throws ServletException {
        performers.add(new Artists(222137L, "Teo", "Eftimov", "Pop"));
        performers.add(new Artists(222001L, "Martin", "Grombanovski", "Rock"));
        performers.add(new Artists(222002L, "Sofija", "Ackovska", "Punk"));
        performers.add(new Artists(222003L, "Pavel", "Vasilevski", "Metal"));
        performers.add(new Artists(222004L, "Mishko", "Mishkovski", "Rap"));


        Album a1 = new Album("Abbey Road", "Rock", "1969");
        Album a2 = new Album("Hotel California", "Rock", "1976");
        Album a3 = new Album("Rumours", "Soft Rock", "1977");
        Album a4 = new Album("Random Access Memories", "Electronic", "2013");
        Album a5 = new Album("Goodbye Yellow Brick Road", "Pop", "1973");

        albums.add(a1);
        albums.add(a2);
        albums.add(a3);
        albums.add(a4);
        albums.add(a5);


        songs.add(new Song("001", "Bohemian Rhapsody", "Rock", 2001));
        songs.add(new Song("002", "Thriller", "Pop", 2002));
        songs.add(new Song("003", "Ruski Rulet", "Punk", 2003));
        songs.add(new Song("004", "Jabolce i Kruvce", "Metal", 2004));
        songs.add(new Song("005", "Rap God", "Rap", 2005));
    }
}
