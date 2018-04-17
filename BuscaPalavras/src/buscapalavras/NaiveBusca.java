/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscapalavras;

import java.util.ArrayList;

/**
 *
 * @author matheus
 */
public class NaiveBusca extends SearchStrategy {
    
    private final String nome = "Naive";
    private boolean resultado;
    private int quantidade = 0;
    
    /**
     *
     * @param textoArray
     * @param palavra
     * @return
     */
    
    @Override
    public boolean execute(ArrayList<String> textoArray, String palavra){
        resultado = false;
        for(String texto : textoArray){
            int tamanhoTexto = texto.length();
            int tamanhoPalavra = palavra.length();

            for (int i = 0; i < tamanhoTexto-tamanhoPalavra; i++) {
                int j;

                for (j = 0; j < tamanhoPalavra; j++) {
                    if(texto.charAt(i+j) != palavra.charAt(j)){
                        break;
                    }
                }

                if(j==tamanhoPalavra){
                    resultado = true;
                    setQuantidade();
                }
                
            }
        }
        return resultado;
    }
    
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getQuantidade() {
        return quantidade;
    }

    @Override
    protected void setQuantidade() {
        quantidade++;
    }
}
