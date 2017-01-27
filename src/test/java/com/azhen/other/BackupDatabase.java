package com.azhen.other;

import java.io.IOException;

/**
 * Created by azhen on 17-1-26.
 */
public class BackupDatabase {
    public void backup() {
        String user = "qcmr";
        String password = "qcmr!@#";
        String database = "qcmr";
        String filepath = "/home/azhen/qcmr.sql";
        String back = "mysqldump -u" + user + " -p'" + password + "' --opt " + database + " > " + filepath;
        System.out.println(back);
        try {
            Process process = Runtime.getRuntime().exec(back);
            try {
                process.waitFor();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("数据已经导出到文件： " + filepath + " 中--" + process.exitValue());
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
