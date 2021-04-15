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
 * Class that gets path and name of the file for downloading from user
 * @author Admin
 */
public class DestinationResolver {
    
    /**
     * get name of the downloaded file from URL address
     * @param urlSpec String URL address
     * @return String filename
     * @throws MalformedURLException if URL address is not valid
     */
    private static String getDefaultName(String urlSpec) throws MalformedURLException{
        
        URL fileUri = new URL(urlSpec);    
        int startIndex = fileUri.toString().lastIndexOf('/');
        String fileName = fileUri.toString().substring(startIndex + 1);
        System.out.println("fileName = " + fileName);
        return fileName;
    }
    
    /**
     * get path from the user
     * @param urlSpec String URL address
     * @return String path + filename
     * @throws MalformedURLException if URL address is not valid
     */
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
