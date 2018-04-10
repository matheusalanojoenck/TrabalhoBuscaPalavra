/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscapalavras;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matheus
 */
public class BuscaPalavraTest {
    private NaiveBusca naive;
    private KnuthMorrisPartBusca kmp;
    private BoyerMooreBusca boyer;
    private RabinKarpBusca rabin;
    public BuscaPalavraTest() {
    }
    
    
    @Before
    public void setUp() {
        LerArquivo.setTextoCompleto();
        naive = new NaiveBusca();
        kmp = new KnuthMorrisPartBusca();
        boyer = new BoyerMooreBusca();
        rabin = new RabinKarpBusca();
    }
    

    /**
     * Test of execute method, of class NaiveBusca.
     */
    @Test
    public void testexecute() {
        assertEquals(true, naive.execute(LerArquivo.getTextoCompleto(), "way"));
        assertEquals(false, naive.execute(LerArquivo.getTextoCompleto(), "matheus"));
        assertEquals(false, kmp.execute(LerArquivo.getTextoCompleto(), ""));
        assertEquals(false, boyer.execute(LerArquivo.getTextoCompleto(), ""));
        assertEquals(false, rabin.execute(LerArquivo.getTextoCompleto(), ""));

    }
    
}
