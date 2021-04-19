/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.models;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
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
    private int totalLength = 0;
    private int downloaded = 0;
    
    
    public byte lastData[];

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
        System.out.println("downloaded = " + downloaded / 1024);
        try (BufferedInputStream inputStream = new BufferedInputStream(source.openStream());
        FileOutputStream fileOS = new FileOutputStream(this.destination);) {
            byte data[] = new byte[1024];
            int byteContent;
            while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
                fileOS.write(data, 0, byteContent);
                lastData = data;
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
    
//    public void pauseDownloading() throws InterruptedException{
//        running = false;
//    }
//    
//    public void resumeDownloading(){
//        running = true;
//    }
    
    public void pauseDownloading() throws IOException{
        System.out.println("Prerusujem, serializujem");
        interrupt();
        serialize();
    }
    
    public void serialize() throws IOException{
        String filename = "pausedDownloads.txt";
        File objSerializationFile = new File(filename);
        
        try (FileOutputStream fileOutputStream = new FileOutputStream(objSerializationFile); 
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(this);
        }
    }
    
    public static Downloader loadPaused() throws IOException{
        String filename = "pausedDownloads.txt";
        File objSerializationFile = new File(filename);
        
        try (FileInputStream fileInputStream = new FileInputStream(objSerializationFile); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (Downloader) objectInputStream.readObject();
        } catch (ClassNotFoundException ex) {
            return null;
        }
    }

    
}
