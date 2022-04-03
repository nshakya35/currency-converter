package com.java.npl.microservices.currencyconversionservice.model;

public class SellExchangeModel {

	private String exchangeRate;

	private String dateOfPublication;

	public SellExchangeModel(String exchangeRate, String dateOfPublication) {
		super();
		this.exchangeRate = exchangeRate;
		this.dateOfPublication = dateOfPublication;
	}

	public String getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(String dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

}
