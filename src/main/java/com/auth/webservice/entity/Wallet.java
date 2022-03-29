package com.auth.webservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "eshopee_wallet")
public class Wallet {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;

	@Column(name = "balance")
	private double balance;

	@Column(name = "status")
	private String status;

	@Column(name = "acc_limit")
	private double accLimit;

	@Column(name = "kyc_status")
	private String kycStatus;

	@Column(name = "prime_acc_no")
	private long primeAccNo;

	@Column(name = "created_at")
	private Date createdAt = new Date();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public double getAccLimit() {
		return accLimit;
	}

	public void setAccLimit(double accLimit) {
		this.accLimit = accLimit;
	}

	public String getKycStatus() {
		return kycStatus;
	}

	public void setKycStatus(String kycStatus) {
		this.kycStatus = kycStatus;
	}

	public long getPrimeAccNo() {
		return primeAccNo;
	}

	public void setPrimeAccNo(long primeAccNo) {
		this.primeAccNo = primeAccNo;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
