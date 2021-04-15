/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.models;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
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
public class Downloader extends Thread{

    private final int id;
    private final URL source;
    private final File destination;
    private volatile boolean running = true;

    public Downloader(int id, String source, String strDestination) throws MalformedURLException{
        this.id = id;
        this.source = new URL(source);
        this.destination = new File(strDestination);
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
    
    public void pauseDownloading() throws InterruptedException{
        System.out.println("pauzujem");
        running = false;
        sleep(10000);
    }
    
    public void resumeDownloading(){
        System.out.println("resumujem");
        running = true;
    }
    
}
