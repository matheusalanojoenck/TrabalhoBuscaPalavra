/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscapalavras;

import java.util.ArrayList;

/**
 *
 * @author udesc
 */
public abstract class SearchStrategy {
        private String nome;
        private int quantidade;
        public abstract boolean execute(ArrayList<String> textoArray, String palavra);
        public abstract String getNome();
        public abstract int getQuantidade();
        public abstract void setQuantidade();
        
}
