package com.ethan.solution;

import com.ethan.base.Base;

public class MinHeap extends Base{
	
	private int[] data;
    private int next = 0;
    private int capacity = 0;
    
	public MinHeap(int capacity)
	{
		/**
		 * 当需要只执行某个方法或某些方法时，在这里配置
		 * 如果only为空，则忽略only
		 * only = new String[]{"sub"};
		 */
		this.only = new String[]{"show"};
		this.data = new int[capacity];
		this.capacity = capacity;
	}
	
    
    public boolean insert(int n)
    {
    	if(next == this.capacity)
    		return false;
        this.data[next] = n;
        this.up(next);
        this.next++;
        return true;
    }
    
    public void up(int index)
    {
        int parent = (index-1)/2;
        if(parent < 0)
            parent = 0;
        while(parent >= 0 && this.data[parent] > this.data[index])
        {
            int tmp = this.data[parent];
            this.data[parent] = this.data[index];
            this.data[index] = tmp;
            index = parent;
            parent = (parent-1) / 2;
        }
    }
    
    public String show() {
		this.insert(3);
		this.insert(1);
		this.insert(5);
		this.insert(4);
		this.insert(2);
		return "minHeap==>"+ this;
	}
    
    public String toString() {
		StringBuilder sBuilder  = new StringBuilder();
		for(int i : this.data)
		{
			if(i > 0) {
				sBuilder.append(i);
				sBuilder.append(",");
			}
		}
		sBuilder.deleteCharAt(sBuilder.length()-1);
		return sBuilder.toString();
	}
    
    public static void main(String[] args)
    {
    	MinHeap mHeap = new MinHeap(20);
    	mHeap._invoke(mHeap);
    }
}
