package pipe;

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