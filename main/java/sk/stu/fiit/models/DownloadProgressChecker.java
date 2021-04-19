/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.models;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class which checks for progress
 * @author Admin
 */
public class DownloadProgressChecker extends Thread{
    
    private final File destination;
    private final Downloader objDownloader;

    public DownloadProgressChecker(String strDestination, Downloader objDownloader, String urlSpec) throws IOException {
        this.objDownloader = objDownloader;
        this.destination = new File(strDestination);
    }
    
    @Override
    public void run() {
        while(objDownloader.isAlive()){
            try {
                System.out.println(destination.getName() + " - downloaded: " + objDownloader.getDownloaded()/1024 + "/" +  objDownloader.getTotalLength()/1024 + "kB");
                sleep(2500);
            } catch (InterruptedException ex) {
                Logger.getLogger(DownloadProgressChecker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
