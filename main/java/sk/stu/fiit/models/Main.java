/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.models;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Main {
    
    public static void main(String[] args){
        
        DownloadManager downloadManager = DownloadManager.getDownloadManager();
        String urlString1 = JOptionPane.showInputDialog("Zadajte url adresu:");
        try {
            String pathString1 = DestinationResolver.getPath(urlString1);
            downloadManager.startDownloading(urlString1, pathString1);
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Neplatná adresa");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Subor sa nepodarilo vytvorit");
        }
        try {
            downloadManager.pauseDownloading(0);
            downloadManager.resumeDownloading(0);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
