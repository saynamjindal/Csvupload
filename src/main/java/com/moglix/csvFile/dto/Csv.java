package com.moglix.csvFile.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "csv_table")
public class Csv {
	
	

	@Id
	private String msn;
	private String gtin;
	private String identifierExists;
	private String customLabel2;
	private String customLabel3;
	private String customLabel4;
	private String promotionId;
	private String isGoogleActive;
	private String isFacebookActive;
	private String isCriteoActive;
	private String availability;
	public String getMsn() {
		return msn;
	}
	public void setMsn(String msn) {
		this.msn = msn;
	}
	public String getGtin() {
		return gtin;
	}
	public void setGtin(String gtin) {
		this.gtin = gtin;
	}
	public String getIdentifierExists() {
		return identifierExists;
	}
	public void setIdentifierExists(String identifierExists) {
		this.identifierExists = identifierExists;
	}
	public String getCustomLabel2() {
		return customLabel2;
	}
	public void setCustomLabel2(String customLabel2) {
		this.customLabel2 = customLabel2;
	}
	public String getCustomLabel3() {
		return customLabel3;
	}
	public void setCustomLabel3(String customLabel3) {
		this.customLabel3 = customLabel3;
	}
	public String getCustomLabel4() {
		return customLabel4;
	}
	public void setCustomLabel4(String customLabel4) {
		this.customLabel4 = customLabel4;
	}
	public String getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}
	public String getIsGoogleActive() {
		return isGoogleActive;
	}
	public void setIsGoogleActive(String isGoogleActive) {
		this.isGoogleActive = isGoogleActive;
	}
	public String getIsFacebookActive() {
		return isFacebookActive;
	}
	public void setIsFacebookActive(String isFacebookActive) {
		this.isFacebookActive = isFacebookActive;
	}
	public String getIsCriteoActive() {
		return isCriteoActive;
	}
	public void setIsCriteoActive(String isCriteoActive) {
		this.isCriteoActive = isCriteoActive;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	} 
	
	

}
