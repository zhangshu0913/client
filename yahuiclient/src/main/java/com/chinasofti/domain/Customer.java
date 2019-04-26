package com.chinasofti.domain;

import java.io.Serializable;

public class Customer implements Serializable{
	private int userId;
	private String userName;
	private String account;
	private String password;
	private int userState;
	private Vip v;

	public Customer(int userId, String userName, String account, String password, int userState, Vip v) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.account = account;
		this.password = password;
		this.userState = userState;
		this.v = v;
	}
	
	public Customer() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserState() {
		return userState;
	}

	public void setUserState(int userState) {
		this.userState = userState;
	}

	public Vip getV() {
		return v;
	}

	public void setV(Vip v) {
		this.v = v;
	}

	@Override
	public String toString() {
		if(this.v.getCardId()==0){
			return "客户编号:" + userId + "\n客户姓名:" + userName + 
					"\n账号:" + account + "\n用户状态:" + (this.userState ==0?"已冻结":"正常");
		}else{
			return "客户编号:" + userId + "\n客户姓名:" + userName + "\n账号:" + account + "\n用户状态:" + (userState==0?"已冻结":"正常")
					+ "\n会员卡号:" + v.getCardId() +"\n会员卡状态"+(v.getCardState() ==0?"已挂失":"正常")+"\n会员等级:"+v.getLev()+"\n余额:"+v.getBalance();
		}
		
	}
	
	
}
