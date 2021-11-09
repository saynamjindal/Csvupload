//package com.moglix.csvFile.helper;
//
//import java.io.BufferedReader;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVParser;
//import org.apache.commons.csv.CSVPrinter;
//import org.apache.commons.csv.CSVRecord;
//import org.apache.commons.csv.QuoteMode;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.moglix.csvFile.dto.Csv;
//
//public class CsvHelper {
//	
//	 public static String TYPE = "text/csv";
//	  static String[] HEADERs = { "Id", "Title", "Description", "Published" };
//
//	  public static boolean hasCSVFormat(MultipartFile file) {
//
//	    if (!TYPE.equals(file.getContentType())) {
//	      return false;
//	    }
//
//	    return true;
//	  }
//
//	  public static List<Csv> csvTocsvlist(InputStream is) {
//	    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//	        CSVParser csvParser = new CSVParser(fileReader,
//	            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
//
//	      List<Csv> csvlist = new ArrayList<Csv>();
//
//	      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
//
//	      for (CSVRecord csvRecord : csvRecords) {
//	    	  Csv csv = new Csv(
//	              Long.parseLong(csvRecord.get("Id")),
//	              csvRecord.get("Title"),
//	              csvRecord.get("Description"),
//	              Boolean.parseBoolean(csvRecord.get("Published"))
//	            );
//
//	    	  csvlist.add(csv);
//	      }
//
//	      return csvlist;
//	    } catch (IOException e) {
//	      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
//	    }
//	  }
//	  
//	  public static ByteArrayInputStream csvlistToCSV(List<Csv> csvlist) {
//		    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
//
//		    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
//		        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
//		      for (Csv csv : csvlist) {
//		        List<String> data = Arrays.asList(
//		              String.valueOf(csv.getId()),
//		              csv.getTitle(),
//		              csv.getDescription(),
//		              String.valueOf(csv.isPublished())
//		            );
//
//		        csvPrinter.printRecord(data);
//		      }
//
//		      csvPrinter.flush();
//		      return new ByteArrayInputStream(out.toByteArray());
//		    } catch (IOException e) {
//		      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
//		    }
//		  }
//
//
//
//}
