/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.controllers;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import sk.stu.fiit.models.DownloadRecord;
import sk.stu.fiit.models.RecordManager;
import sk.stu.fiit.models.TableModelItem;
import sk.stu.fiit.models.unzipping.Unzipper;

/**
 *
 * @author Admin
 */
public class RecordController implements CustomTableModel{
    
    private final RecordManager manager = RecordManager.getDownloadedManager();
    
    public DefaultTableModel getDownloadRecords(){
        return new DefaultTableModel(getTableData(this.manager.getDownloaded()), 
                new Object[]{"ID", "Dátum", "URL adresa", "Destinácia", "Status", "Veľkosť", "Trvanie"});
    }
    
    public DefaultTableModel getDownloadedZips() throws IOException{
        List<TableModelItem> zipDownloads = new LinkedList<>();
        for (DownloadRecord record : (List<DownloadRecord>) (Object) this.manager.getDownloaded()) {
            if(Unzipper.isZip(record.getFilePath())){
                zipDownloads.add(record);
            }
        }
        return new DefaultTableModel(getTableData(zipDownloads), 
                new Object[]{"ID", "Dátum", "URL adresa", "Destinácia", "Status", "Veľkosť", "Trvanie"});
    }
}
