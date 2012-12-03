package mainflow;

import iterface.IFilter;
import java.util.Scanner;

import pipe.Pipe;
import filter.*;

/**
 * Copyright (C), 2001-2012, Aha
 * <br/>Date:2012-11-12
 * @author  Aha tzl77258511@gmail.com
 * @version  1.0
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("N皇后问题[管道过滤器风格](只能处理1-64皇后,输入-1结束程序),请输入N:");
		int n = -1;
	    long tm;
	    Scanner scanner = new Scanner(System.in);
	    while (true) {
	    	System.out.println("请输入N:");
	        Counter.reset();
	        n = scanner.nextInt();
	        
	        if (n == -1) {
	            break;
	        }
	        
	        
	        tm = System.currentTimeMillis();
	        
	        // 因为长整型数的限制，最大只能64位，  
	        // 如果想处理N大于64的皇后问题，需要  
	        // 用bitset数据结构进行存储
	        if ((n < 1) || (n > 64))
	        {
	        	System.out.println(" ֻ只能计算1-64之间");
	            return ;
	        }
	        System.out.println("正在计算...");
	        
	        // N个皇后只需N位存储，N列中某列有皇后则对应bit置1
	        Upperlim.reset(n);
	        
	        CompositeFilter compositeFilter = new AndFilter();
	        
	        IFilter obliqueLineCollisionFilter = new ObliqueLineCollisionFilter();
	        compositeFilter.addFilter(obliqueLineCollisionFilter);
	        IFilter availabeBitFilter = new AvailabeBitFilter(compositeFilter);
	        compositeFilter.addFilter(availabeBitFilter);
	        
	        Pipe pipe = new Pipe(0, 0, 0);
	        compositeFilter.transform(pipe);
	        
	        System.out.println("共有" + Counter.count + "种排列, 计算时间" + (float)(System.currentTimeMillis() - tm)/1000 + "秒\n");
	    }
	    scanner.close();
	}

}
