package com.chinasofti.domain;

import java.io.Serializable;

public class Food implements Serializable{
	private int fId;
	private String fName;
	private double price;
	private int tId;
	private double dis;
	
	public Food(int fId, String fName, double price, int tId, double dis) {
		super();
		this.fId = fId;
		this.fName = fName;
		this.price = price;
		this.tId = tId;
		this.dis = dis;
	}

	public Food() {
		super();
	}

	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public double getDis() {
		return dis;
	}

	public void setDis(double dis) {
		this.dis = dis;
	}

	@Override
	public String toString() {
		String b=(this.dis ==1?"无":String.valueOf(this.dis*10)+"折");
		return this.fId+"\t"+this.fName+"\t"+this.price+"\t"+this.tId+"\t"+b;
	}
	
}
