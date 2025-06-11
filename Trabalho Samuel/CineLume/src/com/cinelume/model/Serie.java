package com.cinelume.model;

import java.util.List;

public class Serie {
    private int id;
    private String name;
    private String language;
    private List<String> genres;
    private Rating rating;
    private String status;
    private String premiered;
    private String ended;
    private Network network;
    private String summary;

    public static class Rating {
        private Double average;
        public Double getAverage() { return average; }
    }

    public static class Network {
        private String name;
        public String getName() { return name; }
    }

    // Getters seguros
    public int getId() { return id; }
    public String getName() { return name != null ? name : "Sem nome"; }
    public String getLanguage() { return language != null ? language : "Idioma desconhecido"; }
    public List<String> getGenres() { return genres != null ? genres : List.of(); }
    public Double getRating() { return rating != null && rating.getAverage() != null ? rating.getAverage() : 0.0; }
    public String getStatus() { return status != null ? status : "Status desconhecido"; }
    public String getPremiered() { return premiered != null ? premiered : "Data desconhecida"; }
    public String getEnded() { return ended != null ? ended : "Em exibição"; }
    public String getNetworkName() { return network != null ? network.getName() : "Desconhecido"; }
    public String getSummary() { return summary != null ? summary : "Sem descrição disponível."; }

    // Método para exibição formatada
    public String getInfoFormatada() {
        return String.format("%s (⭐ %.1f) - %s | %s | %s",
            getName(),
            getRating(),
            getLanguage(),
            getPremiered().substring(0, 4), // Mostra apenas o ano
            getStatus());
    }
}