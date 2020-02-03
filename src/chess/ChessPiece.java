package chess;

import boardgame.Board;
import boardgame.Piece;

// É uma sub-classe da classe Piece
public abstract class ChessPiece extends Piece{

	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	// não será usado o 'set' porque a cor não poderá ser mudada, e sim acessada.
	
	
}
