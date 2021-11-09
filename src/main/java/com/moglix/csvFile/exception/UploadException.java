package com.moglix.csvFile.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.moglix.csvFile.model.ResponseModel;

@ControllerAdvice
public class UploadException extends ResponseEntityExceptionHandler {

	  @ExceptionHandler(MaxUploadSizeExceededException.class)
	  public ResponseEntity handleMaxSizeException(MaxUploadSizeExceededException exc) {
	    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseModel("File too large!"));
	  }
}
