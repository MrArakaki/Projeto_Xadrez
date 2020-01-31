package chess;

import boardgame.Board;

// cont�m as regras do jogo.

public class ChessMatch {

	private Board board; // tabulheiro do jogo

	public ChessMatch() {

		board = new Board(8, 8); // dimens�o do tabulheiro
	}
// metodo para retornar uma matriz de pe�as da partida

	public ChessPiece[][] getPieces() {
		// variavel tempor�ria auxiliar
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		// precorre a matriz
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); i++) {// precorre a coluna
				mat[i][j]=(ChessPiece) board.piece(i,j); // drawcast

			}
		}
		return mat;
	}
}
