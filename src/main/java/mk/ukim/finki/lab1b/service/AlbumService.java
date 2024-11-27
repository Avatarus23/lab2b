package mk.ukim.finki.lab1b.service;

import mk.ukim.finki.lab1b.model.Album;

import java.util.List;

public interface AlbumService {
    List<Album> findAll();
    Album findById(Long id);
}
