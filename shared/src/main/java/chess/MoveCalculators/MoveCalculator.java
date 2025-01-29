package chess.MoveCalculators;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public abstract class MoveCalculator
{
	protected final ArrayList<ChessMove> legalMoves = new ArrayList<>();

	abstract public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition);

	protected ChessMove checkMove(ChessBoard board, ChessPosition start, int rowOffset, int colOffset)
	{
		ChessPosition end = start.offset(rowOffset, colOffset);
		ChessMove testMove = new ChessMove(start, end, null);

		if(!end.outOfBounds() && (!board.occupied(end) || board.containsEnemy(end, board.getPiece(start).getTeamColor())))
		{
			return testMove;
		}
		else
		{
			return null;
		}
	}

	protected void checkDirection(ChessBoard board, ChessPosition start, int rowOffset, int colOffset)
	{
		int moves = 1;
		ChessMove testMove = checkMove(board, start, rowOffset, colOffset);

		while(testMove != null)
		{
			legalMoves.add(testMove);
			if(board.containsEnemy(testMove.getEndPosition(), board.getPiece(start).getTeamColor()))
			{
				break;
			}
			moves++;
			testMove = checkMove(board, start, rowOffset * moves, colOffset * moves);
		}
	}

	@Override
	public boolean equals(Object o)
	{
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		MoveCalculator that = (MoveCalculator) o;
		return Objects.equals(legalMoves, that.legalMoves);
	}

	@Override
	public int hashCode()
	{
		return Objects.hashCode(legalMoves);
	}
}