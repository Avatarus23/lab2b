package mk.ukim.finki.lab1b.service.impl;

import mk.ukim.finki.lab1b.model.Artists;
import mk.ukim.finki.lab1b.model.Song;
import mk.ukim.finki.lab1b.repository.SongRepository;
import mk.ukim.finki.lab1b.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    //pravime da zavisi od SongRepository
    private final SongRepository songRepository;
    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artists addArtistToSong(Artists artist, Song song){
        if(song.getPerformers().contains(artist)) {
            throw new RuntimeException("Song already has performer " + artist);
        }
        return songRepository.addArtistToSong(artist, song);
    }

    @Override
    public Song findByTrackId(String trackId) {
        if (trackId == null || trackId.isEmpty()) {
            throw new IllegalArgumentException("Track ID cannot be null or empty");
        }
        return songRepository.findByTrackId(trackId);
    }

    @Override
    public List<Song> searchByName(String name) {
        return songRepository.searchByName(name);
    }

    @Override
    public Object searchByStr(String search) {
        return songRepository.searchByName(search);
    }
}
