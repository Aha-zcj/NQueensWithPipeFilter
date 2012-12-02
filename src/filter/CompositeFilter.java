package filter;

import iterface.IFilter;
import java.util.ArrayList;
import pipe.Pipe;

public abstract class CompositeFilter implements IFilter {  
 
    protected ArrayList<IFilter> filters;
    protected Pipe mPipe;
 
    public CompositeFilter() {  
        this.filters = new ArrayList<IFilter>();  
    } 
 
    //继续将 IFilter 接口中的 transform() 声明为 abstract，  
    //由具体的过滤器子类进行实现
    public abstract boolean transform(Pipe data);
 
    //添加过滤器链
    public void addFilters(ArrayList<IFilter> filters) {  
        this.filters.addAll(filters);
    }
 
    //添加一个过滤器  
    public void addFilter(IFilter filter) {  
        this.filters.add(filter);  
    } 
 
    //既然是树枝过滤器，其下必有子过滤器  
    public ArrayList<IFilter> getFilters() {  
        return this.filters;  
    }
    
    @Override
	public Pipe getPipe() {
		// TODO Auto-generated method stub
		return mPipe;
	}  
}