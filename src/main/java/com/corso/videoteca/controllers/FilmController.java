package com.corso.videoteca.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/*
 * GET   /film/ -> index e stampa tutti i film
 * GET   /film/create -> mostra il form di creazione film
 * POST	 /film/create -> riceve i dati del form film e crea un nuovo film	
 */

@RequestMapping("/film")
@Controller
public class FilmController {
	
	
	@GetMapping("/create")
	public String create(Model model) {
		System.out.println("GET FILM CREATE");
		return "film/create";
	}
	
	@PostMapping("/create")
	public String store(Model model) {
		System.out.println("POST FILM CREATE");
		
		return "/";  //da modificare con un redirect
	}

}
