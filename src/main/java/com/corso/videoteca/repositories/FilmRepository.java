package com.corso.videoteca.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corso.videoteca.entities.Film;
import org.springframework.lang.Nullable;

/**
 * https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
 */

public interface FilmRepository extends JpaRepository<Film, Long> {
	
	Set<Film>findAllByOrderByTitle();

	Set<Film> findByGenre_IdOrderByTitleAsc(Long id);
	
	Set<Film> findByTitleLikeIgnoreCaseOrderByTitleAsc(String title);

	Set<Film> findByGenre_IdAndTitleLikeIgnoreCaseOrderByTitleAsc(@Nullable Long id, @Nullable String title);



}
