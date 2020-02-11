package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

	public Queen(Board board, Color color) {
		super(board, color);

	}

	@Override
	public String toString() {
		return "Q";

	}

	@Override
	public boolean[][] possibleMove() {
		// TODO Auto-generated method stub

		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// logica para verificar as posições vazias a cima das peças

		p.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponemtPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// logica para verificar as posições vazias a esquerda das peças

		p.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponemtPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// logica para verificar as posições vazias a direita das peças

		p.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponemtPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// logica para verificar as posições vazias a baixo das peças

		p.setValues(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponemtPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// logica para verificar as posições vazias a noroeste(diagonal) das peças

		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponemtPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// logica para verificar as posições vazias na diagonal nordeste das peças

		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponemtPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}

		// logica para verificar as posições vazias na diagonal suldeste das peças

		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() + 1);
			;
		}
		if (getBoard().positionExists(p) && isThereOpponemtPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		// logica para verificar as posições vazias na diagonal suldoeste das peças

		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() - 1);
			;
		}
		if (getBoard().positionExists(p) && isThereOpponemtPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		return mat;
	}
}