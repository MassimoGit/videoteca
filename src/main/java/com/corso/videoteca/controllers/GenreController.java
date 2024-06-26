package com.corso.videoteca.controllers;

import com.corso.videoteca.entities.Genre;
import com.corso.videoteca.exceptions.NotFoundException;
import com.corso.videoteca.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/genre/")
@Controller
public class GenreController {
   @Autowired
    private GenreRepository gr;

   @GetMapping("")
   public String index(Model model) {
        model.addAttribute("genres", gr.findAllByOrderByName());
        return "genre/index";
    }

    @GetMapping("create")
    public String create(Model model) {
       model.addAttribute("form", new Genre());
       return "genre/create";
    }

    @PostMapping("create")
    public String create(Genre genre) {
       gr.save(genre);
       return "redirect:/genre/";
    }

    @GetMapping("update/{id}")
    public String edit(@PathVariable long id, Model model) {
       model.addAttribute("form", gr.findById(id).get());
       return "genre/update";
    }

    @PostMapping("update/{id}")
    public String store(@PathVariable Long id, Genre genre) {
        gr.save(genre);
        return "redirect:/genre/";
    }

}
