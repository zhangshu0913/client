package com.chinasofti.view;


public class View {
	
	public void println(String msg) {
		System.out.println(msg);
	}
	//系统登录界面显示
	public void welcome(){
		System.out.println("\t欢迎来到亚惠餐厅");
		System.out.println("------------------------------");
		System.out.println("1.客户登录");
		System.out.println("2.员工登录");
		System.out.println("3.新用户注册");
	}
	//客户登录后功能界面
	public void user(){
		System.out.println("<<<<");
		System.out.println("1.查看个人信息");
		System.out.println("2.修改个人信息");
		System.out.println("3.点餐服务");
		System.out.println("0.退出");
		System.out.println("<<<<");
	}
	//普通员工界面
	public void emp(){
		System.out.println("<<<<");
		System.out.println("1.查看个人信息");
		System.out.println("2.修改个人信息");
		System.out.println("3.办理vip业务");
		System.out.println("4.会员卡挂失");	
		System.out.println("5.会员卡充值");
		System.out.println("0.退出");
		System.out.println("<<<<");
	}
	//经理管理功能总界面
	public void manager(){
		System.out.println("<<<<");
		System.out.println("1.员工管理");
		System.out.println("2.客户管理");
		System.out.println("3.菜品管理");
		System.out.println("0.退出");
		System.out.println("<<<<");
		
	}
	//经理功能   员工管理功能
	public void manEmp(){
		System.out.println(">>>>员工管理<<<<");
		System.out.println("1.添加员工");
		System.out.println("2.删除员工");
		System.out.println("3.查看员工");
		System.out.println("0.返回上一层");
		System.out.println("<<<<");
	}
	//经理功能   客户管理功能
	public void manUser(){
		System.out.println(">>>>客户管理<<<<");
		System.out.println("1.会员卡补办");
		System.out.println("2.冻结客户");
		System.out.println("3.会员折扣");
		System.out.println("4.账户解冻");
		System.out.println("0.返回上一层");
		System.out.println(">>>>");
	}
	//经理功能   菜品管理功能
	public void manFood(){
		System.out.println(">>>>菜品管理<<<<");
		System.out.println("1.添加菜品");
		System.out.println("2.修改菜品");
		System.out.println("3.查看菜品");
		System.out.println("4.删除菜品");
		System.out.println("5.销量统计");
		System.out.println("0.返回上一层");
		System.out.println(">>>>");
	}
	

}
