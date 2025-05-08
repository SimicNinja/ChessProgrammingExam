package chess.MoveCalculators;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.ArrayList;

public abstract class MoveCalculator
{
	private ArrayList<ChessMove> moves;

	public abstract ArrayList<ChessMove> pieceMoves(ChessBoard board, ChessPosition start);

	private ArrayList<ChessMove> checkDirection(ChessBoard board, ChessPosition start)
	{
		return null;
	}
}
