package mk.ukim.finki.lab1b.service;

import mk.ukim.finki.lab1b.model.Artists;
import mk.ukim.finki.lab1b.model.Song;

import java.util.List;

public interface SongService {

    List<Song> listSongs();

    Artists addArtistToSong(Artists artist, Song song);

    public Song findByTrackId(String trackId);


    public List<Song> searchByName(String name);

    Object searchByStr(String search);
}
