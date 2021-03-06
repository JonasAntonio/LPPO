/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Container;
import javassist.tools.rmi.RemoteException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        //this.setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDesktop = new javax.swing.JDesktopPane();
        mnBarra = new javax.swing.JMenuBar();
        mnArquivo = new javax.swing.JMenu();
        mniSair = new javax.swing.JMenuItem();
        mnOperacao = new javax.swing.JMenu();
        mnAluno = new javax.swing.JMenu();
        mniCadAluno = new javax.swing.JMenuItem();
        mniRemover = new javax.swing.JMenuItem();
        mniListaAluTur = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnTurma = new javax.swing.JMenu();
        mnCadTurma = new javax.swing.JMenuItem();
        mniListaTurmaOO = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Escolar DJJL");
        setPreferredSize(new java.awt.Dimension(800, 600));

        mnArquivo.setMnemonic('a');
        mnArquivo.setText("Arquivo");

        mniSair.setMnemonic('s');
        mniSair.setText("Sair");
        mniSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSairActionPerformed(evt);
            }
        });
        mnArquivo.add(mniSair);

        mnBarra.add(mnArquivo);

        mnOperacao.setMnemonic('o');
        mnOperacao.setText("Operações");

        mnAluno.setMnemonic('a');
        mnAluno.setText("Aluno");

        mniCadAluno.setMnemonic('c');
        mniCadAluno.setText("Cadastro");
        mniCadAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCadAlunoActionPerformed(evt);
            }
        });
        mnAluno.add(mniCadAluno);

        mniRemover.setMnemonic('r');
        mniRemover.setText("Remoção");
        mniRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniRemoverActionPerformed(evt);
            }
        });
        mnAluno.add(mniRemover);

        mniListaAluTur.setMnemonic('l');
        mniListaAluTur.setText("Lista de Alunos por Turma");
        mniListaAluTur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniListaAluTurActionPerformed(evt);
            }
        });
        mnAluno.add(mniListaAluTur);

        mnOperacao.add(mnAluno);
        mnOperacao.add(jSeparator1);

        mnTurma.setMnemonic('t');
        mnTurma.setText("Turma");

        mnCadTurma.setMnemonic('c');
        mnCadTurma.setText("Cadastro");
        mnCadTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadTurmaActionPerformed(evt);
            }
        });
        mnTurma.add(mnCadTurma);

        mniListaTurmaOO.setMnemonic('l');
        mniListaTurmaOO.setText("Listagem de Turmas");
        mniListaTurmaOO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniListaTurmaOOActionPerformed(evt);
            }
        });
        mnTurma.add(mniListaTurmaOO);

        mnOperacao.add(mnTurma);

        mnBarra.add(mnOperacao);

        setJMenuBar(mnBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDesktop, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDesktop, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mniSairActionPerformed

    private void mniCadAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadAlunoActionPerformed
        // TODO add your handling code here:
        AlunoCadForm alunoCadForm = new AlunoCadForm();
        panelDesktop.add(alunoCadForm);
        alunoCadForm.Centralizar();
        alunoCadForm.setVisible(true);
    }//GEN-LAST:event_mniCadAlunoActionPerformed

    private void mnCadTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadTurmaActionPerformed
        // TODO add your handling code here:
        TurmaCadForm turmaCadForm = new TurmaCadForm();
        panelDesktop.add(turmaCadForm);
        turmaCadForm.Centralizar();
        turmaCadForm.setVisible(true);
    }//GEN-LAST:event_mnCadTurmaActionPerformed

    private void mniListaAluTurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniListaAluTurActionPerformed
        // TODO add your handling code here:
        AlunoListaForm alunoListaForm = new AlunoListaForm();
        panelDesktop.add(alunoListaForm);
        alunoListaForm.Centralizar();
        alunoListaForm.setVisible(true);
    }//GEN-LAST:event_mniListaAluTurActionPerformed

    private void mniListaTurmaOOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniListaTurmaOOActionPerformed
        // TODO add your handling code here:
        TurmaListaForm turmaListaForm = new TurmaListaForm();
        panelDesktop.add(turmaListaForm);
        turmaListaForm.Centralizar();
        turmaListaForm.setVisible(true);
    }//GEN-LAST:event_mniListaTurmaOOActionPerformed

    private void mniRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRemoverActionPerformed
        // TODO add your handling code here:
        RemocaoDialog remocaoDialog = new RemocaoDialog();
        remocaoDialog.setLocationRelativeTo(this);
        remocaoDialog.setVisible(true);
    }//GEN-LAST:event_mniRemoverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu mnAluno;
    private javax.swing.JMenu mnArquivo;
    private javax.swing.JMenuBar mnBarra;
    private javax.swing.JMenuItem mnCadTurma;
    private javax.swing.JMenu mnOperacao;
    private javax.swing.JMenu mnTurma;
    private javax.swing.JMenuItem mniCadAluno;
    private javax.swing.JMenuItem mniListaAluTur;
    private javax.swing.JMenuItem mniListaTurmaOO;
    private javax.swing.JMenuItem mniRemover;
    private javax.swing.JMenuItem mniSair;
    private javax.swing.JDesktopPane panelDesktop;
    // End of variables declaration//GEN-END:variables
}
