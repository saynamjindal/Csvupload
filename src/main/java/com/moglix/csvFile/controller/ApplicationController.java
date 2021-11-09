package com.moglix.csvFile.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.moglix.csvFile.dto.Csv;
import com.moglix.csvFile.model.ResponseModel;
import com.moglix.csvFile.service.CsvService;
import com.moglix.csvFile.service.FileStorageService;

@RestController
@RequestMapping
public class ApplicationController {
    @Autowired
	private FileStorageService fileStorageService;
    @Autowired
    private CsvService csvService;

@RequestMapping(value="/upload",method = RequestMethod.POST)
public ResponseModel<String> uploadfile (@RequestParam("file") MultipartFile [] files) {
	MultipartFile file=files[0];
	this.csvService.upload(file);
	System.out.println(file.getOriginalFilename());
	String filename=file.getOriginalFilename();
	String fileType=filename.substring(filename.lastIndexOf('.')+1);
	
	if(files!=null && fileType.equals("csv")) {
		System.out.println("this is csv");
		try {
			File fs=this.fileStorageService.getFileStorageLocation("/plafeed", file.getOriginalFilename());
			file.transferTo(fs);
			return new ResponseModel(true,200,"Success");
			//return "success";
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	return new ResponseModel(true,500,"Uploading failed");
}
@GetMapping("limit")
public List<Csv> getCsvByLimit(@RequestParam("offset") int offset,@RequestParam("limit") int limit){
	System.out.println("offset"+offset+","+"limit"+limit);
	return csvService.getCsvByLimit(offset,limit);
	
}

}
