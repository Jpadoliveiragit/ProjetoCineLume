package com.cinelume.controller;

import com.cinelume.model.Serie;
import com.cinelume.util.ApiClient;
import java.util.List;

public class SerieController {
    public List<Serie> buscarSeries(String termo) {
        try {
            return ApiClient.buscarSeries(termo);
        } catch (Exception e) {
            System.out.println("Erro na busca: " + e.getMessage());
            return List.of();
        }
    }
}