package boardgame;

public class Position {

	
	private int rows; 
	private int columns;
	
	public Position(int row, int column) {
		
		this.rows = row;
		this.columns = column;
	}

	public int getRow() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	@Override
	
	public String toString() {
		return rows  + ", " + columns;
	}
	

	
	
}
