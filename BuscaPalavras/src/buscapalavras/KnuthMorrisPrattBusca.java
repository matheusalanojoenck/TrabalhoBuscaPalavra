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
public class KnuthMorrisPrattBusca extends SearchStrategy{
    
    private final String nome = "Knuth Morris Part";
    private boolean resultado;
    private int quantidade = 0;

    /**
     * Inicia a estratégia de busca.
     * @param textoArray texto em que vai ocorrer a busca.
     * @param palavra termo a ser procurado no texto.
     * @return true, se encontrou a String palavra dentro do ArryList textoArray,
     *         se não false
     */
    @Override
    public boolean execute(ArrayList<String> textoArray, String palavra){
        resultado = false;
        for(String texto : textoArray){
            
            if(KMP(texto, palavra) != 0){
                resultado = true;
            }
         }
        return resultado;
    }
    
    public int KMP(String texto, String palavra){
        if(palavra==null || palavra.length()==0){
            return 0;
        }else if(texto == null || palavra.length() > texto.length()){
            return 0;
        }
        
        char[] chars = palavra.toCharArray();
        int [] next = new int[palavra.length() + 1];
        for(int i = 1; i < palavra.length(); i++){
            int j = next[i + 1];
            while(j > 0 && chars[j] != chars[i]){
                 j = next[j];
            }
            if(j > 0 || chars[j]==chars[i]){
                next[i + 1] = j + 1;
            }
        }
        for(int i = 0, j = 0; i < texto.length(); i++){
            if(j < palavra.length() && texto.charAt(i) == palavra.charAt(j)){
                if(++j == palavra.length()){
                    setQuantidade();
                }
            }else if(j > 0){
                j = next[j];
                i--;
            }
        }
        return getQuantidade();
    }
    
    /**
     * Retorna o nome do tipo da estratégia usada.
     * @return nome
     */
    @Override
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a quantidade de termos encontrados
     * @return quantidade
     */
    @Override
    public int getQuantidade() {
       return quantidade;
    }

    /**
     * Soma mais 1 (um) a variável quantaide;
     */
    @Override
    protected void setQuantidade() {
        quantidade++;
    }
    
}
