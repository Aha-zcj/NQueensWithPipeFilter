package filter;

import pipe.Pipe;
import iterface.IFilter;

/**
 * Copyright (C), 2001-2012, Aha
 * <br/>Date:2012-11-12
 * @author  Aha tzl77258511@gmail.com
 * @version  1.0
 */
public class ObliqueLineCollisionFilter implements IFilter{
	
	private Pipe mPipe;

	@Override
	public boolean transform(Pipe data) {
		// TODO Auto-generated method stub
		long ld, rd;
		ld = data.getLd();
		rd = data.getRd();
		ld = ld << 1;
		rd = rd >> 1;
		mPipe = new Pipe(data.getRow(), ld, rd);
		return true;
	}

	public Pipe getPipe() {
		return mPipe;
	}
	
}