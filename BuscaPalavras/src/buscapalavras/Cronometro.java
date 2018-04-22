/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscapalavras;

/**
 *
 * @author matheus
 */
public class Cronometro {
    private static long inicio;

    /**
     * Pega o tempo atual do sistema em milissegundos e atribui a uma variável.
     */
    public static void inicia(){
        inicio = System.currentTimeMillis();
    }
    
    /**
     * Pega o tempo atual do sistema em milissegundos
     * @return a diferença entre a variavel inicio e o tempo atual do sistema.
     */
    public static long fim(){
        return (System.currentTimeMillis())-inicio;
    }
    
}
