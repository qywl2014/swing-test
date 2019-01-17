package com.wulang;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.Map;
import java.util.Properties;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void pathTest() {
        FileSystemView fileSystemView = FileSystemView.getFileSystemView();
        File file = fileSystemView.getDefaultDirectory();
        File dataBaseConfigFile = new File(file, "mbg\\data\\config.properties");
        createFile(dataBaseConfigFile);
        try {
            FileWriter fileWriter = new FileWriter(dataBaseConfigFile,true);
//            fileWriter.write("databaseConfig=[{\"host\":\"127.0.0.1\"}]\n");
//            fileWriter.close();
            FileReader fileReader=new FileReader(dataBaseConfigFile);
            Properties properties=new Properties();
            properties.load(fileReader);
            String value=properties.getProperty("databaseConfig1");
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void pathTest2() {
        createFile("C:\\Users\\Administrator\\Documents\\mbg\\123\\a.txt");
        createFile("C:\\Users\\Administrator\\Documents\\mbg\\456\\789\\a.txt");
    }

    private void createFile(String path) {
        File file = new File(path);
        mkParentDir(file);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createFile(File file) {
        mkParentDir(file);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mkParentDir(File file) {
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            mkParentDir(parentFile);
            parentFile.mkdir();
        }
    }
}
