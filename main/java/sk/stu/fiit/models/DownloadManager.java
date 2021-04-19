/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.models;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Singleton class, which is holds information about all downloads
 * @author Admin
 */
public class DownloadManager extends Thread{

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
    
    /**
     * start new download
     * @param urlString
     * @param pathString
     * @throws MalformedURLException
     * @throws IOException 
     */
    public void startDownloading(String urlString, String pathString) throws MalformedURLException, IOException{
        int ID = generateID();
        
        Downloader objDownloader = new Downloader(ID, urlString, pathString);
        objDownloader.start(); 
        new DownloadProgressChecker(pathString, objDownloader, urlString).start();
        
        try {
            System.out.println("objDownloader = " + Arrays.toString(objDownloader.lastData));
            objDownloader.pauseDownloading();
            sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(DownloadManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Downloader.loadPaused().start();
        new DownloadProgressChecker(pathString, objDownloader, urlString).start();
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
