package com.corso.videoteca.repositories;

import com.corso.videoteca.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}