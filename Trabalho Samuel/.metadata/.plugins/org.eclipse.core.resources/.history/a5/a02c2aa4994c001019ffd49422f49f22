package com.cinelume.view;

import com.cinelume.model.Serie;
import java.util.List;

public class SerieView {
    public void mostrarResultados(List<Serie> series) {
        if (series.isEmpty()) {
            System.out.println("\nNenhuma série encontrada!");
            return;
        }

        System.out.println("\n=== RESULTADOS ===");
        for (int i = 0; i < series.size(); i++) {
            Serie serie = series.get(i);
            System.out.printf("%d. %s (⭐ %.1f)\n", 
                i + 1, serie.getName(), serie.getRating());
        }
    }

    public void exibirDetalhesCompletos(Serie serie) {
        System.out.println("\n=== " + serie.getName().toUpperCase() + " ===");
        System.out.println("Idioma: " + serie.getLanguage());
        System.out.println("Gêneros: " + String.join(", ", serie.getGenres()));
        System.out.println("Nota: " + serie.getRating());
        System.out.println("Status: " + formatarStatus(serie.getStatus()));
        System.out.println("Estreia: " + serie.getPremiered());
        System.out.println("Emissora: " + serie.getNetworkName());
        System.out.println("\nSinopse: " + serie.getSummary());
    }

    public void mostrarLista(List<Serie> series) {
        if (series.isEmpty()) {
            System.out.println("\nLista vazia!");
            return;
        }

        System.out.println("\nItens na lista:");
        series.forEach(serie -> 
            System.out.printf("- %s (⭐ %.1f)\n", serie.getName(), serie.getRating())
        );
    }

    private String formatarStatus(String status) {
        return switch (status.toLowerCase()) {
            case "running" -> "Em exibição";
            case "ended" -> "Concluída";
            case "canceled" -> "Cancelada";
            default -> "Desconhecido";
        };
    }
}