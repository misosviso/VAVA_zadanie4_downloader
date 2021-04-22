/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import sk.stu.fiit.models.DownloadManager;
import sk.stu.fiit.models.DownloadProgressChecker;
import sk.stu.fiit.models.Downloader;
import sk.stu.fiit.views.MainView;

/**
 *
 * @author Admin
 */
public class DownloadManagerController{
    
    private final DownloadManager downloadManager = DownloadManager.getDownloadManager();
    private final MainView view;

    public DownloadManagerController(MainView view) {
        this.view = view;
    }
    
    public void download(String urlString, String pathString,JProgressBar progressBar, JLabel description) throws MalformedURLException, IOException {
        Downloader objDownloader = downloadManager.download(urlString, pathString);
        DownloadProgressChecker downloadProgressChecker = new DownloadProgressChecker(objDownloader, this.view);
        downloadProgressChecker.start();
    }
    
    public void pauseDownloading(int ID) throws InterruptedException, IOException {
        downloadManager.pauseDownloading(ID);
    }

    public void resumeDownloading(int ID) throws InterruptedException, IOException {
        downloadManager.resumeDownloading(ID);
    }

}
