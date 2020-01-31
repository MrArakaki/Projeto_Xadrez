package chess;

import boardgame.Board;

// contém as regras do jogo.

public class ChessMatch {

	private Board board; // tabulheiro do jogo

	public ChessMatch() {

		board = new Board(8, 8); // dimensão do tabulheiro
	}
// metodo para retornar uma matriz de peças da partida

	public ChessPiece[][] getPieces() {
		// variavel temporária auxiliar
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
