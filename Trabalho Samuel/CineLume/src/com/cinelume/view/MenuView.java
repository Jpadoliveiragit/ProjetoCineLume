package com.cinelume.view;

import com.cinelume.controller.SerieController;
import com.cinelume.controller.UsuarioController;
import com.cinelume.model.Usuario;
import com.cinelume.util.InputUtils;

public class MenuView {
    private final UsuarioController usuarioController;
    private final SerieController serieController;

    // Construtor
    public MenuView(UsuarioController usuarioController, SerieController serieController) {
        this.usuarioController = usuarioController;
        this.serieController = serieController;
    }

    public void exibirBoasVindas() {
        System.out.println("=============================");
        System.out.println("   CINELUME - GERENCIADOR");
        System.out.println("=============================");
    }

    public void realizarLogin() {
        String nome = InputUtils.lerString("\nDigite seu nome: ");
        usuarioController.login(nome);
        System.out.println("\nBem-vindo, " + nome + "!");
    }

    public void exibirMenuPrincipal() {
        int opcao;
        do {
            System.out.println("\n======== MENU ========");
            System.out.println("1. Buscar Series");
            System.out.println("2. Minhas Listas");
            System.out.println("3. Sair");
            
            opcao = InputUtils.lerInt("Escolha uma opcao: ", 1, 3);
            
            switch (opcao) {
                case 1:
                    buscarSeries();
                    break;
                case 2:
                    exibirListas();
                    break;
            }
        } while (opcao != 3);
    }

    private void buscarSeries() {
        String termo = InputUtils.lerString("\nDigite o nome da serie: ");
        var resultados = serieController.buscarSeries(termo);
        
        if (resultados.isEmpty()) {
            System.out.println("Nenhum resultado encontrado.");
        } else {
            System.out.println("\nRESULTADOS:");
            for (int i = 0; i < resultados.size(); i++) {
                var serie = resultados.get(i);
                System.out.printf("%d. %s (%s) - Nota: %.1f\n",
                    i + 1,
                    serie.getName(),
                    serie.getPremiered() != null ? serie.getPremiered().substring(0, 4) : "Ano desconhecido",
                    serie.getRating() != null ? serie.getRating() : 0.0);
            }
        }
    }

    private void exibirListas() {
        Usuario usuario = usuarioController.getUsuarioAtual();
        System.out.println("\nMINHAS LISTAS:");
        System.out.println("- Favoritos: " + usuario.getFavoritos().size() + " itens");
        System.out.println("- Assistidas: " + usuario.getAssistidas().size() + " itens");
    }
}