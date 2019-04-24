package com.chinasofti.domain;

import java.io.Serializable;

public class Employee implements Serializable{
	private int empId;
	private String empName;
	private String account;
	private String password;
	private int mgr;
	
	public Employee(int empId, String empName, String account, String password, int mgr) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.account = account;
		this.password = password;
		this.mgr = mgr;
	}
	
	public Employee() {
		super();
	}
	
	public int getEmpId() {
		return empId;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
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
	
	public int getMgr() {
		return mgr;
	}
	
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	
	@Override
	public String toString() {
		String m=(this.mgr == 0?"普通员工":"经理");
		return this.empId+"\t"+this.empName+"\t"+this.account+"\t"+m;
	}
}
