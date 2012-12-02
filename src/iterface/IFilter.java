package iterface;

import pipe.Pipe;

// 过滤器接口
public interface IFilter {
	//将输入数据进行转换过滤
    public boolean transform(Pipe data);
    public Pipe getPipe();
}