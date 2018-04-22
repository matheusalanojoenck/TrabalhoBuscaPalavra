/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscapalavras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author matheus
 */
public class LerArquivo {
//    private static final HashMap<String,String> conteudo = new HashMap<>();
    private static final ArrayList<String> textoCompletoArray = new ArrayList();
    private static final ArrayList<String> nomeArquivos = new ArrayList();
    
    /**
     * ArrayList contendo o nome dos arquivos a serem abertos.
     */
    private static void inciaString(){
        // conteudo.put("1H4.txt", "");
        nomeArquivos.add("1H4.txt");
        nomeArquivos.add("1H6.txt");
        nomeArquivos.add("2H4.txt");
        nomeArquivos.add("2H6.txt");
        nomeArquivos.add("3H6.txt");
        nomeArquivos.add("Ado.txt");
        nomeArquivos.add("Ant.txt");
        nomeArquivos.add("AWW.txt");
        nomeArquivos.add("AYL.txt");
        nomeArquivos.add("Cor.txt");
        nomeArquivos.add("Cym.txt");
        nomeArquivos.add("Err.txt");
        nomeArquivos.add("H5.txt");
        nomeArquivos.add("H8.txt");
        nomeArquivos.add("Ham.txt");
        nomeArquivos.add("JC.txt");
        nomeArquivos.add("Jn.txt");
        nomeArquivos.add("LLL.txt");
        nomeArquivos.add("Lr.txt");
        nomeArquivos.add("Luc.txt");
        nomeArquivos.add("Mac.txt");
        nomeArquivos.add("MM.txt");
        nomeArquivos.add("MND.txt");
        nomeArquivos.add("MV.txt");
        nomeArquivos.add("Oth.txt");
        nomeArquivos.add("Per.txt");
        nomeArquivos.add("PhT.txt");
        nomeArquivos.add("R2.txt");
        nomeArquivos.add("R3.txt");
        nomeArquivos.add("Rom.txt");
        nomeArquivos.add("Shr.txt");
        nomeArquivos.add("Son.txt");
        nomeArquivos.add("TGV.txt");
        nomeArquivos.add("Tim.txt");
        nomeArquivos.add("Tit.txt");
        nomeArquivos.add("Tmp.txt");
        nomeArquivos.add("TN.txt");
        nomeArquivos.add("TNK.txt");
        nomeArquivos.add("Tro.txt");
        nomeArquivos.add("Ven.txt");
        nomeArquivos.add("Wiv.txt");
        nomeArquivos.add("WT.txt");
    }
    
    /**
     * Lê os arquivos e os adicona em um ArrayList
     */
    public static void setTextoCompleto(){
        inciaString();
        
        nomeArquivos.forEach((String nome) -> {
            StringBuilder textoDoArquivo= new StringBuilder();
            try {
                BufferedReader lerArq = new BufferedReader(new FileReader(nome));
                
                String linha;
                
                while ((linha=lerArq.readLine()) != null) {  
                    textoDoArquivo.append(linha);
                    textoDoArquivo.append(" ");//não pode ser '\n', pois os algoritmos não encontram sentenças de duas ou mais linhas 
                }
                textoCompletoArray.add(textoDoArquivo.toString().toUpperCase());
                lerArq.close();
                
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro na abertura do arquivo: " + e.getMessage());
            }
        }); 
    }

    /**
     * Retorna o ArrayList contendo o texto completo
     * @return textoCompleto 
     */
    public static ArrayList<String> getTextoCompleto(){
        return textoCompletoArray;
    }
    
}
