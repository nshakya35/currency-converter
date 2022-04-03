package com.java.npl.microservices.currencyconversionservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class CurrencyConversionModel {

	private String table;
	private String currency;
	private String code;
	@JsonProperty("rates")
	private JsonNode rates;

	public CurrencyConversionModel() {
		super();
	}

	public CurrencyConversionModel(String table, String currency, String code, JsonNode rates) {
		super();
		this.table = table;
		this.currency = currency;
		this.code = code;
		this.rates = rates;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public JsonNode getRates() {
		return rates;
	}

	public void setRates(JsonNode rates) {
		this.rates = rates;
	}

}
