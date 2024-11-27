package mk.ukim.finki.lab1b.model;

import lombok.Data;

import java.util.Random;

@Data
public class Artists {
    Long id;
    String firstName;
    String lastName;
    String bio;

    public Artists(Long id, String firstName, String lastName, String bio) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
    }
}
