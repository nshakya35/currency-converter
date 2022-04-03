package com.java.npl.microservices.currencyconversionservice.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;

//@Entity
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
public class Rates {

	private String no;
	private String effectiveDate;
	private BigDecimal bid;
	private BigDecimal ask;

	public Rates() {
		super();
	}

	public Rates(String no, String effectiveDate, BigDecimal bid, BigDecimal ask) {
		super();
		this.no = no;
		this.effectiveDate = effectiveDate;
		this.bid = bid;
		this.ask = ask;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public BigDecimal getBid() {
		return bid;
	}

	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}

	public BigDecimal getAsk() {
		return ask;
	}

	public void setAsk(BigDecimal ask) {
		this.ask = ask;
	}

}
