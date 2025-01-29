package chess.MoveCalculators;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.Collection;

public abstract class MoveCalculator
{
	protected final Collection<ChessMove> legalMoves = new ArrayList<>();

	abstract public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition);

	protected void checkDirection(ChessBoard board, ChessPosition start, int rowOffset, int colOffset)
	{
		ChessPosition end = start.offset(rowOffset, colOffset);
		ChessMove testMove = new ChessMove(start, end, null);

		while(testMove.checkMove(board))
		{
			legalMoves.add(testMove);
			if(board.containsEnemy(end, board.getPiece(start).getTeamColor()))
			{
				break;
			}
			end = end.offset(rowOffset, colOffset);
			testMove = new ChessMove(start, end, null);
		}
	}
}