package com.cinelume.controller;

import com.cinelume.model.Usuario;
import com.cinelume.util.JsonDataManager;

public class UsuarioController {
    private Usuario usuarioAtual;
    
    public void login(String nomeUsuario) {
        try {
            this.usuarioAtual = JsonDataManager.carregarUsuario(nomeUsuario + ".json");
            if (this.usuarioAtual == null) {
                this.usuarioAtual = new Usuario(nomeUsuario);
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar usuário: " + e.getMessage());
            this.usuarioAtual = new Usuario(nomeUsuario);
        }
    }
    
    public void salvarDados() {
        try {
            JsonDataManager.salvarUsuario(
                usuarioAtual.getNome() + ".json", 
                usuarioAtual
            );
        } catch (Exception e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }
    
    public Usuario getUsuarioAtual() {
        return usuarioAtual;
    }
}