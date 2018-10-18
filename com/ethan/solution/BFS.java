package com.ethan.solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.ethan.base.Base;

/**
 * BFS ������
 * 1.public �����������Ϊ public void xxx()
 * 
 * 2.private�������������_�»��߿�ͷ
 * 
 * main�������Զ���������public��������ӡ�����
 * 
 * @author Administrator
 *
 */
public class BFS extends Base{
	
	public BFS()
	{
		/**
		 * ����Ҫִֻ��ĳ��������ĳЩ����ʱ������������
		 * ���onlyΪ�գ������only
		 * only = new String[]{"sub"};
		 */
		only = new String[]{"dfs_search"};
	}
	
	private void _init(HashMap<Character, LinkedList<Character>> graph)
	{
		/**
		 * �����ڵ�ͱ�
		 * s-w-x-y
		 * | | |
		 * r i u
		 * |
		 * v
		 * ����startΪs��endΪu��·����
		 * s->w->r->x->
		 */
		LinkedList<Character> list_s = new LinkedList<Character>();
		list_s.add('w');
		list_s.add('r');
		LinkedList<Character> list_w = new LinkedList<Character>();
		list_w.add('s');
		list_w.add('x');
		list_w.add('i');
		LinkedList<Character> list_r = new LinkedList<Character>();
		list_r.add('s');
		list_r.add('v');
		LinkedList<Character> list_x = new LinkedList<Character>();
		list_x.add('w');
		list_x.add('y');
		list_x.add('u');
		LinkedList<Character> list_v = new LinkedList<Character>();
		list_v.add('r');
		LinkedList<Character> list_i = new LinkedList<Character>();
		list_i.add('w');
		LinkedList<Character> list_u = new LinkedList<Character>();
		list_u.add('x');
		LinkedList<Character> list_y = new LinkedList<Character>();
		list_y.add('x');
		//����ͼ
		graph.put('s', list_s);
		graph.put('w', list_w);
		graph.put('r', list_r);
		graph.put('x', list_x);
		graph.put('v', list_v);
		graph.put('i', list_i);
		graph.put('y', list_y);
		graph.put('u', list_u);
	}
	
	public String dfs_search() {
		HashMap<Character,LinkedList<Character>> graph = new HashMap<Character,LinkedList<Character>>();
		_init(graph);
		
		Character start = new Character('s');
		Character end = new Character('u');
		
		HashMap<Character, Boolean> visited = new HashMap<Character,Boolean>();
		
		return _dfs_search(graph, start, end);
		//return _dfs_search_recursion(graph, visited, start, end);
	}
	
	private String _dfs_search_recursion
	(
			HashMap<Character, LinkedList<Character>> graph,
			HashMap<Character, Boolean> visited,
			Character start,
			Character end	
	) {
		if(!visited.containsKey(start))
		{
			System.out.println(start+" not in visited!");
			visited.put(start, true);
			for(Character next : graph.get(start))
			{
				System.out.println("Next is "+next);
				if(!visited.containsKey(next))
				{
					System.out.println(next+" not in visited!");
					if(end.toString().equalsIgnoreCase(next.toString()))
					{
						System.out.println(next+"�ҵ���"+start+"��"+end+"��·�� \n");
						return "�ҵ���"+start+"��"+end+"��·�� \n";
					}
					_dfs_search_recursion(graph, visited, next, end);
				}
			}
		}
		return ",û���ҵ�·��\n";
	}
	
	private String _dfs_search
	(
			HashMap<Character, LinkedList<Character>> graph,
			Character start,
			Character end
	)
	{
		Stack<Character> stack = new Stack<Character>();
		HashMap<Character, Boolean> visited = new HashMap<Character,Boolean>();
		stack.push(start);
		visited.put(start, true);
		while (!stack.isEmpty()) {
			Character pre = stack.pop();
			System.out.print(pre+"->");
			for(Character next : graph.get(pre))
			{
				if(!visited.containsKey(next))
				{
					if(next.toString().equalsIgnoreCase(end.toString()))
					{
						System.out.println(next);
						return "�ҵ���"+start+"��"+end+"��·�� \n";
					}
					stack.push(next);
					visited.put(next, true);
				}
			}
		}
		return ",û���ҵ�·��\n";
	}
	
	public String bfs_search()
	{
		HashMap<Character,LinkedList<Character>> graph = new HashMap<Character,LinkedList<Character>>();
		_init(graph);
		
		Character start = new Character('s');
		Character end = new Character('u');
		
		return _bfs_search(graph,start,end);
	}
	
	private String _bfs_search
	(
			HashMap<Character,LinkedList<Character>> graph,
			Character start,
			Character end
	)
	{
		Queue<Character> queue = new LinkedList<Character>();
		//dist��¼���ڵ�͸��ڵ�ľ���
		HashMap<Character, Integer> dist = new HashMap<Character,Integer>();
		//��ʼ�ڵ������
		queue.add(start);
		//��ʼ�ڵ��Ƚ������Լ��ľ���Ϊ0
		dist.put(start, 0);
		//Ϊ�ձ����ѽ�������
		while(!queue.isEmpty())
		{
			//ȡ��ͷ
			Character pre = queue.poll();
			System.out.print(pre+"->");
			//ȡ����head����һ���ڵ�
			for(Character next : graph.get(pre))
			{
				//ֻ����û�з��ʹ��Ľڵ㣬distֻ������Щ�Ѿ����ʹ��Ľڵ�
				if(!dist.containsKey(next))
				{
					//�Ѿ��ҵ���start �� end��·��
					if(next.toString().equalsIgnoreCase(end.toString()))
					{
						System.out.println(next);
						return "�ҵ���"+start+"��"+end+"��·�� \n";
					}
					//�����ýڵ��Ѿ����ʹ�
					dist.put(next, 1);
					//�ýڵ������
					queue.add(next);
				}
			}
		}
		return ",û���ҵ�·��\n";
	}

	public static void main(String[] args)
	{
		BFS instance = new BFS();		
		instance._invoke(instance);
	}
}
