/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscapalavras;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matheus
 */
public class NaiveBuscaTest {
    SearchStrategy naive;
    
    @Before
    public void setUp() {
        naive = new NaiveBusca();
        LerArquivo.setTextoCompleto();
    }
    
    /**
     * Encontrar String de uma palavra
     */
    @Test
    public void testExecuteCase1() {
        assertEquals(true, naive.execute(LerArquivo.getTextoCompleto(), "way".toUpperCase()));
    }
    
    /**
     * Encontrar String de com mais de uma palavra
     */
    @Test
    public void testExecuteCase2() {
        assertEquals(true, naive.execute(LerArquivo.getTextoCompleto(), "HELEN, a gentlewoman of Rossillion".toUpperCase()));
    }
    
    /**
     * Encontrar String de com sentença de mais de uma linha;
     */
    @Test
    public void testExecuteCase3() {
        assertEquals(true, naive.execute(LerArquivo.getTextoCompleto(), "HELEN, a gentlewoman of Rossillion BERTRAM, Count of Rossillion".toUpperCase()));
    }
    
    
    /**
     * Não encontra String de uma palavra
     */
    @Test
    public void testExecuteCase4(){
        assertEquals(false, naive.execute(LerArquivo.getTextoCompleto(), "NãoEncontrar".toUpperCase()));
    }
    
    /**
     * Não encontra String com mais de uma palavra
     */
    @Test
    public void testExecuteCase5(){
        assertEquals(false, naive.execute(LerArquivo.getTextoCompleto(), "Não deve encontrar".toUpperCase()));
    }
    
    /**
     * Não encontra String com sentença contida no texto mas com um caracter diferente.
     */
    @Test
    public void testExecuteCase6(){
        assertEquals(false, naive.execute(LerArquivo.getTextoCompleto(), "HELEN, a gentlewoman of RossillionX".toUpperCase()));
    }
    
    
}
