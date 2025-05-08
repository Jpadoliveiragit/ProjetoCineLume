package com.cinelume.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private List<Serie> favoritos = new ArrayList<>();
    private List<Serie> assistidas = new ArrayList<>();

    public Usuario(String nome) {
        this.nome = nome;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public List<Serie> getFavoritos() { return favoritos; }
    public List<Serie> getAssistidas() { return assistidas; }
}