package com.corso.videoteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corso.videoteca.entities.Film;
import com.corso.videoteca.repositories.FilmRepository;


/* Met    URL - END-POINT
 * GET   /film/ -> index e stampa tutti i film
 * GET   /film/create -> mostra il form di creazione film
 * POST	 /film/create -> riceve i dati del form film e crea un nuovo film	
 */

@RequestMapping("/film")
@Controller
public class FilmController {
	
	
	@Autowired
	private FilmRepository fr;
	
	//URL = RequestMapping + mapping del singolo metodo
	@GetMapping("/create")   // URL /film/create
	public String create(Model model) {
		System.out.println("GET FILM CREATE");
		
		model.addAttribute("form", new Film());
		return "film/create";
	}
	
	@PostMapping("/create")   // URL  /film/create
	public String store(Model model,Film form) {
		System.out.println("POST FILM CREATE");
		System.out.println(form);
		
		Film creato = fr.save(form);
		
		System.out.println(creato);
		
		return "redirect:/film/create";  //redirect: vai a endpoint /film/create
	}
}
