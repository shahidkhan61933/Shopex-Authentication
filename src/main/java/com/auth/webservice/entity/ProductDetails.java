package com.auth.webservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "eshopee_productdetails")
public class ProductDetails {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	@Column(name = "name")
	@NotBlank
	private String name;
	
	@Column(name = "description")
	@NotBlank
	private String description;
	
	@Column(name = "price")
	@NotNull
	private long price;
	
	@Column(name = "brand")
	@NotBlank
	private String brand;
	
	@Column(name = "ceated_at")
	private Date ceatedAt = new Date();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Date getCeatedAt() {
		return ceatedAt;
	}

	public void setCeatedAt(Date ceatedAt) {
		this.ceatedAt = ceatedAt;
	}
	
	

}
