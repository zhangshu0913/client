package com.chinasofti.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Po implements Serializable{
	private String uuId;
	private String oTime;
	private int userId;
	private double getMoney;
	private Map<Food,Integer> goods;
	
	public Po() {
		super();
	}

	public Po(String uuId, int userId, double getMoney, Map<Food,Integer> goods) {
		super();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		oTime=df.format(new Date());
		this.uuId = uuId;
		this.oTime = df.format(new Date());
		this.userId=userId;
		this.getMoney = getMoney;
		this.goods = goods;
	}

	public String getUuId() {
		return uuId;
	}

	public void setUuId(String uuId) {
		this.uuId = uuId;
	}

	public String getoTime() {
		return oTime;
	}

	public void setoTime(String oTime) {
		this.oTime = oTime;
	}

	public int getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}

	public double getGetMoney() {
		return getMoney;
	}

	public void setGetMoney(double getMoney) {
		this.getMoney = getMoney;
	}

	public Map<Food,Integer> getGoods() {
		return goods;
	}

	public void setGoods(Map<Food,Integer> goods) {
		this.goods = goods;
	}

}
