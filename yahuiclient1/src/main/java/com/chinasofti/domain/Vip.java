package com.chinasofti.domain;

import java.io.Serializable;

public class Vip implements Serializable{
	private int cardId;
	private int lev;
	private double balance;
	private int cardState;
	private double dis;
	
	public Vip(int cardId, int lev, double balance, int cardState, double dis) {
		super();
		this.cardId = cardId;
		this.lev = lev;
		this.balance = balance;
		this.cardState = cardState;
		this.dis = dis;
		
	}
	
	public Vip() {
		super();
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public int getLev() {
		return lev;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getcardState() {
		return cardState;
	}

	public void setState(int cardState) {
		this.cardState = cardState;
	}

	public int getCardState() {
		return cardState;
	}

	public void setCardState(int cardState) {
		this.cardState = cardState;
	}

	public double getDis() {
		return dis;
	}

	public void setDis(double dis) {
		this.dis = dis;
	}

}
