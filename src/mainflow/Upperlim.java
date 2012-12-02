package mainflow; 

public class Upperlim{
	public static int upperlim = 1;
	
	public static void reset(int n){
		upperlim = 1;
		upperlim = (upperlim << n) - 1;
	}
}