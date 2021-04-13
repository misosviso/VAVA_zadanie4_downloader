/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.stu.fiit.models;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class UrlDownloader {
    
    public void download(String urlSpec, String path) throws MalformedURLException, IOException{
        URL objUrl = new URL(urlSpec);
        System.out.println("objUrl = " + objUrl.getAuthority());
        System.out.println("chomidopici");
        try (BufferedInputStream inputStream = new BufferedInputStream(objUrl.openStream());
  FileOutputStream fileOS = new FileOutputStream(path)) {
            byte data[] = new byte[1024];
            int byteContent;
            while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
                fileOS.write(data, 0, byteContent);
            }
        }
    }
    
    public static void main(String[] args) {
        UrlDownloader objDownloader = new UrlDownloader();
        String path = "C:\\Users\\42194\\OneDrive - Slovenská technická univerzita v Bratislave\\2020-2021\\LS_4\\VAVA\\projekt\\Downloader\\download.pdf";
        String url = "https://file-examples-com.github.io/uploads/2017/10/file-sample_150kB.pdf";
        try {
            objDownloader.download(url, path);
        } catch (IOException ex) {
            Logger.getLogger(UrlDownloader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
