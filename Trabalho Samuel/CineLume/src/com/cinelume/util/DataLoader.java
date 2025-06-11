package com.cinelume.util;

import com.cinelume.model.Usuario;
import com.google.gson.Gson;
import java.io.InputStreamReader;

public class DataLoader {
    public static Usuario carregarUsuarioTeste() {
        try (var reader = new InputStreamReader(
            DataLoader.class.getResourceAsStream("/data/usuarios.json"))) {
            
            return new Gson().fromJson(reader, Usuario[].class)[0];
        } catch (Exception e) {
            System.err.println("Erro ao carregar usuário teste: " + e.getMessage());
            return criarUsuarioPadrao();
        }
    }

    private static Usuario criarUsuarioPadrao() {
        Usuario usuario = new Usuario("UsuarioTeste");
        // Adicione séries de exemplo se necessário
        return usuario;
    }
}