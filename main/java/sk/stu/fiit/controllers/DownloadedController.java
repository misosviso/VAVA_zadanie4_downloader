/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.controllers;

import javax.swing.table.DefaultTableModel;
import sk.stu.fiit.models.DownloadedManager;

/**
 *
 * @author Admin
 */
public class DownloadedController implements CustomTableModel{
    
    private final DownloadedManager manager = DownloadedManager.getDownloadedManager();
    
    public DefaultTableModel getHistory(){
        return new DefaultTableModel(getTableData(this.manager.getDownloaded()), 
                new Object[]{"ID", "Dátum", "URL adresa", "Destinácia", "Status", "Veľkosť", "Trvanie"});
    }
    
}
