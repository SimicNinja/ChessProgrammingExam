package chess.MoveCalculators;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.Collection;

public class QueenMoveCalculator extends MoveCalculator
{
	public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition)
	{
		checkDirection(board, myPosition, 0, 1);
		checkDirection(board, myPosition, 0, -1);
		checkDirection(board, myPosition, 1, 0);
		checkDirection(board, myPosition, -1, 0);
		checkDirection(board, myPosition, 1, 1);
		checkDirection(board, myPosition, -1, -1);
		checkDirection(board, myPosition, 1, -1);
		checkDirection(board, myPosition, -1, 1);

		return legalMoves;
	}
}
