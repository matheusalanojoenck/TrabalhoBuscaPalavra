/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscapalavras;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

/**
 *
 * @author matheus
 */
public class RabinKarpBusca extends SearchStrategy{
    
    private String palavra;
    private long palavraHash;
    private int m;
    private long q;
    private int r;
    private long rm;
    
    private final String nome = "Rabin Karp";
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
            this.palavra = palavra;
            r = 256;
            m = palavra.length();
            q = longRandomPrime();
            rm = 1;
            for (int i = 1; i <= m-1; i++) {
                rm = (r * rm) % q;
            }
            palavraHash = hash(palavra, m);
            if(search(texto) != 0){
                resultado = true;
            }             
        }
        return resultado;
    }
    
    private long hash(String palavra, int m){
        long h = 0;
        for (int j = 0; j < m; j++) {
            h=(r * h + palavra.charAt(j)) % q;
        }
        return h;
    }
    
    private boolean check(String texto, int i){
        for (int j = 0; j < m; j++) {
            if(palavra.charAt(j) != texto.charAt(i + j)){
                return false;
            }
        }
        return true;
    }
    
    private int search(String texto){
        int n = texto.length();
        if( n < m){
            return 0;
        }
        long textoHash = hash(texto, m);
        if((palavraHash == textoHash) && check(texto, 0)){
            setQuantidade();
            //return 0;
        }
        for (int i = m; i < n; i++) {
            textoHash = (textoHash + q - rm * texto.charAt(i - m) % q) % q;
            textoHash = (textoHash * r + texto.charAt(i)) % q;
            
            int offset = i - m + 1;
            if((palavraHash == textoHash) && check(texto, offset)){
                setQuantidade();
                //return offset;
            }
        }
        return getQuantidade();
    }
    
    private long longRandomPrime(){
        BigInteger prime = BigInteger.probablePrime(31, new SecureRandom());
        return prime.longValue();
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
