package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

// contém as regras do jogo.

public class ChessMatch {

	private int turn;
	private Color currentPlayer;
	private Board board; // tabulheiro do jogo
	private boolean check;
	private boolean checkMate;
	private List<Piece> piecesOnTheBoard = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();

	public ChessMatch() {

		board = new Board(8, 8); // dimensão do tabulheiro
		turn = 1;
		check = false;
		currentPlayer = Color.WHITE;
		initialSetup();
	}

	public int getTurn() {
		return turn;
	}

	public Color getCurrentPlayer() {
		return currentPlayer;
	}

	public boolean getCheck() {
		return check;
	}

	public boolean getCheckMate() {
		return checkMate;
	}

	// metodo para retornar uma matriz de peças da partida

	public ChessPiece[][] getPieces() {
		// variavel temporária auxiliar
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

		// precorre a matriz
		for (int i = 0; i < board.getRows(); i++) {
			// precorre a coluna
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}

		}

		return mat;
	}

	public boolean[][] possibleMoves(ChessPosition sourcePosition) {
		Position position = sourcePosition.toPosition();
		return board.piece(position).possibleMove();
	}

	// movimento da validação e movimento das peças
	public ChessPiece PerformChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {

		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPossition(source, target);
		Piece capturedPiece = makeMove(source, target);

		if (testCheck(currentPlayer)) {
			undoMove(source, target, capturedPiece);
			throw new ChessException("You can't put youself in check");
		}
		check = (testCheck(opponent(currentPlayer))) ? true : false;
		
		if (testCheckMate(opponent(currentPlayer))) {
			checkMate = true;
		} 
		else {
			nextTurn();
		}

		return (ChessPiece) capturedPiece;
	}

	// movimento das peças do xadrez
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);

		if (capturedPiece != null) {
			piecesOnTheBoard.remove(capturedPiece);
			capturedPiece.add(capturedPiece);
		}
		return capturedPiece;
	}

	private void undoMove(Position source, Position target, Piece capturePiece) {
		Piece p = board.removePiece(target);
		board.placePiece(p, source);

		if (capturePiece != null) {
			board.placePiece(capturePiece, target);
			capturedPieces.remove(capturePiece);
			piecesOnTheBoard.add(capturePiece);

		}
	}

	private void validateSourcePosition(Position position) {
		if (!board.thereIsApiece(position)) {
			throw new ChessException("There is no piece on source position");
		}
		if (currentPlayer != ((ChessPiece) board.piece(position)).getColor()) {
			throw new ChessException("The chosen piece is not yours");
		}
		if (!board.piece(position).isThereAnyPossibleMove()) {
			throw new ChessException("There is no possible moves for the chosen piece");
		}
	}

	// troca de turno
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}

	private void validateTargetPossition(Position source, Position target) {
		if (!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}

	private static Color opponent(Color color) {
		return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}

	// filtrando lista
	private ChessPiece King(Color color) {
		List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == color)
				.collect(Collectors.toList());
		for (Piece p : list) {
			if (p instanceof King) {
				return (ChessPiece) p; // drawcast
			}
		}
		throw new IllegalStateException("There is no " + color + "King the board ");
	}

	private boolean testCheck(Color color) {
		Position kingPosition = King(color).getChessPosition().toPosition();
		List<Piece> opponentPieces = piecesOnTheBoard.stream()
				.filter(x -> ((ChessPiece) x).getColor() == opponent(color)).collect(Collectors.toList());

		for (Piece p : opponentPieces) {
			boolean[][] mat = p.possibleMove();
			if (mat[kingPosition.getRow()][kingPosition.getColumn()]) {
				return true;
			}
		}
		return false;
	}

	private boolean testCheckMate(Color color) {
		if (!testCheck(color)) {
			return false;
		}
		List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor() == color)
				.collect(Collectors.toList()); //PEGA TODAS AS PEÇAS DE UMA COR
		for (Piece p : list) {
			boolean[][] mat = p.possibleMove();
			for (int i = 0; i < board.getRows(); i++) {
				for (int j = 0; j < board.getColumns(); j++) {
					if (mat[i][j]) {
						Position source = ((ChessPiece) p).getChessPosition().toPosition();
						Position target = new Position(i, j);
						Piece capturePiece = makeMove(source, target);
						boolean testCheck = testCheck(color);
						undoMove(source, target, capturePiece);
						if (!testCheck) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
		piecesOnTheBoard.add(piece);
	}

	private void initialSetup() {

		placeNewPiece('h', 7, new Rook(board, Color.WHITE));
		placeNewPiece('d', 1, new Rook(board, Color.WHITE));
		placeNewPiece('e', 1, new King(board, Color.WHITE));

		placeNewPiece('b', 8, new Rook(board, Color.BLACK));
		placeNewPiece('a', 8, new King(board, Color.BLACK));

		/*
		 * placeNewPiece('c', 2, new Rook(board, Color.WHITE)); placeNewPiece('d', 2,
		 * new Rook(board, Color.WHITE)); placeNewPiece('e', 2, new Rook(board,
		 * Color.WHITE)); placeNewPiece('d', 1, new King(board, Color.WHITE));
		 * placeNewPiece('c', 7, new Rook(board, Color.BLACK)); placeNewPiece('c', 8,
		 * new Rook(board, Color.BLACK)); placeNewPiece('d', 7, new Rook(board,
		 * Color.BLACK)); placeNewPiece('e', 7, new Rook(board, Color.BLACK));
		 * placeNewPiece('d', 8, new King(board, Color.BLACK));
		 */
	}
}
