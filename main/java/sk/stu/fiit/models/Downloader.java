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

/**
 * Class which is responsible for downloading file from URL address
 * @author Admin
 */
public class Downloader extends Thread{

    private final int id;
    private final URL source;
    private final File destination;
    private volatile boolean running = true;
    private int totalLength = 0;
    private int downloaded = 0;

    /**
     * Constructor
     * @param id ID of downloading task
     * @param strSource URL address
     * @param strDestination path to the destination file
     * @throws MalformedURLException if the user given URL is not valid
     */
    public Downloader(int id, String strSource, String strDestination) throws MalformedURLException, IOException{
        this.id = id;
        this.source = new URL(strSource);
        this.destination = new File(strDestination);
        this.totalLength = source.openConnection().getContentLength();
    }

    public int getDownloaderId() {
        return id;
    }
    
    @Override
    public void run() {
        try (BufferedInputStream inputStream = new BufferedInputStream(source.openStream());
        FileOutputStream fileOS = new FileOutputStream(this.destination);) {
            byte data[] = new byte[1024];
            int byteContent;
            while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
                fileOS.write(data, 0, byteContent);
                downloaded += byteContent;
                while(!running){
                   Downloader.yield();
                   sleep(1000);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, "Nepodarilo sa zapisovat do suporu", ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, "Interrupted", ex);
        }
    }

    public int getDownloaded() {
        return downloaded;
    }
    
    public int getTotalLength() {
        return totalLength;
    }
    
    
    public void pauseDownloading() throws InterruptedException{
        running = false;
    }
    
    public void resumeDownloading(){
        running = true;
    }
    
    public void stopDownloading(){
        // sem by sa dalo dat len kill thread s tym ze by sa nejako serializovala tato trieda
    }
    
    public void resumeDOwnloading2(){
        // tuto by sa mohol spustit thread odtial kde skoncil
    }

    
}
