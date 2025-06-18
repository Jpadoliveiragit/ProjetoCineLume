package com.cinelume.controller;

import com.cinelume.model.Serie;
import com.cinelume.util.ApiClient;
import java.util.List;
import java.util.stream.Collectors;

public class SerieController {
    
    public SerieController() {
        // Construtor padrão
    }

    /**
     * Busca séries na API externa
     * @param termo Termo de busca (não pode ser vazio)
     * @return Lista de séries encontradas
     * @throws IllegalArgumentException Se o termo for vazio
     */
    public List<Serie> buscarSeries(String termo) {
        if (termo == null || termo.trim().isEmpty()) {
            throw new IllegalArgumentException("Termo de busca não pode ser vazio");
        }
        
        List<Serie> resultados = ApiClient.buscarSeries(termo);
        
        // Filtra séries sem nome (caso raro da API retornar)
        return resultados.stream()
            .filter(serie -> serie.getName() != null && !serie.getName().isEmpty())
            .collect(Collectors.toList());
    }
    
    /**
     * Filtra séries por idioma
     * @param series Lista de séries para filtrar
     * @param language Idioma desejado (ex: "English")
     * @return Lista filtrada
     */
    public List<Serie> filtrarPorIdioma(List<Serie> series, String language) {
        return series.stream()
            .filter(serie -> language.equalsIgnoreCase(serie.getLanguage()))
            .collect(Collectors.toList());
    }
    
    /**
     * Ordena séries por avaliação (decrescente)
     * @param series Lista para ordenar
     * @return Lista ordenada
     */
    public List<Serie> ordenarPorAvaliacao(List<Serie> series) {
        return series.stream()
            .sorted((s1, s2) -> Double.compare(s2.getRating(), s1.getRating()))
            .collect(Collectors.toList());
    }
    
    /**
     * Busca séries populares (avaliação > 7.5)
     * @param series Lista para filtrar
     * @return Lista filtrada
     */
    public List<Serie> getSeriesPopulares(List<Serie> series) {
        return series.stream()
            .filter(serie -> serie.getRating() > 7.5)
            .collect(Collectors.toList());
    }
    
    /**
     * Filtra séries por status (ex: "Running", "Ended")
     * @param series Lista para filtrar
     * @param status Status desejado
     * @return Lista filtrada
     */
    public List<Serie> filtrarPorStatus(List<Serie> series, String status) {
        return series.stream()
            .filter(serie -> status.equalsIgnoreCase(serie.getStatus()))
            .collect(Collectors.toList());
    }
}