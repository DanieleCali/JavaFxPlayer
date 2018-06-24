package com.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Song {

    private String nome;
    private String percorso;
    private String durata;
}
