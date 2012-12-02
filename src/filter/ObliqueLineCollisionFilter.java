package filter;

import pipe.Pipe;
import iterface.IFilter;


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