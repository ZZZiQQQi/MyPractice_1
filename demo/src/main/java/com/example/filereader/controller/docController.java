package com.example.filereader.controller;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/doc")
public class docController {

    @GetMapping("/read")
    public String read(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             XWPFDocument document = new XWPFDocument(fis)) {
            document.getParagraphs().forEach(paragraph ->
                    System.out.println(paragraph.getText()));
        }
        return "ok";
    }
}
