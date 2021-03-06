package boardgame;

public abstract class Piece {

	protected Position position;
	private Board board;

	public Piece(Board board) {

		this.board = board;
		position = null;
	}

	protected Board getBoard() {
		return board;
	}

	public abstract boolean[][] possibleMove(); // metodo abstrato
    // implementando metodo real

	public boolean possibleMove(Position position) {
		return possibleMove()[position.getRow()][position.getColumn()];
	}

	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMove();
		
		for (int i = 0; i < mat.length; i++) {
			for (int j=0; j < mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;

	}

	public void add(Piece capturedPiece) {
		// TODO Auto-generated method stub
		
	}

	//public abstract void add(Piece capturedPiece);
}
