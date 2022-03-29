package com.auth.webservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "eshopee_salary")
public class Salary {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id ;
	
	
	@Column(name = "name")
	@NotBlank
	private String name;
	
	@Column(name = "salary")
	private double salary;
	
	@Column(name = "net_salary")
	
	private double netSalary ;
	
	@Column(name = "transffer_bank")
	@NotBlank
	private String  transfferBank;
	
	@Column(name = "transaction_type")
	@NotBlank
	private String transactionType;
	
	@Column(name = "created_at")
	private Date createdAt=new Date();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}

	public String getTransfferBank() {
		return transfferBank;
	}

	public void setTransfferBank(String transfferBank) {
		this.transfferBank = transfferBank;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	

}
