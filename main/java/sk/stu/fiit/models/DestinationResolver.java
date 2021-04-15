/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.models;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JFileChooser;

/**
 *
 * @author Admin
 */
public class DestinationResolver {
    
    private static String getDefaultName(String urlSpec) throws MalformedURLException{
        
        URL fileUri = new URL(urlSpec);    
        int startIndex = fileUri.toString().lastIndexOf('/');
        String fileName = fileUri.toString().substring(startIndex + 1);
        System.out.println("fileName = " + fileName);
        return fileName;
    }
    
    public static String getPath(String urlSpec) throws MalformedURLException{
        
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
    
}
