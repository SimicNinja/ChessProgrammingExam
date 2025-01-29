package chess.MoveCalculators;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.Collection;

public class BishopMoveCalculator extends MoveCalculator
{
	public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition)
	{
		checkDirection(board, myPosition, 1, 1);
		checkDirection(board, myPosition, -1, -1);
		checkDirection(board, myPosition, 1, -1);
		checkDirection(board, myPosition, -1, 1);

		return legalMoves;
	}
}
