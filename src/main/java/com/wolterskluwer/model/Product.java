package com.wolterskluwer.model;

import java.util.Date;
import javax.persistence.*;

import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Danilo Franco
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private int productId;
	@Column(name = "description", nullable = false)
	private String description;
	@Column(name = "category", nullable = false)
	@Enumerated(EnumType.STRING)
	private Category category;
	@Column(name = "quantity", nullable = false)
	private int quantity;
	@Column(name = "price", nullable = false)
	private double price;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "prod_date", nullable = true)
	@LastModifiedDate
	private Date date;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	
	
}
