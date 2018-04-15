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
public class BuscaPalavraTest {
    public SearchStrategy naive, kmp, boyer, rabin, aho;
    
    public BuscaPalavraTest() {
    }
    
    
    @Before
    public void setUp() {
        LerArquivo.setTextoCompleto();
        naive = new NaiveBusca();
        kmp   = new KnuthMorrisPrattBusca();
        boyer = new BoyerMooreBusca();
        rabin = new RabinKarpBusca();
        aho   = new AhoCorasickBusca();
    }
    

    /**
     * Test of execute method, of class NaiveBusca.
     */
    @Test
    public void testExecuteNaive() {
        assertEquals(true, naive.execute(LerArquivo.getTextoCompleto(), "WAY"));
        assertEquals(false, naive.execute(LerArquivo.getTextoCompleto(), "MATHEUS"));     
    }
    
    @Test
    public void testExcuteRabin(){
        assertEquals(true, rabin.execute(LerArquivo.getTextoCompleto(), "WAY"));
        assertEquals(false, rabin.execute(LerArquivo.getTextoCompleto(), "MATHEUS"));   
    }
    
    @Test
    public void testExecuteKMP(){
        assertEquals(true, kmp.execute(LerArquivo.getTextoCompleto(), "WAY"));
        assertEquals(false, kmp.execute(LerArquivo.getTextoCompleto(), "MATHEUS"));
    }
    
    @Test
    public void testExecuteBoyer(){
        assertEquals(true, boyer.execute(LerArquivo.getTextoCompleto(), "WAY"));
        assertEquals(false, boyer.execute(LerArquivo.getTextoCompleto(), "MATHEUS"));
    }
    
    @Test
    public void testExecuteAhoCorasick(){
        assertEquals(false, aho.execute(LerArquivo.getTextoCompleto(), ""));
 
    }
}
