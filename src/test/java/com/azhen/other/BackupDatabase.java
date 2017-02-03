package com.azhen.other;

import java.io.*;

/**
 * Created by azhen on 17-1-26.
 */
public class BackupDatabase {
    /**
     *
        #!/bin/bash
        mysqldump -uqcmr -p'qcmr!@#' qcmr > /home/azhen/qcmr.sql
     */
    public void backup() {
        //String back = "mysqldump -u" + user + " -p'" + password + "' --opt " + database + " > " + filepath;
        //String back = "mysqldump -u" + user + " -p'" + password + "'  " + database + " > " + filepath;
        String back = "mysqldump -h localhost -uqcmr -p'qcmr!@#' --skip-lock-tables qcmr > /home/azhen/qcmr.sql";
        System.out.println(back);
        try {
            Process process = Runtime.getRuntime().exec(back);
            InputStreamReader inputStreamReader = new InputStreamReader(process.getErrorStream(), "utf8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while((line = bufferedReader.readLine())!= null){
                System.out.println(line);
            }
            try {
                int rtnVal = process.waitFor();
                if(0 == rtnVal) {
                    System.out.printf("备份成功");
                } else {
                    System.out.println("备份失败");
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backup1() {
        try {
            Process process = Runtime.getRuntime().exec("/bin/sh /home/azhen/backup.sh");
            //InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), "utf8");
            InputStreamReader inputStreamReader = new InputStreamReader(process.getErrorStream(), "utf8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while((line = bufferedReader.readLine())!= null){
                System.out.println(line);
            }

            try {
                int rtnVal = process.waitFor();
                if(0 == rtnVal) {
                    System.out.printf("备份成功");
                } else {
                    System.out.println("备份失败");
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        String user = "qcmr";
        String password = "qcmr!@#";
        String database = "qcmr";
        String filepath = "/home/azhen/qcmr.sql";
        String createDb = "mysqladmin -u" + user + " -p'" + password + "' create" + database;
        String store = "mysql -u" + user + " -p'" + password + "' " + database + " < " + filepath;
        System.out.println(createDb);
        System.out.println(store);
        try {
            Process process = Runtime.getRuntime().exec(createDb);
            process.waitFor();
            Runtime.getRuntime().exec(store);
            System.out.println("数据已从 " + filepath + " 导入到数据库中");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        BackupDatabase backupDatabase = new BackupDatabase();
        backupDatabase.backup();
    }
}
