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
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class which is responsible for downloading file from URL address
 * @author Admin
 */
public class Downloader extends Thread implements Serializable{

    private final int id;
    private final URL source;
    private final File destination;
    private volatile boolean running = true;
    private int totalSize = 0;
    private int downloaded = 0;
    private final DownloadManager manager;
    private final boolean unzip;
    
    /**
     * Constructor
     * @param id ID of downloading task
     * @param strSource URL address
     * @param strDestination path to the destination file
     * @param manager
     * @throws MalformedURLException if the user given URL is not valid
     */

    public Downloader(int id, String strSource, String strDestination, DownloadManager manager) throws MalformedURLException, IOException {
        this.id = id;
        this.source = new URL(strSource);
        this.destination = new File(strDestination);
        this.totalSize = source.openConnection().getContentLength();
        this.manager = manager;
        this.unzip = false;
    }
    
    public Downloader(int id, String strSource, String strDestination, DownloadManager manager, boolean unzip) throws MalformedURLException, IOException {
        this.id = id;
        this.source = new URL(strSource);
        this.destination = new File(strDestination);
        this.totalSize = source.openConnection().getContentLength();
        this.manager = manager;
        this.unzip = unzip;
    }
    
    public int getDownloaderId() {
        return id;
    }
   
    @Override
    public void run() {
        
        try (BufferedInputStream inputStream = new BufferedInputStream(source.openStream());
        FileOutputStream fileOS = new FileOutputStream(destination);) {
            byte data[] = new byte[1024];
            int byteContent;
            
            while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
                downloaded += byteContent;
                fileOS.write(data, 0, byteContent);
                
                while(!running){
                    Downloader.yield();
                    sleep(5000);
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, "Nepodarilo sa zapisovat do suporu", ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, "Thread downloadera bol preruseny", ex);
        }
    }

    public int getDownloaded() {
        return downloaded;
    }
    
    public int getTotalSize() {
        return totalSize;
    }
    
    public void pauseDownloading() throws InterruptedException{
        System.out.println("Prerusujem");
        running = false;
    }

    public void resumeDownloading() {
        System.out.println("Obnovujem");
        running = true;
    }
    
}
