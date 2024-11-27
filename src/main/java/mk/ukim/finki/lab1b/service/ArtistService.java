package mk.ukim.finki.lab1b.service;

import mk.ukim.finki.lab1b.model.Artists;

import java.util.List;

public interface ArtistService {
    List<Artists> listArtist();
    Artists findById(Long id);
}
