package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

// É uma sub-classe da classe Piece
public abstract class ChessPiece extends Piece {

	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);  
	}

	// não será usado o 'set' porque a cor não poderá ser mudada, e sim acessada.

	protected boolean isThereOpponemtPiece(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
}
