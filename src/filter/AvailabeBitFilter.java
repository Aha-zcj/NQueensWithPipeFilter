package filter;

import mainflow.Counter;
import mainflow.Upperlim;
import pipe.Pipe;
import iterface.IFilter;


public class AvailabeBitFilter implements IFilter{
	
	private Pipe mPipe;
	private IFilter mNextFilter;
	
	public AvailabeBitFilter(IFilter nextFilter){
		this.mNextFilter = nextFilter;
	}

	@Override
	public boolean transform(Pipe data) {
		// TODO Auto-generated method stub
		if (data.getRow() != Upperlim.upperlim)  
	    {  
	        // row，ld，rd进行“或”运算，求得所有可以放置皇后的列,对应位为0，  
	        // 然后再取反后“与”上全1的数，来求得当前所有可以放置皇后的位置，对应列改为1  
	        // 也就是求取当前哪些列可以放置皇后  
	        long pos = Upperlim.upperlim & ~(data.getOr()); 
	        while (pos != 0)    // 0 -- 皇后没有地方可放，回溯  
	        {  
	            // 拷贝pos最右边为1的bit，其余bit置0  
	            // 也就是取得可以放皇后的最右边的列  
	            long p = pos & -pos;                                                
	  
	            // 将pos最右边为1的bit清零  
	            // 也就是为获取下一次的最右可用列使用做准备，  
	            // 程序将来会回溯到这个位置继续试探  
	            pos -= p;
	            // row + p，将当前列置1，表示记录这次皇后放置的列。  
	            // (ld + p) << 1，标记当前皇后左边相邻的列不允许下一个皇后放置。  
	            // (ld + p) >> 1，标记当前皇后右边相邻的列不允许下一个皇后放置。  
	            // 此处的移位操作实际上是记录对角线上的限制，只是因为问题都化归  
	            // 到一行网格上来解决，所以表示为列的限制就可以了。显然，随着移位  
	            // 在每次选择列之前进行，原来N×N网格中某个已放置的皇后针对其对角线  
	            // 上产生的限制都被记录下来了
	            
	            mNextFilter.transform(new Pipe(data.getRow() + p,
	            		(data.getLd() + p), 
	            		(data.getRd() + p)));               
	        }  
	    }  
	    else     
	    {  
	        //bits的所有位都为1，即找到了一个成功的布局，回溯  
	        Counter.increaseOne();
	    }
		return true;
	}

	public Pipe getPipe() {
		return mPipe;
	}


}