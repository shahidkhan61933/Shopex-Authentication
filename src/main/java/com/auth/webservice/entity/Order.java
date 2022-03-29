package com.auth.webservice.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;

/**
 * @author khanw
 *
 */
@Entity
@Table(name = "eshopee_orders")
public class Order {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_generator")
	@SequenceGenerator(name = "id_generator", initialValue = 1, allocationSize = 1, sequenceName = "id_seq")
	private long Id;
	
	@Column(name = "ordername")
	private String ordername;
	
	@Column(name = "paymentType")
	private String paymentType;

	@Column(name = "customerName")
	@Size(min = 10, message = "name should have atleast 10 characters")
	private String customerName;

	@Column(name = "totalItem")
	private int totalItem;
	
	@Column(name = "totalBill")
	private long totalBill;
	
	@Column(name = "advance")
	private long advance;
	
	@Column(name = "pendingBalance")
	private long pendingBalance;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "createdAt")
	private Date createdAt;

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private List<Product> products;
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	public long getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(long totalBill) {
		this.totalBill = totalBill;
	}

	public long getAdvance() {
		return advance;
	}

	public void setAdvance(long advance) {
		this.advance = advance;
	}

	public long getPendingBalance() {
		return pendingBalance;
	}

	public void setPendingBalance(long pendingBalance) {
		this.pendingBalance = pendingBalance;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
