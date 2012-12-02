package pipe;


/**
 * Copyright (C), 2001-2012, Aha
 * <br/>Date:2012-11-12
 * @author  Aha tzl77258511@gmail.com
 * @version  1.0
 */
public class Pipe{
	private long row;
	private long ld;
	private long rd;
	
	public Pipe(long row, long ld, long rd){
		setRow(row);
		setLd(ld);
		setRd(rd);
	}

	public long getRow() {
		return row;
	}

	public void setRow(long row) {
		this.row = row;
	}

	public long getLd() {
		return ld;
	}

	public void setLd(long ld) {
		this.ld = ld;
	}

	public long getRd() {
		return rd;
	}

	public void setRd(long rd) {
		this.rd = rd;
	}


	public long getOr(){
		return row | ld | rd;
	}

}