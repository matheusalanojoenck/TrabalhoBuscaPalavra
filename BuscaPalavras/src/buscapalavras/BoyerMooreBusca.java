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
public class BoyerMooreBusca extends SearchStrategy{

    private final String nome = "Boyer Moore";
    private int quantidade = 0;
    private boolean resultado;
    
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
             
            char[] c_arr = texto.toCharArray();
            char[] c_array = palavra.toCharArray();

            if(indexOf(c_arr, c_array) != 0){
                resultado = true;
            }  
         }
        
        return resultado;
    }
    
     private int indexOf(char[] haystack, char[] needle) {
        if (needle.length == 0) {
            return 0;
        }
        int charTable[] = makeCharTable(needle);
        int offsetTable[] = makeOffsetTable(needle);
        for (int i = needle.length - 1, j; i < haystack.length;) {
            for (j = needle.length - 1; needle[j] == haystack[i]; --i, --j) {
                if (j == 0) {
                    setQuantidade();
                    break;
                    //return i;
                }
            }
            // i += needle.length - j; // For naive method
            i += Math.max(offsetTable[needle.length - 1 - j], charTable[haystack[i]]);
        }
        return getQuantidade();
    }

    /**
     * Makes the jump table based on the mismatched character information.
     */
    private int[] makeCharTable(char[] needle) {
        final int ALPHABET_SIZE = 256;
        int[] table = new int[ALPHABET_SIZE];
        for (int i = 0; i < table.length; ++i) {
            table[i] = needle.length;
        }
        for (int i = 0; i < needle.length - 1; ++i) {
            table[needle[i]] = needle.length - 1 - i;
        }
        return table;
    }

    /**
     * Makes the jump table based on the scan offset which mismatch occurs.
     */
    private int[] makeOffsetTable(char[] needle) {
        int[] table = new int[needle.length];
        int lastPrefixPosition = needle.length;
        for (int i = needle.length - 1; i >= 0; --i) {
            if (isPrefix(needle, i + 1)) {
                lastPrefixPosition = i + 1;
            }
            table[needle.length - 1 - i] = lastPrefixPosition - i + needle.length - 1;
        }
        for (int i = 0; i < needle.length - 1; ++i) {
            int slen = suffixLength(needle, i);
            table[slen] = needle.length - 1 - i + slen;
        }
        return table;
    }

    /**
     * Is needle[p:end] a prefix of needle?
     */
    private boolean isPrefix(char[] needle, int p) {
        for (int i = p, j = 0; i < needle.length; ++i, ++j) {
            if (needle[i] != needle[j]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the maximum length of the substring ends at p and is a suffix.
     */
    private int suffixLength(char[] needle, int p) {
        int len = 0;
        for (int i = p, j = needle.length - 1;
                 i >= 0 && needle[i] == needle[j]; --i, --j) {
            len += 1;
        }
        return len;
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
    public void setQuantidade() {
        quantidade++;
    }
}
