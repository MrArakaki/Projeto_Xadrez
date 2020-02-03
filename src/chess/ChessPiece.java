package chess;

import boardgame.Board;
import boardgame.Piece;

// � uma sub-classe da classe Piece
public abstract class ChessPiece extends Piece{

	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	// n�o ser� usado o 'set' porque a cor n�o poder� ser mudada, e sim acessada.
	
	
}
