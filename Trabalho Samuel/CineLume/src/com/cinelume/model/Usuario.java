package com.cinelume.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private List<Serie> favoritos = new ArrayList<>();
    private List<Serie> assistidas = new ArrayList<>();
    private List<Serie> paraAssistir = new ArrayList<>();

    public Usuario(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do usuário não pode ser vazio");
        }
        this.nome = nome;
    }

    /**
     * Adiciona uma série à lista especificada
     * @param serie Série a ser adicionada
     * @param tipoLista "favoritos", "assistidas" ou "paraAssistir" (ou equivalentes em inglês)
     * @throws IllegalArgumentException Se a série for nula ou o tipo de lista for inválido
     */
    public void adicionarSerie(Serie serie, String tipoLista) {
        if (serie == null) {
            throw new IllegalArgumentException("Série não pode ser nula");
        }
        getLista(tipoLista).add(serie);
    }

    /**
     * Obtém a lista correspondente ao tipo especificado
     * @param tipo Tipo de lista ("favoritos", "assistidas" ou "paraAssistir")
     * @return Lista de séries correspondente
     * @throws IllegalArgumentException Se o tipo for inválido
     */
    public List<Serie> getLista(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "favorites", "favoritos" -> favoritos;
            case "watched", "assistidas" -> assistidas;
            case "watchlist", "paraassistir" -> paraAssistir;
            default -> throw new IllegalArgumentException("Tipo de lista inválido: " + tipo);
        };
    }

    // Getters específicos para cada lista
    public List<Serie> getFavoritos() {
        return new ArrayList<>(favoritos); // Retorna cópia para evitar modificações externas
    }

    public List<Serie> getAssistidas() {
        return new ArrayList<>(assistidas);
    }

    public List<Serie> getParaAssistir() {
        return new ArrayList<>(paraAssistir);
    }

    // Getters e Setters
    public String getNome() { 
        return nome; 
    }
    
    public void setNome(String nome) { 
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do usuário não pode ser vazio");
        }
        this.nome = nome; 
    }
}