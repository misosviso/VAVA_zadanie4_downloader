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
        String urlString = JOptionPane.showInputDialog("Zadajte url adresu:");
        String pathString;
        try {
            pathString = DestinationResolver.getPath(urlString);
            downloadManager.createDownloader(urlString, pathString);
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "neplatná adresa");
            return;
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
