package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

// contém as regras do jogo.

public class ChessMatch {

	private Board board; // tabulheiro do jogo

	public ChessMatch() {

		board = new Board(8, 8); // dimensão do tabulheiro
		initialSetup();
	}
// metodo para retornar uma matriz de peças da partida

	public ChessPiece[][] getPieces() {
		// variavel temporária auxiliar
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

		// precorre a matriz
		for (int i=0; i <board.getRows(); i++) {
			// precorre a coluna
			for (int j=0; j <board.getColumns(); i++) {
				mat[i][j]=(ChessPiece) board.piece(i, j); // drawcast em chessPiece
			}

		}
		return mat;
	}

	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
		board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
		board.placePiece(new King(board, Color.WHITE), new Position(7, 4));

	}
}
