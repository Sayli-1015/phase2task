package com.example.usertask.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FileUploadController {

    @GetMapping("/uploadForm")
    public String showUploadForm() {
        return "uploadForm";
    }

    @PostMapping("/upload")
    public String handleFileUpload() {
        // Handle file upload logic here
        // Return a success view or redirect to another page
        return "uploadSuccess";
    }
}
