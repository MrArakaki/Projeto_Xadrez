package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);

	}

	@Override
	public boolean[][] possibleMove() {
		// TODO Auto-generated method stub
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0,0);
		
//Peao branco
		if (getColor() == Color.WHITE) {

			p.setValues(position.getRow() - 1, position.getColumn()); // 1 position para cima

			if (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() -1, position.getColumn());
			
			if (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)
					&& (getBoard().positionExists(p2) && !getBoard().thereIsApiece(p2) && getMoveCount() == 0)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			
			if (getBoard().positionExists(p) && isThereOpponemtPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			
			if (getBoard().positionExists(p) && isThereOpponemtPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
//Peao preto
			else {

				p.setValues(position.getRow() + 1, position.getColumn());
				
				if (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				p.setValues(position.getRow() +2, position.getColumn());
				Position p2 = new Position(position.getRow()+1, position.getColumn());
				
				if (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)
						&& (getBoard().positionExists(p2) && !getBoard().thereIsApiece(p2) && getMoveCount() == 0)) {
					mat[p.getRow()][p.getColumn()] = true;
				}

				p.setValues(position.getRow() + 1, position.getColumn() - 1);
				
				if (getBoard().positionExists(p) && isThereOpponemtPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}

				p.setValues(position.getRow() + 1, position.getColumn() + 1);
				
				if (getBoard().positionExists(p) && isThereOpponemtPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}

			}
		return mat;
		}
	

	@Override
	public String toString() {
		return "p";
	}

}
