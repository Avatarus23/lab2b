package mk.ukim.finki.lab1b.repository;

import mk.ukim.finki.lab1b.bootstrap.DataHolder;
import mk.ukim.finki.lab1b.model.Artists;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {

    //samo vrakja lista
    public List<Artists> findAll() {
        return DataHolder.performers;
    }

    //ke go vrati artistot so id ednakvo na pratenata vrednost vo parametarot
    public Optional<Artists> findById(Long id){
        return DataHolder.performers.stream().filter(a -> a.getId().equals(id)).findFirst();
    }
}
