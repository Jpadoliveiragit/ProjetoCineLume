package com.cinelume.util;

import com.cinelume.model.Serie;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class ApiClient {
    private static final String BASE_URL = "https://api.tvmaze.com";
    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();

    public static List<Serie> buscarSeries(String query) {
        List<Serie> series = new ArrayList<>();
        try {
            String encodedQuery = URLEncoder.encode(query, "UTF-8");
            String url = BASE_URL + "/search/shows?q=" + encodedQuery;
            
            Request request = new Request.Builder()
                .url(url)
                .build();

            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) {
                    System.err.println("Erro na API: " + response.code());
                    return series;
                }

                String json = response.body().string();
                TypeToken<List<SearchResult>> typeToken = new TypeToken<>() {};
                List<SearchResult> resultados = gson.fromJson(json, typeToken.getType());

                for (SearchResult result : resultados) {
                    if (result.show != null) {
                        series.add(result.show);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Erro na busca: " + e.getMessage());
        }
        return series;
    }

    // Classe para mapear o resultado da busca
    private static class SearchResult {
        Serie show;
    }
}