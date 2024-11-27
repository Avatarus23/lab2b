package mk.ukim.finki.lab1b.service.impl;

import mk.ukim.finki.lab1b.model.Artists;
import mk.ukim.finki.lab1b.repository.ArtistRepository;
import mk.ukim.finki.lab1b.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artists> listArtist() {
        return this.artistRepository.findAll();
    }

    @Override
    public Artists findById(Long id) {
        return this.artistRepository.findById(id).orElse(null);
    }
}
