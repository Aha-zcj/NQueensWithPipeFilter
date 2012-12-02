package filter;

import pipe.Pipe;
import iterface.IFilter;


// and 过滤器，树枝型过滤器  
public class AndFilter extends CompositeFilter {
	
    @Override 
    public boolean transform(Pipe data) {
    	this.mPipe = data;
        for(IFilter filter : super.filters) {  
            if(!(filter.transform(mPipe))) {
                return false;
            }
            else{
            	this.mPipe = filter.getPipe();
            }
        }
        return true;  
    }
    
}