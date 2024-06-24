package com.corso.videoteca.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class ActorDto {
    private String firstname;
    private String lastname;
    private LocalDate dob;

    private Set<PlayDto> plays = new LinkedHashSet<>();

}
