package com.timelytest.hackathon.tool;

import java.io.File;
import java.nio.file.Paths;

public class PathGetting {
    static final String dir =  System.getProperty("user.dir")+ File.separator +"file";
    String getPath(){
        File file = new File(Paths.get(dir).toString());
        if(!file.exists())
            file = new File(Paths.get(dir).toString());
        return dir;
//        return System.getProperty("user.dir")+ File.separator +"file";
    }
    String getUrl(String fileName){
        File[] files=new File(getPath()).listFiles();
        int id=0;
        if(files!=null){
            id=files.length;
        }
        return id+"+"+fileName;
    }
}
