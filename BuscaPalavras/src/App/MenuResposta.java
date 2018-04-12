/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import buscapalavras.*;


/**
 *
 * @author udesc
 */
public class MenuResposta extends javax.swing.JFrame {
    private boolean resultado=false;
    /**;
     * Creates new form MenuResposta
     * @param tipoBusca
     */
    public MenuResposta(String tipoBusca) {
        initComponents();
        iniciaBusca(tipoBusca);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        respostaBusca = new javax.swing.JLabel();
        labelDuracao = new javax.swing.JLabel();
        duracaoBusca = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        respostaBusca.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        respostaBusca.setText("<Aguardando busca>");

        labelDuracao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDuracao.setText("Duração:");

        duracaoBusca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        duracaoBusca.setText("duracaoBusca");

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelTitulo.setText("algo");

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(labelTitulo)
                    .addComponent(respostaBusca)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelDuracao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(duracaoBusca))
                    .addComponent(botaoVoltar))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addGap(49, 49, 49)
                .addComponent(respostaBusca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDuracao)
                    .addComponent(duracaoBusca))
                .addGap(31, 31, 31)
                .addComponent(botaoVoltar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void iniciaBusca(String tipoBusca){
 
        switch(tipoBusca){
            case "naive":
                setLabelTitulo("Naive");
                NaiveBusca naive = new NaiveBusca();
                busca(naive);
            break;
            case "rabin":
                setLabelTitulo("Rabin Karp");                
                RabinKarpBusca rabin = new RabinKarpBusca();
                busca(rabin);
            break;
            case "kmp":
                setLabelTitulo("Knuth Morris Part");
                KnuthMorrisPartBusca kmp = new KnuthMorrisPartBusca();
                busca(kmp);
            break;
            case "boyer":
                setLabelTitulo("Boyer Moore");
                BoyerMooreBusca boyer = new BoyerMooreBusca();
                busca(boyer);
            break;
        }
                
    }
    
    private void busca(SearchStrategy tipoBusca){
        Cronometro.setInicio(System.currentTimeMillis());
        resultado = tipoBusca.execute(LerArquivo.getTextoCompleto(),Menu.getCampoPalavraChave());
        Cronometro.setFim(System.currentTimeMillis());
        duracaoBusca.setText(Cronometro.getDuracao());
        setRespostaBusca(resultado);  
    }

    public void setLabelTitulo(String labelTitulo) {
        this.labelTitulo.setText(labelTitulo);
    }
    
    private void setRespostaBusca(boolean resultado) {
        if(resultado){
            respostaBusca.setText("Palavra encontrada");
        }else{
            respostaBusca.setText("Palavra não encontrada");

        }
    }
    
    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel duracaoBusca;
    private javax.swing.JLabel labelDuracao;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel respostaBusca;
    // End of variables declaration//GEN-END:variables
}
