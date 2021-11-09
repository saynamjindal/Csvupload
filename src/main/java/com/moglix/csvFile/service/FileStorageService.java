package com.moglix.csvFile.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.moglix.csvFile.config.FileStorageProperties;
@Service
public class FileStorageService {
	
	private final Path fileStorageLocation;
	@Autowired
	ServletContext servletContext;

	@Autowired
	public FileStorageService(FileStorageProperties properties) {
		this.fileStorageLocation = Paths.get(properties.uploadDir).toAbsolutePath().normalize();

		try {
			Files.createDirectories(fileStorageLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public File getFileStorageLocation(String dir, String filename) {
		String uploadPath = this.fileStorageLocation + dir;
		File file = new File(uploadPath);
		if (!file.exists()) {
			file.mkdirs();
			file.setExecutable(true, false);
			file.setReadable(true, false);
			file.setWritable(false, false);
		}
		file = new File(uploadPath + "/" + filename);
		return file;
	}

}
