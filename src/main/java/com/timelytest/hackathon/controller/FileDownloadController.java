package com.timelytest.hackathon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/download")
public class FileDownloadController {
    @RequestMapping("/file")
    public String downloadFile(HttpServletResponse response,String url){
        return null;
    }
}
