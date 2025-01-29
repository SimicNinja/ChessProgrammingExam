package chess.MoveCalculators;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPosition;
import jdk.jshell.EvalException;

import java.util.ArrayList;
import java.util.Collection;


public class RookMoveCalculator extends MoveCalculator
{
	private final Collection<ChessMove> legalMoves = new ArrayList<>();

	public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition)
	{
		legalMoves.addAll(checkDirection(board, myPosition, 0, 1));
		legalMoves.addAll(checkDirection(board, myPosition, 0, -1));
		legalMoves.addAll(checkDirection(board, myPosition, 1, 0));
		legalMoves.addAll(checkDirection(board, myPosition, -1, 0));

		return legalMoves;
	}
}
