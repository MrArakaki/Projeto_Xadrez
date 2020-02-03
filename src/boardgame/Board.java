package boardgame;

public class Board {

	private int rows; // quantidade de linha
	private int columns; // quantidade de colunas
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
             throw new BoardException("Error creating board: There must be at least 1 row and 1 columns");
		}
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
		if(! positionExists(row,column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
//sobrecarga do metodo 'public Piece piece' para receber retornar o atributo 'position'

	public Piece piece(Position position) {
		if(! positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece(Piece piece, Position position) {
		if(thereIsApiece(position)) {
			throw new BoardException("There is already on position" + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());

	}

	public boolean thereIsApiece(Position position) {
		return piece(position) != null;

	}
}
