package com.chinasofti.util;

import java.util.Scanner;
//工具类 用于处理用户输入信息的验证
public class UserInput {
	//接收用户输入的内容String
	public String getString( String s){
		Scanner sc=new Scanner(System.in);
		System.out.println(s);
		return sc.next();
	}
	//接收整数
	public int getInt(String s){
		while(true){
			try {
				Scanner sc=new Scanner(System.in);
				System.out.println(s);
				return sc.nextInt();
			} catch (java.lang.Exception e) {
				System.out.println("输入有误，请重新输入一个整型数：");
			}
		}
	}
	//接收浮点数
	public double getDouble(String s){
		while(true){
			try {
				Scanner sc=new Scanner(System.in);
				System.out.println(s);
				return sc.nextDouble();
			} catch (java.lang.Exception e) {
				System.out.println("输入有误，请重新输入：");
			}
		}
	}

}
