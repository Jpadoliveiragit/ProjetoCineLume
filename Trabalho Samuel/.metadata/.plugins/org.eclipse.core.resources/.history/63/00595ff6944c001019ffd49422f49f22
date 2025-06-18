package com.cinelume.util;

import com.cinelume.model.Serie;
import java.util.Comparator;

public class SeriesComparators {
    public static Comparator<Serie> porNome() {
        return Comparator.comparing(Serie::getName);
    }
    
    public static Comparator<Serie> porNota() {
        return Comparator.comparingDouble(Serie::getRating).reversed();
    }
    
    public static Comparator<Serie> porStatus() {
        return (s1, s2) -> {
            String status1 = s1.getStatus().equals("Running") ? "A" : "B";
            String status2 = s2.getStatus().equals("Running") ? "A" : "B";
            return status1.compareTo(status2);
        };
    }
    
    public static Comparator<Serie> porDataEstreia() {
        return Comparator.comparing(s -> s.getPremiered() != null ? s.getPremiered() : "9999-99-99");
    }
}