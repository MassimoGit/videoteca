package com.corso.videoteca.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.corso.videoteca.entities.Film;

//URL DI BASE APP 127.0.0.1:8080/ -> localhost:8080/
@Controller
public class HomeController {

	//METODO GET HTTP
	@GetMapping("/")
	public String index(Model model) {
		
		System.out.println("IO SONO NELL'ENDPOINT GET DELL'INDEX");

		
		return "index"; // sta cercando in resources/templates/index    con ext.html
	}
	

}
