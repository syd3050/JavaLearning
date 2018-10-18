package com.ethan.solution;

import com.ethan.base.Base;

public class MinHeap extends Base{
	
	private int[] data;
    private int next = 0;
    private int capacity = 0;
    
	public MinHeap(int capacity)
	{
		/**
		 * ����Ҫִֻ��ĳ��������ĳЩ����ʱ������������
		 * ���onlyΪ�գ������only
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
	 * ȡ���ڵ�
	 * @return
	 * @throws Exception
	 */
	public int top() throws Exception {
		if(this.isEmpty())
			throw new Exception("Heap is Empty!");
		return this.data[0];
	}
	
	/**
	 * �Ƴ������ظ��ڵ�
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
			//������������������С�Ľڵ�����ڵ�Ƚ�
			if(right < this.next && this.data[right] < this.data[left])
				left = right;
			//�����С�Ľڵ㶼�ȸ��ڵ�С����ô�����ڵ����С�ڵ㽻��
			if(this.data[index] > this.data[left]) {
				int tmp = this.data[index];
				this.data[index] = this.data[left];
				this.data[left] = tmp;
				index = left;
			}else {
				//���ڵ��Ѿ��������ӽڵ㶼С���˳�ѭ��
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
