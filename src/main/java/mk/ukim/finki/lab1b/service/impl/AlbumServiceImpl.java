package mk.ukim.finki.lab1b.service.impl;

import mk.ukim.finki.lab1b.model.Album;
import mk.ukim.finki.lab1b.repository.AlbumRepository;
import mk.ukim.finki.lab1b.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    AlbumRepository albumRepository = new AlbumRepository();

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album findById(Long id) {
        return this.albumRepository.findById(id);
    }
}
