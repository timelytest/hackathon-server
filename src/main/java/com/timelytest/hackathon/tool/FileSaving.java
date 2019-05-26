package com.timelytest.hackathon.tool;

import com.timelytest.hackathon.enumeration.Message;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class FileSaving {
    public String saveFile(MultipartFile multipartFile){
        String url="";
        try {
            PathGetting pathGetting=new PathGetting();
            url = pathGetting.getUrl(multipartFile.getOriginalFilename().toString());
            BufferedOutputStream out = new BufferedOutputStream(
                    new FileOutputStream(new File(pathGetting.getPath()+File.separator+url)));
            out.write(multipartFile.getBytes());
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
            return Message.FAIL.toString();
        }
        return url;
    }
}
