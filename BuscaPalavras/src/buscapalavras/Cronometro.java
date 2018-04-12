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

    
    public static void inicia(){
        inicio = System.currentTimeMillis();
    }
    
    public static long fim(){
        return (System.currentTimeMillis())-inicio;
    }
    
}
