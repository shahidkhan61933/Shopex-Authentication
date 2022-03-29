package com.auth.webservice.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "eshopee_customers")
public class Customer {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_generator")
	@SequenceGenerator(name = "id_generator", initialValue = 1, allocationSize = 1, sequenceName = "id_seq")
	private long id;
	

	@Column(name = "name")
	@NotBlank(message = "Please enter name")
	@Size(min = 10, message = "name should have atleast 10 characters")
	private String name;
	
	@Column(name = "phone")
	@NotNull
	private long phone;
	
	@NotBlank
	@Size(min = 10, message = "Email should have atleast 10 characters")
	@Email
	@Column(name = "email")
	private String email;
	
	@NotBlank(message = "Address is empty ")
	@Column(name = "address")
	private String address;

	@Column(name = "age")
	@NotNull
	private int age;
	
	@Column(name = "paymentType")
	@NotBlank
	@Size(min = 4, message = "paymentType always atleast 10 characters")
	private String paymentType;

	@Column(name = "createdAt")
	private Date createdAt = new Date();
	
	@OneToOne(cascade = CascadeType.ALL)
	private Wallet wallet;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private House house;

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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}
	

}
