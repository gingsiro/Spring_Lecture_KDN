package com.kdn.model.domain;

import java.io.Serializable;

public class Goods implements Serializable {
	private static final long serialVersionUID = 1L;
	private String proname;
	private int proprice;
	private int quantity;
	private int totalprice;
	
	public Goods() {
	}
	
	public Goods(String proName, int proprice, int quantity) {
		this.proname = proName;
		this.proprice = proprice;
		this.quantity = quantity;
	}

	public String getProname() {
		return proname;
	}

	public void setProname(String proName) {
		this.proname = proName;
	}
 
	public int getProprice() {
		return proprice;
	}

	public void setProprice(int proprice) {
		this.proprice = proprice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalprice() {
		return quantity*proprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("proname=").append(proname).append(", proprice=").append(proprice).append(", quantity=")
				.append(quantity).append(", totalprice=").append(totalprice);
		return builder.toString();
	}	
}
