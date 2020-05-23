package com.example.zf.repositories;

import com.example.zf.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {

    boolean existsByFirstNameIgnoreCaseAndSecondNameIgnoreCase(String firstName, String secondName);
    Optional<Actor> findByFirstNameIgnoreCaseAndSecondNameIgnoreCase(String firstName, String secondName);
    Optional<List<Actor>> findAllByFirstNameContainingIgnoreCaseOrSecondNameContainingIgnoreCase(String firstName,String secondName);
}
