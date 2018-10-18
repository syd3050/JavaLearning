package com.ethan.solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.ethan.base.Base;

/**
 * BFS 测试类
 * 1.public 方法定义必须为 public void xxx()
 * 
 * 2.private方法定义必需以_下划线开头
 * 
 * main方法会自动调用所有public方法并打印出结果
 * 
 * @author Administrator
 *
 */
public class BFS extends Base{
	
	public BFS()
	{
		/**
		 * 当需要只执行某个方法或某些方法时，在这里配置
		 * 如果only为空，则忽略only
		 * only = new String[]{"sub"};
		 */
		only = new String[]{"dfs_search"};
	}
	
	private void _init(HashMap<Character, LinkedList<Character>> graph)
	{
		/**
		 * 构建节点和边
		 * s-w-x-y
		 * | | |
		 * r i u
		 * |
		 * v
		 * 假如start为s，end为u，路径：
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
		//构建图
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
						System.out.println(next+"找到从"+start+"到"+end+"的路径 \n");
						return "找到从"+start+"到"+end+"的路径 \n";
					}
					_dfs_search_recursion(graph, visited, next, end);
				}
			}
		}
		return ",没有找到路径\n";
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
						return "找到从"+start+"到"+end+"的路径 \n";
					}
					stack.push(next);
					visited.put(next, true);
				}
			}
		}
		return ",没有找到路径\n";
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
		//dist记录各节点和父节点的距离
		HashMap<Character, Integer> dist = new HashMap<Character,Integer>();
		//开始节点入队列
		queue.add(start);
		//开始节点先进，跟自己的距离为0
		dist.put(start, 0);
		//为空表明已结束遍历
		while(!queue.isEmpty())
		{
			//取队头
			Character pre = queue.poll();
			System.out.print(pre+"->");
			//取所有head的下一个节点
			for(Character next : graph.get(pre))
			{
				//只访问没有访问过的节点，dist只保存那些已经访问过的节点
				if(!dist.containsKey(next))
				{
					//已经找到从start 到 end的路径
					if(next.toString().equalsIgnoreCase(end.toString()))
					{
						System.out.println(next);
						return "找到从"+start+"到"+end+"的路径 \n";
					}
					//标明该节点已经访问过
					dist.put(next, 1);
					//该节点进队列
					queue.add(next);
				}
			}
		}
		return ",没有找到路径\n";
	}

	public static void main(String[] args)
	{
		BFS instance = new BFS();		
		instance._invoke(instance);
	}
}
