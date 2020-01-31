package boardgame;

public class Board {

	private int rows; // quantidade de linha
	private int columns; // quantidade de colunas
	private Piece[][] pieces;

	public Board(int rows, int columns) {

		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
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

// metodo para ler as peças nas linha e colunas

	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
//sobrecarga do metodo 'public Piece piece' para receber retornar o atributo 'position'

	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}

}
