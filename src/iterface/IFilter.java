package iterface;

import pipe.Pipe;

/**
 * Copyright (C), 2001-2012, Aha
 * <br/>Date:2012-11-12
 * @author  Aha tzl77258511@gmail.com
 * @version  1.0
 */
// 过滤器接口
public interface IFilter {
	//将输入数据进行转换过滤
    public boolean transform(Pipe data);
    public Pipe getPipe();
}