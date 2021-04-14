/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.models;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class UrlDownloader {
    
    public void download(String urlSpec) throws MalformedURLException, IOException{
        URL objUrl = new URL(urlSpec);
        String path = getPath(urlSpec);
        
        try (BufferedInputStream inputStream = new BufferedInputStream(objUrl.openStream());
  FileOutputStream fileOS = new FileOutputStream(path)) {
            byte data[] = new byte[1024];
            int byteContent;
            while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
                fileOS.write(data, 0, byteContent);
            }
        }
    }
    
    private String getDefaultName(String urlSpec) throws MalformedURLException{
        
        URL fileUri = new URL(urlSpec);    
        int startIndex = fileUri.toString().lastIndexOf('/');
        String fileName = fileUri.toString().substring(startIndex + 1);
        System.out.println("fileName = " + fileName);
        return fileName;
    }
    
    private String getPath(String urlSpec) throws MalformedURLException{
        
        String path = System.getProperty("user.home");
        File defaultFile = new File(path + "\\" + getDefaultName(urlSpec));
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(defaultFile);
        int result = fileChooser.showSaveDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            path = fileChooser.getSelectedFile().getAbsolutePath();
        }
        
        return path;
    }
    
    public static void main(String[] args) {
        UrlDownloader objDownloader = new UrlDownloader();
        String url = JOptionPane.showInputDialog("Zadajte link");
        
        try {
            objDownloader.download(url);
            JOptionPane.showMessageDialog(null, "subor bol uspesne stiahnuty");
        } catch (IOException ex) {
            Logger.getLogger(UrlDownloader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
