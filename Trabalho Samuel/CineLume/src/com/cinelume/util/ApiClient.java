package com.cinelume.util;

import com.cinelume.model.Serie;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

public class ApiClient {
    private static final String BASE_URL = "https://api.tvmaze.com";
    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();

    public static List<Serie> buscarSeries(String query) {
        try {
            String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8.toString());
            String url = BASE_URL + "/search/shows?q=" + encodedQuery;
            Request request = new Request.Builder()
                .url(url)
                .build();

            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful() || response.body() == null) {
                    return List.of();
                }
                
                String json = Objects.requireNonNull(response.body()).string();
                List<SearchResult> results = gson.fromJson(
                    json, 
                    new TypeToken<List<SearchResult>>(){}.getType()
                );
                
                if (results == null) {
                    return List.of();
                }

                return results.stream()
                    .map(result -> result.show)
                    .filter(Objects::nonNull)
                    .toList();
            }
        } catch (Exception e) {
            System.err.println("Erro na busca de séries: " + e.getMessage());
            return List.of();
        }
    }

    private static class SearchResult {
        Serie show;
        public SearchResult() {}
    }
}