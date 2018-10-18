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
	
	public boolean isEmpty() {
		return this.next <= 0 ? true : false;
	}
	
	/**
	 * 取根节点
	 * @return
	 * @throws Exception
	 */
	public int top() throws Exception {
		if(this.isEmpty())
			throw new Exception("Heap is Empty!");
		return this.data[0];
	}
	
	/**
	 * 移除并返回根节点
	 * @return
	 * @throws Exception
	 */
	public int extract() throws Exception {
		if(this.isEmpty())
			throw new Exception("Heap is Empty!");
		int tmp = this.data[0];
		this.data[0] = this.data[this.next-1];
		this.data[this.next-1] = 0;
		this.next--;
		this.down(0);
		return tmp;
	}
	
	public void down(int index) {
		while(2*index+1 < this.next) {
			int left = 2*index + 1;
			int right = left + 1;
			//找左右两个孩子中最小的节点跟父节点比较
			if(right < this.next && this.data[right] < this.data[left])
				left = right;
			//如果最小的节点都比父节点小，那么将父节点跟最小节点交换
			if(this.data[index] > this.data[left]) {
				int tmp = this.data[index];
				this.data[index] = this.data[left];
				this.data[left] = tmp;
				index = left;
			}else {
				//父节点已经比左右子节点都小，退出循环
				break;
			}
			
		}
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
		while(!this.isEmpty()) {
			try {
				sBuilder.append(this.extract());
			} catch (Exception e) {
				break;
			}
			sBuilder.append(",");
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
