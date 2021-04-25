/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.models;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class RecordManager {

    public static RecordManager getDownloadedManager() {
        if(instanceOfSelf == null){
            instanceOfSelf = new RecordManager();
        }
        return instanceOfSelf;
    }
    
    private final List<DownloadRecord> records = new LinkedList<>();
    private static RecordManager instanceOfSelf;

    private RecordManager() {
    }

    public List<TableModelItem> getDownloaded() {
        return (List<TableModelItem>) (Object) records;
    }

    void addRecord(Downloader objDownloader) {
        DownloadRecord objDownloadedRecord = new DownloadRecord(objDownloader);
        records.add(objDownloadedRecord);
        System.out.println(Arrays.toString(objDownloadedRecord.getDataRow()));
    }
    
    public static void main(String[] args) {
        
        try {
            String source = "https://www.sample-videos.com/pdf/Sample-pdf-5mb.pdf";
            String destination = "C:\\Users\\42194\\Desktop\\sample_pdf.pdf";
            
            DownloadManager objDownloadingManager = DownloadManager.getDownloadManager();
            objDownloadingManager.download(source, destination);
        } catch (IOException ex) {
            Logger.getLogger(RecordManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
