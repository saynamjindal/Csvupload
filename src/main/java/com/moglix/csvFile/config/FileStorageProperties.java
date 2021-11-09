package com.moglix.csvFile.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix= "file")
public class FileStorageProperties {
public String uploadDir="";

public String getUploadDir() {
	return uploadDir;
}

public void setUploadDir(String uploadDir) {
	this.uploadDir = uploadDir;
}

}
