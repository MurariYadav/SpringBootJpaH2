package org.sathyatech.raghu.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long prodId;
	private String prodCode;
	private Double prodCost;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfMfg;
	private Boolean available;

	public Product() {
		super();
	}

	public Product(String prodCode, Double prodCost, Date dateOfMfg, Boolean available) {
		super();
		this.prodCode = prodCode;
		this.prodCost = prodCost;
		this.dateOfMfg = dateOfMfg;
		this.available = available;
	}

	public Long getProdId() {
		return prodId;
	}
	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public Double getProdCost() {
		return prodCost;
	}
	public void setProdCost(Double prodCost) {
		this.prodCost = prodCost;
	}
	public Date getDateOfMfg() {
		return dateOfMfg;
	}
	public void setDateOfMfg(Date dateOfMfg) {
		this.dateOfMfg = dateOfMfg;
	}

	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodCode=" + prodCode + ", prodCost=" + prodCost + ", dateOfMfg="
				+ dateOfMfg + ", available=" + available + "]";
	}
	

}
