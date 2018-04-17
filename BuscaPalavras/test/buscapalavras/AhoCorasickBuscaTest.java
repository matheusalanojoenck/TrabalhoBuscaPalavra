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
public class AhoCorasickBuscaTest {
    
    SearchStrategy aho;
    
    @Before
    public void setUp() {
        aho = new AhoCorasickBusca();
    }

    @Test
    public void testExecuteCase1() {
        assertFalse(aho.execute(LerArquivo.getTextoCompleto(), ""));
    }
}
