package com.example.vulnerable;

import java.io.*;
import java.util.zip.*;

/**
 * Zip Slip - Set 25
 * CWE-22: Path Traversal via Archive
 */
public class ZipSlipSet25 {
    
    public void vuln241(String zipFile, String dest) throws Exception {
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            File file = new File(dest, entry.getName());
            FileOutputStream fos = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            fos.close();
        }
        zis.close();
    }
    
    public void vuln242(ZipFile zip, String outputDir) throws Exception {
        java.util.Enumeration<? extends ZipEntry> entries = zip.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            File file = new File(outputDir + File.separator + entry.getName());
            new FileOutputStream(file);
        }
    }
    
    public void vuln243(String archive, String target) throws Exception {
        ZipInputStream zin = new ZipInputStream(new FileInputStream(archive));
        ZipEntry e;
        while ((e = zin.getNextEntry()) != null) {
            FileOutputStream out = new FileOutputStream(target + "/" + e.getName());
            byte[] b = new byte[1024];
            int len;
            while ((len = zin.read(b)) > 0) {
                out.write(b, 0, len);
            }
            out.close();
        }
    }
    
    public void vuln244(File zipFile, File destDir) throws Exception {
        ZipFile zip = new ZipFile(zipFile);
        java.util.Enumeration<? extends ZipEntry> entries = zip.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            File outFile = new File(destDir, entry.getName());
            InputStream is = zip.getInputStream(entry);
            FileOutputStream fos = new FileOutputStream(outFile);
            byte[] buf = new byte[4096];
            int n;
            while ((n = is.read(buf)) > 0) {
                fos.write(buf, 0, n);
            }
            fos.close();
        }
    }
    
    public void vuln245(String zip, String out) throws Exception {
        ZipInputStream z = new ZipInputStream(new FileInputStream(zip));
        ZipEntry entry = z.getNextEntry();
        while (entry != null) {
            File f = new File(out + "/" + entry.getName());
            new FileOutputStream(f).write(z.readAllBytes());
            entry = z.getNextEntry();
        }
    }
    
    public void vuln246(InputStream zipStream, String destination) throws Exception {
        ZipInputStream zis = new ZipInputStream(zipStream);
        ZipEntry ze;
        while ((ze = zis.getNextEntry()) != null) {
            File newFile = new File(destination + File.separator + ze.getName());
            FileOutputStream fos = new FileOutputStream(newFile);
            fos.write(zis.readAllBytes());
            fos.close();
        }
    }
    
    public void vuln247(String zipPath, String extractPath) throws Exception {
        ZipFile zf = new ZipFile(zipPath);
        java.util.Enumeration<? extends ZipEntry> ents = zf.entries();
        while (ents.hasMoreElements()) {
            ZipEntry ent = ents.nextElement();
            String name = ent.getName();
            File file = new File(extractPath, name);
            InputStream in = zf.getInputStream(ent);
            OutputStream out = new FileOutputStream(file);
            byte[] buffer = new byte[8192];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.close();
        }
    }
    
    public void vuln248(File archive, String dir) throws Exception {
        ZipInputStream stream = new ZipInputStream(new FileInputStream(archive));
        ZipEntry item;
        while ((item = stream.getNextEntry()) != null) {
            File output = new File(dir + "/" + item.getName());
            FileOutputStream writer = new FileOutputStream(output);
            writer.write(stream.readAllBytes());
            writer.close();
        }
    }
    
    public void vuln249(String zipFileName, String destDirectory) throws Exception {
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFileName));
        ZipEntry entry = zipIn.getNextEntry();
        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            FileOutputStream fos = new FileOutputStream(filePath);
            byte[] bytes = new byte[4096];
            int read;
            while ((read = zipIn.read(bytes)) != -1) {
                fos.write(bytes, 0, read);
            }
            fos.close();
            entry = zipIn.getNextEntry();
        }
    }
    
    public void vuln250(InputStream input, File outputDirectory) throws Exception {
        ZipInputStream zip = new ZipInputStream(input);
        ZipEntry zipEntry;
        while ((zipEntry = zip.getNextEntry()) != null) {
            File destFile = new File(outputDirectory, zipEntry.getName());
            OutputStream os = new FileOutputStream(destFile);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = zip.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
        }
    }
}
