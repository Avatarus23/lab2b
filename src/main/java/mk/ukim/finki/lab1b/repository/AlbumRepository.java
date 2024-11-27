package mk.ukim.finki.lab1b.repository;

import mk.ukim.finki.lab1b.bootstrap.DataHolder;
import mk.ukim.finki.lab1b.model.Album;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumRepository {
    public List<Album> findAll(){
        return DataHolder.albums;
    }
    public Album findById(Long id){
        return DataHolder.albums.stream().filter(album -> album.getId().equals(id)).findFirst().orElse(null);
    }
}
