package com.cinelume.view;

import com.cinelume.model.Serie;
import com.cinelume.util.InputUtils;
import java.util.List;

public class SerieView {
    public void mostrarResultados(List<Serie> series) {
        if (series.isEmpty()) {
            System.out.println("\nNenhuma série encontrada!");
            return;
        }

        System.out.println("\n--- RESULTADOS ---");
        for (int i = 0; i < series.size(); i++) {
            Serie serie = series.get(i);
            System.out.printf("%d. %s (%s) ★ %.1f\n",
                i + 1,
                serie.getName(),
                serie.getPremiered() != null ? serie.getPremiered().substring(0, 4) : "Ano desconhecido",
                serie.getRating() != null ? serie.getRating() : 0.0);
        }
    }
}