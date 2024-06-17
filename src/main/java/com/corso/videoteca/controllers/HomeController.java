package com.corso.videoteca.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.corso.videoteca.dto.TestDto;
import com.corso.videoteca.entities.Film;

//URL DI BASE APP 127.0.0.1:8080/ -> localhost:8080/
@Controller
public class HomeController {

	//METODO GET HTTP
	@GetMapping("/")
	public String index(Model model) {
		
		System.out.println("IO SONO NELL'ENDPOINT GET DELL'INDEX");
		
		// 1 stringa è il nome che avra la variabile in THYMELEAF
		// 2 è l'oggetto che contiene realmente i valori
		model.addAttribute("form", new TestDto());  
		Film f = new Film();
		f.setTitle("Titanic");
		model.addAttribute("prova", f);
		
		return "index"; // sta cercando in resources/templates/index    con ext.html
	}
	
	//METODO POST HTTP
	@PostMapping("/test")
	public String info(Model model,TestDto form) {
		
		System.out.println("IO SONO NELL'ENDPOINT POST DELL'INDEX");
		System.out.println(form);
		
		String prova = "Grazie!";
		
		List<String> parole = new ArrayList<String>();
		parole.add("Ciao Mondo");
		parole.add("come va?");
		parole.add("tutto bene");
		
		// 1 stringa è il nome che avra la variabile in TH
		// 2 è l'oggetto che contiene realmente i valori
		
		model.addAttribute("pippo",prova);
		model.addAttribute("parole",parole);
		model.addAttribute("form", form);
		
		return "test"; //sta cercando /resources/templates/film/test.html
	}
}
