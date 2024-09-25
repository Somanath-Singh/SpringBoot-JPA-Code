package com.nt.test;

import com.nt.service.Arithmetic;

public class LAMBDATest
{
    public static void main( String[] args )
    {
    	//style 1
    	Arithmetic ar=(int a,int b)->{
    		int c=a+b;
    		return c;
    	};
    	System.out.println("sum="+ar.add(12, 34));
    	
    	//style 2
    	Arithmetic ar1=(int a,int b)->{
    		return a+b;
    	};
    	System.out.println("sum="+ar1.add(12, 34));
    	
    	//style 3
    	Arithmetic ar2=(int a,int b)-> a+b;
    	
    	System.out.println("sum="+ar2.add(12, 34));
    	
    	//style 4
    	Arithmetic ar3=(a,b)-> a+b;
    	
    	System.out.println("sum="+ar3.add(12, 34));
    	
    }
}
