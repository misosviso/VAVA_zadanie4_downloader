/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sk.stu.fiit.models.DownloadingManager;
import sk.stu.fiit.models.Downloader;

/**
 *
 * @author Admin
 */
public class Serializer {
    
    public static void serialize(DownloadingManager objDM) throws IOException{
        String filename = "downloaderManager.txt";
        File objSerializationFile = new File(filename);
        
        try (FileOutputStream fileOutputStream = new FileOutputStream(objSerializationFile); 
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(objDM);
        }
    }
    
    public static Downloader load(int ID_Downloader) throws IOException{
        String filename = "downloader" + ID_Downloader + ".txt";
        File objSerializationFile = new File(filename);
        
        try (FileInputStream fileInputStream = new FileInputStream(objSerializationFile); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            while(true){
                Downloader objDownloader = (Downloader) objectInputStream.readObject();
                if(objDownloader.getId() == ID_Downloader){
                    return objDownloader;
                }
            }
        } catch (ClassNotFoundException ex) {
            return null;
        }
    }
    
    
 
    
}
