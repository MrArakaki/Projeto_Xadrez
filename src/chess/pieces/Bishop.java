package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

	public Bishop(Board board, Color color) {
		super(board, color);

	}

	@Override
	public String toString() {
		return "B";

	}

	@Override
	public boolean[][] possibleMove() {
		// TODO Auto-generated method stub

		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// logica para verificar as posi��es vazias a noroeste(diagonal) das pe�as

		p.setValues(position.getRow() - 1, position.getColumn() -1 );
		while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() -1, p.getColumn()-1);
		}
		if (getBoard().positionExists(p) && isThereOpponemtPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// logica para verificar as posi��es vazias na diagonal nordeste das pe�as

		p.setValues(position.getRow() -1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow()-1,p.getColumn() +1);
		}
		if (getBoard().positionExists(p) && isThereOpponemtPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// logica para verificar as posi��es vazias na diagonal suldeste das pe�as

		p.setValues(position.getRow() +1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() +1 ,p.getColumn() +1 );;
		}
		if (getBoard().positionExists(p) && isThereOpponemtPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// logica para verificar as posi��es vazias na diagonal suldoeste das pe�as

		p.setValues(position.getRow() + 1, position.getColumn() -1);
		while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow()+1, p.getColumn() -1);;
		}
		if (getBoard().positionExists(p) && isThereOpponemtPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		return mat;
	}

}
