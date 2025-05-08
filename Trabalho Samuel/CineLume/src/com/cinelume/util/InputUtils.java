package com.cinelume.util;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        String input = scanner.nextLine().trim();
        
        while(input.isEmpty()) {
            System.out.println("Erro: Campo obrigatório!");
            System.out.print(mensagem);
            input = scanner.nextLine().trim();
        }
        
        return input;
    }
    
    public static int lerInt(String mensagem, int min, int max) {
        while(true) {
            System.out.print(mensagem);
            String input = scanner.nextLine().trim();
            
            try {
                int valor = Integer.parseInt(input);
                if(valor >= min && valor <= max) return valor;
                System.out.printf("Digite um número entre %d e %d.\n", min, max);
            } catch(NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
            }
        }
    }
}