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
        // try with source 在执行完代码块内代码后自动关闭资源
        try (FileInputStream fis = new FileInputStream(filePath);
             XWPFDocument document = new XWPFDocument(fis)) {
            //lambda表达式简化函数式接口
            //这里默认实现的式accept方法
            //这里式 List.foreach方法注意不要和 stream 的foreach混淆
            document.getParagraphs().forEach(paragraph ->
                    System.out.println(paragraph.getText()));
        }
        return "ok";
    }
}
