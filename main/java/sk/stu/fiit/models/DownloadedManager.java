/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.models;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DownloadedManager {

    public static DownloadedManager getDownloadedManager() {
        if(instanceOfSelf == null){
            instanceOfSelf = new DownloadedManager();
        }
        return instanceOfSelf;
    }
    
    private final List<DownloadedRecord> downloaded = new LinkedList<>();
    private static DownloadedManager instanceOfSelf;

    private DownloadedManager() {
    }

    public List<TableModelItem> getDownloaded() {
        return (List<TableModelItem>) (Object) downloaded;
    }
    
}
