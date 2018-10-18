package com.ethan.solution;

public class Solution {
	
	
	
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if(len == 0)
            return "";
        String tmp = strs[0];
        int tmpLen = tmp.length();
        String r = "";
        int begin = 0;
        int end=tmpLen/2;        
        
        while(begin < end) {
            boolean flag = true;
            String cmp = tmp.substring(begin,end);
            for(int i=1; i < len; i++) {
                if(!strs[i].substring(begin,end).equals(cmp)){
                    System.out.printf("begin is %d,end is %d,substing:%s,cmp is %s \n",begin,end,strs[i].substring(begin,end),cmp);
                    flag = false;
                    break;
                }
            }
            if(flag) {
                System.out.println(flag);
                int old = begin;
                begin = end;
                end = (tmpLen-end)/2+old;
            }
        }
       
        return tmp.substring(0,end);
    }
	
	public static void main(String[] args) {
		String[] strs = {"flower","flow","foght"};
		Solution obj = new Solution();
		System.out.printf("Result is :%s",obj.longestCommonPrefix(strs));
	}
}