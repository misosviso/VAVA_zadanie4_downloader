/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.models;

import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Main {
    
    public static void main(String[] args){
        
        DownloadManager downloadManager = DownloadManager.getDownloadManager();
        String urlString1 = JOptionPane.showInputDialog("Zadajte url adresu:");
        // String urlString2 = JOptionPane.showInputDialog("Zadajte url adresu:");
        try {
            String pathString1 = DestinationResolver.getPath(urlString1);
            // String pathString2 = DestinationResolver.getPath(urlString2);
            downloadManager.startDownloading(urlString1, pathString1);
            // downloadManager.startDownloading(urlString2, pathString2);
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Neplatná adresa");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Subor sa nepodarilo vytvorit");
        }
        
    }
    
}
