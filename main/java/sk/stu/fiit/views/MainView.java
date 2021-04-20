/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.views;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sk.stu.fiit.controllers.DownloadManagerController;
import sk.stu.fiit.models.DestinationResolver;

/**
 *
 * @author Admin
 */
public class MainView extends javax.swing.JFrame{
    
    private final DownloadManagerController downloadController;

    /**
     * Creates new form InitView
     */
    public MainView() {
        initComponents();
        this.downloadController = new DownloadManagerController(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        urlTF = new javax.swing.JTextField();
        startDownloadingBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        unzipCB = new javax.swing.JCheckBox();
        openAfterDownloadCB = new javax.swing.JCheckBox();
        progressBar = new javax.swing.JProgressBar();
        progressLb = new javax.swing.JLabel();
        resumeBtn = new javax.swing.JButton();
        pauseBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        recentDownloadsTable = new javax.swing.JScrollPane();
        recentDOwnloadsTable = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jProgressBar3 = new javax.swing.JProgressBar();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        urlTF.setText("URL");
        jPanel2.add(urlTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 160, 30));

        startDownloadingBtn.setText("Vybrať lokáciu");
        startDownloadingBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                startDownloadingBtnMouseReleased(evt);
            }
        });
        jPanel2.add(startDownloadingBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 160, -1));

        jLabel2.setText("? estimated time");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 150, -1));

        unzipCB.setText("jCheckBox1");
        jPanel2.add(unzipCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        openAfterDownloadCB.setText("jCheckBox2");
        jPanel2.add(openAfterDownloadCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, -1, -1));
        jPanel2.add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, -1, -1));

        progressLb.setText("jLabel3");
        jPanel2.add(progressLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 150, -1));

        resumeBtn.setText("Resume");
        resumeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                resumeBtnMouseReleased(evt);
            }
        });
        jPanel2.add(resumeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, -1, -1));

        pauseBtn.setText("Pause");
        pauseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pauseBtnMouseReleased(evt);
            }
        });
        jPanel2.add(pauseBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));

        jTabbedPane1.addTab("sťahovanie", jPanel2);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Úvodna obrazovka");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 350, 80));

        recentDOwnloadsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        recentDownloadsTable.setViewportView(recentDOwnloadsTable);

        jPanel1.add(recentDownloadsTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, 150));

        jToggleButton1.setText("stiahnuť");
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, -1));

        jTabbedPane1.addTab("úvod", jPanel1);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, -1));
        jPanel3.add(jProgressBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));
        jPanel3.add(jProgressBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, -1, -1));

        jTabbedPane1.addTab("správca sťahovania", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 27, 720, 430));

        jButton2.setText("Zobraziť detail");
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 480, -1, -1));

        jTabbedPane1.addTab("história", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jTabbedPane1.addTab("unzip", jPanel5);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startDownloadingBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startDownloadingBtnMouseReleased
        try {
            // TODO add your handling code here:
            String urlString1 = urlTF.getText();
            String pathString1 = DestinationResolver.getPath(urlString1);
            this.downloadController.startDownloading(urlString1, pathString1, this.progressBar, this.progressLb);
            
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Skontroluj si URL zlaticko");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "IO chybicka");
        }
    }//GEN-LAST:event_startDownloadingBtnMouseReleased

    private void pauseBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pauseBtnMouseReleased
        try {
            // TODO add your handling code here:
            this.downloadController.pauseDownloading(0);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pauseBtnMouseReleased

    private void resumeBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resumeBtnMouseReleased
        try {
            // TODO add your handling code here:
            this.downloadController.resumeDownloading(0);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_resumeBtnMouseReleased

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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JCheckBox openAfterDownloadCB;
    private javax.swing.JButton pauseBtn;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel progressLb;
    private javax.swing.JTable recentDOwnloadsTable;
    private javax.swing.JScrollPane recentDownloadsTable;
    private javax.swing.JButton resumeBtn;
    private javax.swing.JButton startDownloadingBtn;
    private javax.swing.JCheckBox unzipCB;
    private javax.swing.JTextField urlTF;
    // End of variables declaration//GEN-END:variables

    public void updateProgress(int[] downloadState){
        float percentage = (float)downloadState[0] / (float)downloadState[1] * 100;
        System.out.println("percentage = " + percentage);
        this.progressBar.setMaximum(downloadState[1]);
        this.progressBar.setValue(downloadState[0]);
        this.progressLb.setText(percentage + "%");
    }
    
}
