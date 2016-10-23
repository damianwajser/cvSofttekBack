package com.softtek.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.text.Normalizer;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.model.Person;
import com.softtek.repository.PersonRepository;

@RestController
@RequestMapping("/api/process")
public class ProcessController {

	@Autowired
	PersonRepository repository;
	
    @RequestMapping(method = RequestMethod.GET)
    public String ok() {
    	File file = null;
    	WordExtractor extractor = null;
    	try {
    		StringBuilder result = new StringBuilder();
    		file = new File("c:\\cv.doc");
    		FileInputStream fis = new FileInputStream(file.getAbsolutePath());
    		HWPFDocument document = new HWPFDocument(fis);
    		extractor = new WordExtractor(document);
    		String[] fileData = extractor.getParagraphText();
    		for (int i = 0; i < fileData.length; i++) {
    			if (StringUtils.isNoneBlank(fileData[i])){
    				String line = Normalizer.normalize(fileData[i], Normalizer.Form.NFKC) + " ";
    				result.append(line);
    			}
    		}
    		for (int i = 0; i < 5000; i++) {
    			Person persona = new Person();
        		persona.setCvString(result.toString());
        		persona.setName("Francisco"+1);
        		repository.save(persona);
        		System.out.println(i);
			}
    		
    	} catch (Exception exep) {
    		exep.printStackTrace();
    	}
    	return "ok";
    }
	
}
