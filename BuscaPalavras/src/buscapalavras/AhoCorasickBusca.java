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
public class AhoCorasickBusca extends SearchStrategy {
    
    private final String nome = "Aho-Corasick";
    private boolean resultado = false;
    private int quantidade = 0;

    @Override
    public boolean execute(ArrayList<String> textoArray, String palavra) {
        for(String texto: textoArray){
            
        }
        return false;
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
    public void setQuantidade() {
        quantidade++;
    }
    
}
