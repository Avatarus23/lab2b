package mk.ukim.finki.lab1b.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Song {
    private String trackId;
    private String title;
    private String genre;
    private int releaseYear;
    private List<Artists> performers;
    private Long id;
    private Album album;

    public Song(String trackId, String title, String genre, int releaseYear, List<Artists> performers, Long id, Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
        this.id = id;
        this.album = album;
    }

    public Song(String trackId, String title, String genre, int releaseYear) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        performers=new ArrayList<Artists>();
        this.id= (long) (Math.random()*1000);
        this.album=null;
    }

    public Song(String trackId, String title, String genre, int releaseYear,Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        performers=new ArrayList<Artists>();
        this.id= (long) (Math.random()*1000);
        this.album=album;
    }

    public Artists addPerformer(Artists artist) {
        this.performers.add(artist);
        return artist;
    }

}
