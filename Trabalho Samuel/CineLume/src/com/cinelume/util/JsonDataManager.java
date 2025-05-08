package com.cinelume.util;

import com.cinelume.model.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonDataManager {
    private static final Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .create();

    public static void salvarUsuario(String arquivo, Usuario usuario) throws IOException {
        try (FileWriter writer = new FileWriter(arquivo)) {
            gson.toJson(usuario, writer);
        }
    }

    public static Usuario carregarUsuario(String arquivo) throws IOException {
        if (!Files.exists(Paths.get(arquivo))) {
            return null;
        }
        String json = new String(Files.readAllBytes(Paths.get(arquivo)));
        return gson.fromJson(json, Usuario.class);
    }
}