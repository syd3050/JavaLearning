package com.ethan.jcore;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ethan.base.Base;

/**
 * String ������
 * 1.public �����������Ϊ public void xxx()
 * 
 * 2.private�������������_�»��߿�ͷ
 * 
 * main�������Զ���������public��������ӡ�����
 * 
 * @author Administrator
 *
 */
public class CString extends Base{
	
	public CString()
	{
		/**
		 * ����Ҫִֻ��ĳ��������ĳЩ����ʱ������������
		 * ���onlyΪ�գ������only
		 * only = new String[]{"sub"};
		 */
		only = new String[]{};
	}

	public static void main(String[] args)
	{
		CString instance = new CString();
		instance._invoke(instance);
	}
	
	public String sub()
	{
		String s = "Hello Jim!";
		return s.substring(0,5);
	}
	
	public String join()
	{
		String[] s_arr ={"a","b","c"};
		return String.join(",", s_arr);
	}
	
	public String modify()
	{
		String s = "Hello world!";
		return s.substring(0,5) + "Green";
	}
	
	public String equals()
	{
		String a = "Hello";
		String b = "hello";
		boolean equal = a.equals(b);
		return a+" equals " + b + "?"+equal;
	}
	
	public String equalIgnore()
	{
		String a = "Hello";
		String b = "hello";
		boolean equalIgnore = a.equalsIgnoreCase(b);
		return a+" equalsIgnore " + b + "?"+equalIgnore;
	}
	
	public String empty()
	{
		String a = "";
		return "String "+a+" is empty?"+a.isEmpty();
	}
	
	public String isNull()
	{
		String a = null;
		return "String "+a+" is null?"+(a==null);
	}
	
	public String charAt()
	{
		String s = "Hello world!";
		return "String "+s+",charAt 6 is "+s.charAt(6);
	}
	
	
}
