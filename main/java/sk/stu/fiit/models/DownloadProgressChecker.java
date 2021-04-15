/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.models;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DownloadProgressChecker extends Thread{
    
    private final File destination;
    private final Downloader objDownloader;
    private int totalLength = 0;
    private int downloaded = 0;

    public DownloadProgressChecker(String strDestination, Downloader objDownloader, String urlSpec) throws IOException {
        this.objDownloader = objDownloader;
        this.destination = new File(strDestination);
        URL source = new URL(urlSpec);
        URLConnection conn = source.openConnection();
        this.totalLength = conn.getContentLength();
    }
    
    private void uploadDownloaded() throws IOException{
        if(destination.exists()){
            this.downloaded = (int) (Files.size(Paths.get(destination.getAbsolutePath()))/1024);
        }
    }
    
    @Override
    public void run() {
        while(objDownloader.isAlive()){
            try {
                uploadDownloaded();
                System.out.println(destination.getName() + " - downloaded: " + downloaded + "/" + totalLength/1024 + "kB");
                sleep(2500);
            } catch (IOException ex) {
                Logger.getLogger(DownloadProgressChecker.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(DownloadProgressChecker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
