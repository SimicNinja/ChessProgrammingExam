package chess.MoveCalculators;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.ArrayList;

public class RookMoveCalculator extends MoveCalculator
{
	public ArrayList<ChessMove> pieceMoves(ChessBoard board, ChessPosition start)
	{
		checkDirection(0, 1, board, start);
		checkDirection(1, 0, board, start);
		checkDirection(0, -1, board, start);
		checkDirection(-1, 0, board, start);

		return moves;
	}
}
