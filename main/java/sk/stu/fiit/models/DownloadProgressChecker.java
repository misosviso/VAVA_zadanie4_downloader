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
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 * Class which checks for progress
 * @author Admin
 */
public class DownloadProgressChecker extends Thread{
    
    private final File destination;
    private final Downloader objDownloader;
    private JProgressBar progressBar = null;
    private JLabel description;

    public DownloadProgressChecker(String strDestination, Downloader objDownloader, String urlSpec) throws IOException {
        this.objDownloader = objDownloader;
        this.destination = new File(strDestination);
    }

    public DownloadProgressChecker(Downloader objDownloader, String pathString, String urlString, JProgressBar progressBar, JLabel description) {
        this.objDownloader = objDownloader;
        this.destination = new File(pathString);
        this.progressBar = progressBar;
        this.description = description;
    }
    
    private void displayState(){
        this.progressBar.setValue(objDownloader.getDownloaded());
        this.description.setText(objDownloader.getDownloaded() + "/" + objDownloader.getTotalLength() + "B");
    }
    
    @Override
    public void run() {
        this.progressBar.setMaximum(objDownloader.getTotalLength());
        while(objDownloader.isAlive()){
            try {
                displayState();
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DownloadProgressChecker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        displayState();
        description.setText("Stiahnute");
    }
    
    
    
}
