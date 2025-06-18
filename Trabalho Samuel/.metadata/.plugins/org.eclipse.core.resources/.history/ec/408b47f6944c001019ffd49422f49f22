package com.cinelume.controller;

import com.cinelume.model.Serie;
import com.cinelume.model.Usuario;
import com.cinelume.util.JsonDataManager;
import java.util.List;

public class UsuarioController {
    private Usuario usuarioAtual;
    
    /**
     * Realiza o login do usuário, carregando seus dados ou criando um novo perfil
     * @param nomeUsuario Nome do usuário para login
     * @throws IllegalArgumentException Se o nome de usuário for vazio
     */
    public void login(String nomeUsuario) {
        try {
            if (nomeUsuario == null || nomeUsuario.trim().isEmpty()) {
                throw new IllegalArgumentException("Nome de usuário não pode ser vazio");
            }
            
            this.usuarioAtual = JsonDataManager.carregarUsuario(nomeUsuario + ".json");
            if (this.usuarioAtual == null) {
                this.usuarioAtual = new Usuario(nomeUsuario);
                System.out.println("Novo usuário criado: " + nomeUsuario);
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar usuário: " + e.getMessage());
            this.usuarioAtual = new Usuario(nomeUsuario);
        }
    }
    
    /**
     * Adiciona uma série a uma lista específica do usuário
     * @param serie Série a ser adicionada
     * @param tipoLista Tipo de lista ("watchlist", "watched" ou "favorites")
     * @throws IllegalStateException Se nenhum usuário estiver logado
     * @throws IllegalArgumentException Se os parâmetros forem inválidos
     */
    public void adicionarSerieLista(Serie serie, String tipoLista) {
        verificarUsuarioLogado();
        validarParametros(serie, tipoLista);
        
        usuarioAtual.adicionarSerie(serie, tipoLista);
        salvarDados();
    }
    
    /**
     * Remove uma série de uma lista específica do usuário
     * @param serie Série a ser removida
     * @param tipoLista Tipo de lista ("watchlist", "watched" ou "favorites")
     * @throws IllegalStateException Se nenhum usuário estiver logado
     * @throws IllegalArgumentException Se os parâmetros forem inválidos ou série não encontrada
     */
    public void removerSerieLista(Serie serie, String tipoLista) {
        verificarUsuarioLogado();
        validarParametros(serie, tipoLista);
        
        if (!usuarioAtual.getLista(tipoLista).remove(serie)) {
            throw new IllegalArgumentException("Série não encontrada na lista " + tipoLista);
        }
        salvarDados();
    }
    
    /**
     * Obtém a lista de séries do usuário conforme o tipo especificado
     * @param tipoLista Tipo de lista ("watchlist", "watched" ou "favorites")
     * @return Lista de séries correspondente (cópia defensiva)
     * @throws IllegalStateException Se nenhum usuário estiver logado
     * @throws IllegalArgumentException Se o tipo de lista for inválido
     */
    public List<Serie> getListaSeries(String tipoLista) {
        verificarUsuarioLogado();
        validarTipoLista(tipoLista);
        return List.copyOf(usuarioAtual.getLista(tipoLista)); // Retorna cópia imutável
    }
    
    /**
     * Salva os dados do usuário atual no arquivo JSON
     * @throws IllegalStateException Se nenhum usuário estiver logado
     */
    public void salvarDados() {
        verificarUsuarioLogado();
        try {
            JsonDataManager.salvarUsuario(
                usuarioAtual.getNome() + ".json", 
                usuarioAtual
            );
        } catch (Exception e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
            throw new RuntimeException("Falha ao salvar dados do usuário", e);
        }
    }
    
    public Usuario getUsuarioAtual() {
        return usuarioAtual;
    }
    
    // ========== MÉTODOS PRIVADOS AUXILIARES ==========
    
    private void verificarUsuarioLogado() {
        if (usuarioAtual == null) {
            throw new IllegalStateException("Nenhum usuário logado. Faça login primeiro.");
        }
    }
    
    private void validarParametros(Serie serie, String tipoLista) {
        if (serie == null) {
            throw new IllegalArgumentException("A série não pode ser nula");
        }
        validarTipoLista(tipoLista);
    }
    
    private void validarTipoLista(String tipoLista) {
        if (tipoLista == null || tipoLista.trim().isEmpty()) {
            throw new IllegalArgumentException("Tipo de lista inválido");
        }
        
        if (!tipoLista.equalsIgnoreCase("watchlist") &&
            !tipoLista.equalsIgnoreCase("watched") &&
            !tipoLista.equalsIgnoreCase("favorites")) {
            throw new IllegalArgumentException("Tipo de lista deve ser: watchlist, watched ou favorites");
        }
    }
}