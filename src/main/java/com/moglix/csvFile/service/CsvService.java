package com.moglix.csvFile.service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.moglix.csvFile.dto.Csv;
import com.moglix.csvFile.repository.CsvRepository;

@Service
public class CsvService {
	
@Autowired
private CsvRepository csvRepository;
int count=0;
	public String upload(MultipartFile file) {
		try {
			
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(file.getInputStream(),"UTF-8"));
   CSVParser csvParser=new CSVParser(bufferedReader,CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
   for(CSVRecord csvRecord:csvParser.getRecords()) {
			   Csv csv =new Csv();
			   csv.setMsn(csvRecord.get("msn").toString());
			   csv.setGtin(csvRecord.get("gtin").toString());
			   csv.setIdentifierExists(csvRecord.get("identifierExists").toString());
			   csv.setCustomLabel2(csvRecord.get("customLabel2").toString());
			   csv.setCustomLabel3(csvRecord.get("customLabel3").toString());
			   csv.setCustomLabel4(csvRecord.get("customLabel4").toString());
			   csv.setPromotionId(csvRecord.get("promotionId").toString());
			   csv.setIsGoogleActive(csvRecord.get("isGoogleActive").toString());
			   csv.setIsFacebookActive(csvRecord.get("isFacebookActive").toString());
			   csv.setIsCriteoActive(csvRecord.get("isCriteoActive").toString());
			   csv.setAvailability(csvRecord.get("availability").toString());
			   this.csvRepository.save(csv);
			   count++;
   }
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count);
		return "success";
		
	}
	public List<Csv> getCsvByLimit(int offset, int limit) {
		// TODO Auto-generated method stub
		return csvRepository.getCsvByLimit(offset);
	}
}
