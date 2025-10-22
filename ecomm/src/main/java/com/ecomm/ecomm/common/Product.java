package com.ecomm.ecomm.common;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productid;
	private String productname;
	private double productprice;

	public Product(int productid, String productname, double productprice, int productquantity) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.productprice = productprice;
		this.productquantity = productquantity;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int productquantity;

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getProductprice() {
		return productprice;
	}

	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}

	public int getProductquantity() {
		return productquantity;
	}

	public void setProductquantity(int productquantity) {
		this.productquantity = productquantity;
	}

}
