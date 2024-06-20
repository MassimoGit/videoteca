package com.corso.videoteca.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Entity
@ToString
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)  //Validazione a livello di app
    @Column(name = "director") // IL DB
    private String director;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "published")
    private LocalDate published;

    @Size(max = 255,min = 2)  //Validazione a livello di app
    @Column(name = "title", nullable = false)  // IL DB
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;


    public String getIsoPublished() {

        if(this.published == null)
            return "";
        return this.published.format(DateTimeFormatter.ISO_DATE);
    }


}