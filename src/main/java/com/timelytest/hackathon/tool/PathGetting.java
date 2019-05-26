package com.timelytest.hackathon.tool;

import java.io.File;

public class PathGetting {
    public String getPath(){
        return System.getProperty("user.dir")+ File.separator +"file";
    }
    public String getUrl(String fileName){
        File[] files=new File(getPath()).listFiles();
        int id=0;
        if(files!=null){
            id=files.length;
        }
        return id+"+"+fileName;
    }
}
