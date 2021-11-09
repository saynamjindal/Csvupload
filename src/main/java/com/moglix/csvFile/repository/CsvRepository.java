package com.moglix.csvFile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.moglix.csvFile.dto.Csv;
@Repository
public interface CsvRepository extends JpaRepository<Csv, String>{
	
	@Query(value = "select * from csv_table limit :x ", nativeQuery = true)
	List<Csv> getCsvByLimit(@Param("x")int x);

}
