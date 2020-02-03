package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

// cont�m as regras do jogo.

public class ChessMatch {

	private Board board; // tabulheiro do jogo

	public ChessMatch() {

		board = new Board(8, 8); // dimens�o do tabulheiro
		initialSetup();
	}
// metodo para retornar uma matriz de pe�as da partida

	public ChessPiece[][] getPieces() {
		// variavel tempor�ria auxiliar
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

		// precorre a matriz
		for (int i = 0; i < board.getRows(); i++) {
			// precorre a coluna
			for (int j = 0; j < board.getColumns(); i++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}

		}

		return mat;
	}

	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}

	private void initialSetup() {
		placeNewPiece('a',6, new Rook(board, Color.WHITE));
		placeNewPiece('e',8, new King(board, Color.BLACK));
		placeNewPiece('e',1, new King(board, Color.WHITE));

	}
}
