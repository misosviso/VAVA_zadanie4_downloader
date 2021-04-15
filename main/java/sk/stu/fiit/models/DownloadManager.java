/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.models;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Singleton class, which is holds information about all downloads
 * @author Admin
 */
public class DownloadManager{

    /**
     * Factory for getting instance of DownloadManager
     * @return 
     */
    public static DownloadManager getDownloadManager() {
        if(instanceOfSelf == null){
            instanceOfSelf = new DownloadManager();
        }
        return instanceOfSelf;
    }
    
    private final List<Downloader> downloads = new LinkedList<>();
    private static DownloadManager instanceOfSelf = null;

    /**
     * private constructor
     */
    private DownloadManager() {}
    
    public void createDownloader(String urlString, String pathString) throws MalformedURLException, IOException{
        int ID = generateID();
        
        
        Downloader objDownloader = new Downloader(ID, urlString, pathString);
        DownloadProgressChecker objChecker = new DownloadProgressChecker(pathString, objDownloader, urlString);
        objDownloader.start(); 
        objChecker.start();
    }
    
    private int generateID(){
        return downloads.size();
    }
    
    private Downloader getSpecificDownloader(int ID){
        for (Downloader objDownloader : downloads) {
            if(objDownloader.getDownloaderId() == ID){
                return objDownloader;
            }
        }
        return null; 
    }
    
    public void startDownloader(int ID){
        this.getSpecificDownloader(ID).start();
    }
}
