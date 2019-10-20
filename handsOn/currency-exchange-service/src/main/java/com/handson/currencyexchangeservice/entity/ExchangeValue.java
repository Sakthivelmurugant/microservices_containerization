package com.handson.currencyexchangeservice.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="exchange_value")
public class ExchangeValue {
	
	@Id
	private Long id;
	
	@Column(name="convert_from")
	private String from;
	
	@Column(name="convert_to")
	private String to;
	
	@Column(name="conversion_multiple")
	private BigDecimal conversionMultiple;
	
	@Column(name="port_no")
	private int portNo;	
	
	public int getPortNo() {
		return portNo;
	}

	public void setPortNo(int portNo) {
		this.portNo = portNo;
	}

	public ExchangeValue( ) {}
	
	public ExchangeValue(Long id, String convertFrom, String convertTo, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = convertFrom;
		this.to = convertTo;
		this.conversionMultiple = conversionMultiple;
	}
	@Override
	public String toString() {
		return "ExchangeValue [id=" + id + ", convertFrom=" + from + ", convertTo=" + to
				+ ", conversionMultiple=" + conversionMultiple + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getConvertFrom() {
		return from;
	}
	public void setConvertFrom(String convertFrom) {
		this.from = convertFrom;
	}
	public String getConvertTo() {
		return to;
	}
	public void setConvertTo(String convertTo) {
		this.to = convertTo;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	
	

}
