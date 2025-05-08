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

    // Classes internas para mapeamento aninhado
    public static class Rating {
        private Double average;
        public Double getAverage() { return average; }
    }

    public static class Network {
        private String name;
        public String getName() { return name; }
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getLanguage() { return language; }
    public List<String> getGenres() { return genres; }
    public Double getRating() { return rating != null ? rating.getAverage() : null; }
    public String getStatus() { return status; }
    public String getPremiered() { return premiered; }
    public String getEnded() { return ended; }
    public String getNetworkName() { 
        return network != null ? network.getName() : "Desconhecido"; 
    }
    public String getSummary() { return summary; }
}