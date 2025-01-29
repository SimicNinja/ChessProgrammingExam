package chess.MoveCalculators;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.Collection;

public abstract class MoveCalculator
{
	abstract public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition);

	protected Collection<ChessMove> checkDirection(ChessBoard board, ChessPosition start, int rowOffset, int colOffset)
	{
		Collection<ChessMove> directionMoves = new ArrayList<>();

		ChessPosition end = start.offset(rowOffset, colOffset);
		ChessMove testMove = new ChessMove(start, end, null);

		while(testMove.checkMove(board))
		{
			directionMoves.add(testMove);
			end = end.offset(rowOffset, colOffset);
			testMove = new ChessMove(start, end, null);
		}

		return directionMoves;
	}
}