package com.ethan.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Base {
	/**
	 * 仅执行这里的方法
	 */
	private HashMap _only;
	protected String[] only;
	protected String className;
	
	protected void _out(String result)
	{
/*		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement e : stackTrace) {
        	if(e.getClassName().equalsIgnoreCase(className) && !e.getMethodName().equals("main"))
        	{
                //System.out.println(e.getClassName() + "\t" + e.getMethodName() + "\t" + e.getLineNumber());
        		System.out.println("In "+e.getMethodName()+",resutl=>"+result);
        	}
        }*/
	}
	
	protected void _invoke(Object obj)
	{
		this._only = new HashMap();
		for(String s : this.only)
		{
			this._only.put(s, 1);
		}
		className = obj.getClass().toString().substring(6);
		Method[] methods = obj.getClass().getDeclaredMethods();
		for(Method method : methods)
		{
			String name = method.getName();
			
			/**
			 * only中有配置的方法时，仅执行only中配置的方法
			 */
			if(!_only.isEmpty() && !_only.containsKey(name)) {
				continue;
			}
			//所有私有方法均不调用
			String regEx  = "^_.+|^main$";
			Pattern pattern = Pattern.compile(regEx);
			Matcher matcher = pattern.matcher(name);
            boolean rs = matcher.find();
            if(rs){
                continue;
            }
			try {
				String methodName = method.toString();
				methodName = methodName.substring(methodName.lastIndexOf(".")+1);
				System.out.println("In method:"+methodName+",resutl:"+method.invoke(obj, null));;
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
