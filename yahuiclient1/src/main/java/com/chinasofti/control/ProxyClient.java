package com.chinasofti.control;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class ProxyClient {
	public static <T> T getClient(Class<T> clazz,final String ip,final int port){
		return (T)Proxy.newProxyInstance(ProxyClient.class.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
			
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Socket client = new Socket(ip, port);
				//获取输出流
				ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
				//具体要是用反射实现代理操作的传输
				//将代理的方法名称发送给服务器
				oos.writeUTF(method.getName());
				oos.flush();
				//将道理方法的参数类型发送给服务器
				oos.writeObject(method.getParameterTypes());
				oos.flush();
				oos.writeObject(args);
				oos.flush();
				//服务器返回结果进行接收
				ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
				return ois.readObject();
			}
		});
	}

}
