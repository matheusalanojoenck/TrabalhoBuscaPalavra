/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import buscapalavras.Cronometro;
import buscapalavras.LerArquivo;

/**
 * 
 * @author matheus
 */
public class BuscaPalavras {

    public static Menu menu;

    public static void main(String[] args) {
        menu = new Menu();
        
        Cronometro.inicia();
        LerArquivo.setTextoCompleto();
        menu.setDuracaoLeitura(Long.toString(Cronometro.fim())+" milissegundos");
        menu.setVisible(true);        
    }
}
