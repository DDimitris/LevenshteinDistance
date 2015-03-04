/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import algorithm.Algorithm;

/**
 *
 * @author sta
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPane = new ui.BackgroundedPanel();
        firstWordLabel = new javax.swing.JLabel();
        firstWordField = new javax.swing.JTextField();
        secondWordLabel = new javax.swing.JLabel();
        secondWordField = new javax.swing.JTextField();
        buttonPanel = new javax.swing.JPanel();
        calculateButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Levenshtein");
        setBackground(java.awt.Color.white);
        setMinimumSize(new java.awt.Dimension(238, 121));

        mainPane.setBackground(new java.awt.Color(235, 243, 251));
        mainPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 4, 4, 4));
        mainPane.setAlpha(0.6F);
        mainPane.setRounded(true);
        mainPane.setLayout(new java.awt.GridBagLayout());

        firstWordLabel.setFont(new java.awt.Font("Ubuntu", 0, 19)); // NOI18N
        firstWordLabel.setText("First Word");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(4, 5, 2, 3);
        mainPane.add(firstWordLabel, gridBagConstraints);

        firstWordField.setFont(new java.awt.Font("Ubuntu", 0, 22)); // NOI18N
        firstWordField.setText("πολλοί");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 3, 2, 5);
        mainPane.add(firstWordField, gridBagConstraints);

        secondWordLabel.setFont(new java.awt.Font("Ubuntu", 0, 19)); // NOI18N
        secondWordLabel.setText("Second Word");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 2, 3);
        mainPane.add(secondWordLabel, gridBagConstraints);

        secondWordField.setFont(new java.awt.Font("Ubuntu", 0, 22)); // NOI18N
        secondWordField.setText("πολύ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 2, 5);
        mainPane.add(secondWordField, gridBagConstraints);

        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new java.awt.GridLayout());

        calculateButton.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        calculateButton.setText("Calculate");
        calculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(calculateButton);

        closeButton.setFont(new java.awt.Font("Ubuntu", 0, 17)); // NOI18N
        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(closeButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 4, 0);
        mainPane.add(buttonPanel, gridBagConstraints);

        getContentPane().add(mainPane, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeButtonActionPerformed

    private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateButtonActionPerformed
        final Algorithm alg = new Algorithm(firstWordField.getText(), secondWordField.getText());
        alg.editDistance();
        Graphics.generateAndShowGraphic(alg);
    }//GEN-LAST:event_calculateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton calculateButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JTextField firstWordField;
    private javax.swing.JLabel firstWordLabel;
    private ui.BackgroundedPanel mainPane;
    private javax.swing.JTextField secondWordField;
    private javax.swing.JLabel secondWordLabel;
    // End of variables declaration//GEN-END:variables
}
