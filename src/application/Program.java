package application;

import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {

		// jogo de xadrez- 30/01/2020

		ChessMatch chessMatch = new ChessMatch();
		UI.printBoard(chessMatch.getPieces());

	}

}
