package chess.MoveCalculators;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.Collection;

public class KingMoveCalculator extends MoveCalculator
{
	public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition)
	{
		legalMoves.add(checkMove(board, myPosition, 0, 1));
		legalMoves.add(checkMove(board, myPosition, 0, -1));
		legalMoves.add(checkMove(board, myPosition, 1, 0));
		legalMoves.add(checkMove(board, myPosition, -1, 0));
		legalMoves.add(checkMove(board, myPosition, 1, 1));
		legalMoves.add(checkMove(board, myPosition, -1, -1));
		legalMoves.add(checkMove(board, myPosition, 1, -1));
		legalMoves.add(checkMove(board, myPosition, -1, 1));

		for(int i = legalMoves.size() - 1; i > -1; i--)
		{
			if(legalMoves.get(i) == null)
			{
				legalMoves.remove(i);
			}
		}

		return legalMoves;
	}
}
