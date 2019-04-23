package com.chinasofti.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Po {
	private String uuId;
	private String oTime;
	private int cardId;
	private double getMoney;
	private Map<Food,Integer> goods;
	
	public Po() {
		super();
	}

	public Po(String uuId, int cardId, double getMoney, Map<Food,Integer> goods) {
		super();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		oTime=df.format(new Date());
		this.uuId = uuId;
		this.oTime = df.format(new Date());
		this.cardId=cardId;
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

	public int getCardID() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
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
