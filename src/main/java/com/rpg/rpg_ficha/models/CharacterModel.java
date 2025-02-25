package com.rpg.rpg_ficha.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String raca;
    private String classe;
    private int nivel;
    private int experiencia;

    private int forca;
    private int destreza;
    private int inteligencia;
    private int carisma;

    private int vida;
    private int energia;
    private int mana;
}
