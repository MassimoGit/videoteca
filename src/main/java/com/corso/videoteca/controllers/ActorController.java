package com.corso.videoteca.controllers;

import com.corso.videoteca.dto.ActorDto;
import com.corso.videoteca.dto.FilmSearchDto;
import com.corso.videoteca.entities.Actor;
import com.corso.videoteca.entities.Play;
import com.corso.videoteca.repositories.ActorRepository;
import com.corso.videoteca.repositories.FilmRepository;
import com.corso.videoteca.repositories.GenreRepository;
import com.corso.videoteca.repositories.PlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;


/* 
 * Met    URL - END-POINT
 * GET   /actor/ -> index e stampa tutti i actor
 * GET   /actor/create -> mostra il form di creazione actor
 * POST	 /actor/create -> riceve i dati del form actor e crea un nuovo actor	
 * GET   /actor/update/{id}   -> Visualizza il form di aggiornamento del actor con id={id}
 * POST  /actor/update/{id}   -> RICEVE I DATI DAL FORM DI AGGIORNAMENTO E AGGIORNA IL DB
* GET/POST   /actor/delete/{id}   -> Elimina il actor con l'id = {id}
 */

@RequestMapping("/actor/")
@Controller
public class ActorController {
	
	
	@Autowired
	private ActorRepository ar;
	@Autowired
	private FilmRepository fr;
	@Autowired
	private PlayRepository pr;
	
	@GetMapping("")  
	public String index(Model model) {

		
		 Set<Actor> ls = ar.findAllByOrderByLastnameAscFirstnameAsc();
		 
		 model.addAttribute("actors",ls);
		 
		 System.out.println(ls);
		 
		 return "actor/index"; // resources/templates/actor/index.html
	}

	//URL = RequestMapping + mapping del singolo metodo
	@GetMapping("create")   // URL /actor/create
	public String create(Model model) {
		System.out.println("GET Actor CREATE");
		ActorDto actor = new ActorDto();

		model.addAttribute("form", actor);
		
		model.addAttribute("films", fr.findAllByOrderByTitle());
		return "actor/create";
	}
	
	@PostMapping("create")   // URL  /actor/create
	public String store(Model model,Actor form) {
		System.out.println("POST Actor CREATE");
		System.out.println(form);
		
		Actor creato = ar.save(form);
		
		
		System.out.println(creato);
		
		return "redirect:/actor/";  //redirect: vai a endpoint /actor/
	}
	
	@GetMapping("update/{id}")   // {id} è una path Variable
	public String edit(@PathVariable Long id, Model model) {
		
		//
	    Actor f = ar.findById(id).get();
	    model.addAttribute("form",f);
		model.addAttribute("films", fr.findAllByOrderByTitle());
		
		return "actor/update";
	}
	
	
	@PostMapping("update/{id}")
	public String update(Model model,Actor form,@PathVariable Long id ) {
		System.out.println("POST FILM UPDATE");
		System.out.println(form);
		
		form.setId(id); //IMPOSTA L'ID 
		Actor update = ar.save(form);
		System.out.println(update); 
		
		return "redirect:/actor/";  //redirect: vai a endpoint /actor/
	}
	
	@GetMapping("delete/{id}")   // {id} è una path Variable
	public String delete(@PathVariable Long id) {
		
		//
	    Actor f = ar.findById(id).get();
	    ar.delete(f);
		System.out.println("Cancellazione prima del redirect");
		return "redirect:/actor/";
	}
	
	
	@GetMapping("search")
	public String search(Model model) {
		
		/*long genre_id = 1L;
		Set<Actor> films =  ar.findByGenre_IdOrderByTitleAsc(genre_id);
		
		System.out.println(films);
		model.addAttribute("form", new FilmSearchDto());
		model.addAttribute("genres", gr.findAllByOrderByName())*/;
		
		return  "actor/search";
	}
	
	
	@PostMapping("search")
	public String findSearch(FilmSearchDto form,Model model) {
		
		/*System.out.println(form);
		
		
		if(form.getTitle() != null  && form.getTitle().length() >2 )
		{
			form.setTitle("%" +  form.getTitle()   +"%");
		}
		
		System.out.println(form);
		
		if(form.getGenre_id() != null) {
			Set<Actor> risultato = ar.findByGenre_IdAndTitleLikeIgnoreCaseOrderByTitleAsc(form.getGenre_id(),form.getTitle());
			System.out.println(risultato);
			model.addAttribute("films",risultato);
		}
		else {
			Set<Actor> risultato = ar.findByTitleLikeIgnoreCaseOrderByTitleAsc(form.getTitle());
			System.out.println(risultato);
			model.addAttribute("films",risultato);
		}*/

		return "actor/index";
	}

	@GetMapping("plays/{id}")   // {id} è una path Variable
	public String plays(@PathVariable Long id, Model model) {

		Actor actor = ar.findById(id).get();

		model.addAttribute(actor);
		Play form = new Play();

		form.setId(null);
		model.addAttribute("form", form);
		model.addAttribute("films", fr.findAllByOrderByTitle());

		return "actor/plays";
	}


	@PostMapping("plays/{id}")
	public String storePlays(Model model,Play form,@PathVariable Long id ) {
		System.out.println("POST Play");

		form.setId(null); //@todo controllare da dove arriva l'id
		Actor actor = ar.findById(id).get();
		form.setActor(actor);
		System.out.println(form);
		pr.save(form);



		return "redirect:/actor/plays/"+ form.getId();
	}

}
