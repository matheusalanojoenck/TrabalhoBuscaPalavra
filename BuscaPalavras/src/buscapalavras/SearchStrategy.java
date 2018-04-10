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
        public abstract boolean execute(ArrayList<String> textoArray, String palavra);
}
