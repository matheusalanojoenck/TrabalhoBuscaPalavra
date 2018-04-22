/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscapalavras;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author matheus
 */
public class AhoCorasickBusca extends SearchStrategy {

    private final String nome = "Aho-Corasick";
    private boolean resultado = false;
    private int quantidade = 0;

    static final int ALPHABET_SIZE = 27;
    Node[] nodes;
    int nodeCount;

    private char replaceSpecialCharacter(char ch) {
        if( ch >= 65 && ch <= 90 ) {
            return ch;
        } else {
            return 91;
        }
    }
    
    public static class Node {

        int parent;
        char charFromParent;
        int suffLink = -1;
        int[] children = new int[ALPHABET_SIZE];
        int[] transitions = new int[ALPHABET_SIZE];
        boolean leaf;
        {
            Arrays.fill(children, -1);
            Arrays.fill(transitions, -1);
        }
    }

    public AhoCorasickBusca() {
        int maxNodes = 1000;
        nodes = new Node[maxNodes];
        // create root
        nodes[0] = new Node();
        nodes[0].suffLink = 0;
        nodes[0].parent = -1;
        nodeCount = 1;
    }

    @Override
    public boolean execute(ArrayList<String> textoArray, String palavra) {
        addString(palavra);
        for(String texto: textoArray){
            int node = 0;
            for (int i = 0; i < texto.length(); i++) {
                node = transition(node, texto.charAt(i));
                if (nodes[node].leaf){
                    resultado = true;
                    setQuantidade();
                }
            }
        }
        return resultado;
    }

    public void addString(String s) {
        int cur = 0;
        for (char ch : s.toCharArray()) {
            ch = replaceSpecialCharacter(ch);
            int c = ch - 'A';

            if (nodes[cur].children[c] == -1) {
                nodes[nodeCount] = new Node();
                nodes[nodeCount].parent = cur;
                nodes[nodeCount].charFromParent = ch;
                nodes[cur].children[c] = nodeCount++;
            }
            cur = nodes[cur].children[c];
        }
        nodes[cur].leaf = true;
    }

    public int suffLink(int nodeIndex) {
        Node node = nodes[nodeIndex];
        if (node.suffLink == -1) {
            node.suffLink = node.parent == 0 ? 0 : transition(suffLink(node.parent), node.charFromParent);
        }
        return node.suffLink;
    }

    public int transition(int nodeIndex, char ch) {
        ch = replaceSpecialCharacter(ch);

        int c = ch - 'A';
        Node node = nodes[nodeIndex];
        if (node.transitions[c] == -1) {
            node.transitions[c] = node.children[c] != -1 ? node.children[c] : (nodeIndex == 0 ? 0 : transition(suffLink(nodeIndex), ch));
        }
        return node.transitions[c];
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
