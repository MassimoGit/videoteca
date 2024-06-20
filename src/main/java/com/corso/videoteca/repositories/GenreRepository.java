package com.corso.videoteca.repositories;

import com.corso.videoteca.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface GenreRepository extends JpaRepository<Genre, Long> {



    public Set<Genre> findAllByOrderByName();
}