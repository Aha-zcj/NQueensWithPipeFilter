package mainflow; 


/**
 * Copyright (C), 2001-2012, Aha
 * <br/>Date:2012-11-12
 * @author  Aha tzl77258511@gmail.com
 * @version  1.0
 */
public class Upperlim{
	public static int upperlim = 1;
	
	public static void reset(int n){
		upperlim = 1;
		upperlim = (upperlim << n) - 1;
	}
}