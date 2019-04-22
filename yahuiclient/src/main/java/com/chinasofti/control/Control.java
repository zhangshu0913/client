package com.chinasofti.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.chinasofti.domain.Customer;
import com.chinasofti.domain.Employee;
import com.chinasofti.domain.Food;
import com.chinasofti.domain.Po;
import com.chinasofti.domain.Vip;
import com.chinasofti.util.UserInput;
import com.chinasofti.view.View;


public class Control {
	//属性
	private View v;
	private UserInput ui;
	private static final String IP="127.0.0.1";
	private static final int PORT=9999;
	private yaHuiBiz service;
	//构造方法
	public Control() {
		this.v =new View();
		this.ui =new UserInput();
		//创建代理对象
		service=ProxyClient.getClient(yaHuiBiz.class, IP, PORT);
	}
	// 流程
	Customer c = null;
	Employee e = null;
	
	
	public void start(){
		this.v.welcome();
		int i = this.ui.getInt("请选择：");
		while (true) {
			String account = this.ui.getString("请输入账号：");
			String password = this.ui.getString("请输入密码:");
			if(i==1){
				c = this.service.cLogin(account, password);
				if(c!=null ){
					if(c.getUserState()==0){
						System.out.println("该账户被冻结，无法登陆");
					}else{
						this.v.println("欢迎"+c.getUserName()+"光临亚惠餐厅");
						break;
					}
					
				}else{
					this.v.println("用户名或密码不正确");
				}
				
			}else if(i==2){
				e = this.service.eLogin(account, password);
				if(e!=null){
					this.v.println("欢迎"+e.getEmpName());
					break;
				}
				this.v.println("用户名或密码不正确");
			}
		}
		//客户登录功能
		if(i==1){
			while(true){
				this.v.user();
				int select = this.ui.getInt("请选择：");
				if(select==0){
					this.v.println("您已退出系统！");
					System.exit(1);
				}else if(select==1){
					this.custInfo();
				}else if(select==2){
					this.updateUser();
				}else if(select==3){
					this.showFood();
				}
			}
		}
		//员工登录功能
		if(i==2){
			while(true){
				int mgr = e.getMgr();
				if(mgr==0){
					//普通员工功能
					while(true){
						this.v.emp();
						int select = this.ui.getInt("请选择：");
						if(select==0){
							this.v.println("您已退出系统！");
							System.exit(0);
						}else if(select==1){
							this.empInfo();
						}else if(select==2){
							this.updateEmp();
						}else if(select==3){
							this.getCard();
						}else if(select==4){
							this.lose();
						}else if(select==5){
							this.recharge();
						}
					}
				}else if(mgr==1){
					while(true){
						//经理处理功能
						this.v.manager();
						int select = this.ui.getInt("请选择：");
						while(true){
							if(select==0){
								this.v.println("您已退出系统！");
								System.exit(0);
							}else if(select==1){
								while(true){
									this.v.manEmp();
									select = this.ui.getInt("请选择：");
									if(select==0){
										break;
									}else if(select==1){
										this.addEmp();
									}else if(select==2){
										this.deleteEmp();
									}else if(select==3){
										this.selectAllEmp();
									}
								}
							}else if(select==2){
								while(true){
									this.v.manUser();
									select = this.ui.getInt("请选择：");
									if(select==0){
										break;
									}else if(select==1){
										this.getNew();
									}else if(select==2){
										this.congel();
									}
								}
							}else if(select==3){
								while(true){
									this.v.manFood();
									select = this.ui.getInt("请选择：");
									if(select==0){
										break;
									}else if(select==1){
										this.addFood();
									}else if(select==2){
										this.updateFood();
									}else if(select==3){
										this.selectAllFood();
									}else if(select==4){
										this.deleteFood();
									}else if(select==5){
										this.count();
									}
								}
							}
						}
					}	
				}
			}
		}
	}
	
	//员工个人信息
	private void empInfo() {
		System.out.println(e);
	}
	//客户个人信息
	private void custInfo() {
		System.out.println(c);
	}

	//统计
	private void count() {
		Map<String, Integer> m = this.service.sale();
		Set<String> s = m.keySet();
		System.out.println("菜品名称\t销量");
		for (String string : s) {
			System.out.println(s+"\t"+m.get(s));
		}
		System.out.println("顾客最喜欢的菜品:"+this.service.favorite());
	}
	//删除菜品
	private void deleteFood() {
		int id = this.ui.getInt("请输入要删除菜品编号：");
		Food f = this.service.findFoodById(id);
		if(f==null){
			this.v.println("该菜品不存在！");
			return ;
		}System.out.println(f);
		String s = this.ui.getString("是否删除:(y/n)");
		if("y".equals(s)){
			System.out.println(this.service.removeFood(id));
			return;
		}
		System.out.println("删除失败");
	}
	//查看菜品
	private void selectAllFood() {
		List<Food> list = this.service.findFood();
		if(list==null){
			System.out.println("暂时没有菜品");
			return;
		}
		this.v.println("菜品编号\t名称\t价格\t种类\t折扣");
		for (Food f : list) {
			System.out.println(f);
		}
	} 

	//修改菜品
	private void updateFood() {
		int id = this.ui.getInt("请输入要修改菜品的编号：");
		Food f = this.service.findFoodById(id);
		if(f==null){
			this.v.println("所修改菜品不存在！");
			return ;
		}
		String s = this.service.modifyFood(id, this.ui.getString("请输入菜品名称"), 
				this.ui.getDouble("请输入菜品价格："),
				this.ui.getInt("请输入菜品种类："),
				this.ui.getDouble("请输入菜品折扣："));
		System.out.println(s);
	}
	//添加菜品
	private void addFood() {
		String name = this.ui.getString("请输入新增菜品名称：");
		List<Food> list=new ArrayList<Food>();
		for (Food f : list) {
			if(f.getfName().equals(name)){
				this.v.println("该菜品已存在，请重新输入！");
				return ;
			}
		}
		String s = this.service.addFood(name, this.ui.getDouble("请输入菜品价格："),
				this.ui.getInt("请输入菜品种类编号："), this.ui.getDouble("请输入菜品折扣："));
		System.out.println(s);
	}
	//冻结客户
	private void congel() {
		int uid = this.ui.getInt("请输入要冻结客户编号：");
		Customer cus = this.service.findCustById(uid);
		if(cus==null){
			this.v.println("客户不存在！");
			return ;
		}
		String s = this.service.freezeUser(uid);
		System.out.println(s);
	}
	//补办会员卡
	private void getNew() {
		int cid = this.ui.getInt("请输入要补办会员卡的卡号：");
		String s = this.service.replace(cid);
		System.out.println(s);
		
	}
	//查看所有员工
	private void selectAllEmp() {
		List<Employee> emp = this.service.findemp();
		this.v.println("员工编号\t员工名称\t账号\t职位");
		for (Employee e : emp) {
			System.out.println(e);
		}
	}
	//删除员工
	private void deleteEmp() {
		int eid = this.ui.getInt("请输入要删除员工的编号：");
		Employee emp = this.service.findempById(eid);
		if(emp==null){
			this.v.println("员工不存在！");
			return ;
		}
		String s = this.ui.getString("是否删除:(y/n)");
		if("y".equals(s)){
			System.out.println(this.service.removeEmployee(eid));
			return;
		}	
	}
	//添加员工
	private void addEmp() {
		String s = this.service.addEmployee(this.ui.getString("请输入员工姓名："), 
				this.ui.getString("请输入员工账号："), 
				this.ui.getString("请输入初始密码："));
		System.out.println(s);
		
	}
	//员工修改个人密码
	private void updateEmp() {
		String oldPass = this.ui.getString("请输入旧密码：");
		if(!(oldPass.equals(e.getPassword()))){
			this.v.println("原密码输入错误");
			return;
		}
		String newPass = this.ui.getString("请输入新密码");
		String s = this.service.alterEmpPass(e.getEmpId(), newPass);
		System.out.println(s);
	}
	//挂失
	private void lose() {
		int id = this.ui.getInt("请输入用户编号:");
		int cardid = this.ui.getInt("请输入会员卡号：");
		if(this.service.findCustById(id).getV().getCardId()==cardid){
			System.out.println(this.service.report(id));
			return;
		}
		System.out.println("账号与卡号不匹配");
	}
	//充值
	private void recharge() {
		int id = this.ui.getInt("请输入用户编号:");
		int cardid = this.ui.getInt("请输入会员卡号：");
		if(this.service.findCustById(id).getV().getCardId()==cardid){
			int money = this.ui.getInt("请输入要充值的金额：");
			System.out.println(this.service.topUp(c.getUserId(), money));
			return;
		}
		System.out.println("账号与卡号不匹配");
	}
	//办卡
	private void getCard() {
		int id = this.ui.getInt("请输入用户编号:");
		Customer c = this.service.findCustById(id);
		if(c!=null){
			int i = this.ui.getInt("请选择办理的会员等级：1.普通会员  2.超级会员");
			System.out.println(this.service.beVip(id, i));
		}
		
	}
	//客户修改密码
	private void updateUser() {
		String oldPass = this.ui.getString("请输入原密码：");
		Customer cus = this.service.findCustById(c.getUserId());
		if(!(oldPass.equals(cus.getPassword()))){
			this.v.println("输入旧密码不正确！");
		}
		String newPass = this.ui.getString("请输入修改密码：");
		String s = this.service.alterCustPass(c.getUserId(),  newPass);
		this.v.println(s);
	}
	
	
	//客户点餐
	private void showFood() {
		this.v.println("菜品编号\t名称\t价格\t种类\t折扣");
		List<Food> list = this.service.findFood();
		for (Food f : list) {
			System.out.println(f);
		}
		Map<Food, Integer> m=new HashMap<Food, Integer>();
		while(true){
			int fId = this.ui.getInt("请选择菜品：");
			Food f = this.service.findFoodById(fId);
			if(f==null){
				this.v.println("您选择的菜品不存在，请重新选择");
				return ;
			}
			int num = this.ui.getInt("请输入需要的数量：");
			//订单存储（编号和数量）
			m.put(this.service.findFoodById(fId), num);
			String s = this.ui.getString("继续点餐(y)结束点餐(n)退订菜品(c)");
			if("c".equals(s)){
				int i = this.ui.getInt("请输入要退订编号:");
				Food food = this.service.findFoodById(i);
				if(food==null){
					this.v.println("菜品不存在");
				}else{
					m.remove(i);
				}	
			}else if(!"y".equals(s)){
				break;
			}
			
		}
		//购物车显示
		double getMoney=0;
		int sumprice=0;
		this.v.println("您的点餐结果如下：");
		this.v.println("菜品编号\t名称\t价格\t种类\t折扣\t数量");
		Set<Food> key=m.keySet();
		for (Food f : key) {
			System.out.println(f+"\t"+m.get(f));
			sumprice+=f.getPrice()*f.getDis()*m.get(f);
		}
		
		Po p = this.service.settle(c, m, getMoney);
		int i = this.ui.getInt("请选择现金支付(1)或会员卡支付(2)");
		if(i==1){
			getMoney=this.ui.getDouble("请输入支付金额");
			this.v.println("您一共消费"+sumprice+"元，欢迎下次光临！");
		}else if(i==2){
			sumprice*=c.getV().getDis();
			getMoney = sumprice;
			this.v.println("您使用了会员卡，一共消费"+sumprice+"元，欢迎下次光临！");
		}
	    //打印小票
		this.v.println("----------------购物小票----------------");
		this.v.println("交易编号:"+p.getUuId());
		this.v.println("交易时间:"+p.getoTime());
		this.v.println("会员卡号："+c.getV().getCardId());
		this.v.println("-------------------------------------");
		this.v.println("编号"+"\t名称"+"\t数量"+"\t小计");
		for (Food f : key) {
			System.out.println(f.getfId()+"\t"+f.getfName()+"\t"+m.get(f)+f.getPrice()*f.getDis()*m.get(f));
		}
		this.v.println("--------------------------------------");
		this.v.println("总金额："+sumprice);
		this.v.println("欢迎下次光临！");
	}
}
