package chess.MoveCalculators;

import chess.*;

import java.util.ArrayList;

public class KingMoveCalculator extends MoveCalculator
{
	public ArrayList<ChessMove> pieceMoves(ChessBoard board, ChessPosition start)
	{
		checkDirection(0, 1, board, start);
		checkDirection(1, 0, board, start);
		checkDirection(0, -1, board, start);
		checkDirection(-1, 0, board, start);

		checkDirection(1, 1, board, start);
		checkDirection(1, -1, board, start);
		checkDirection(-1, 1, board, start);
		checkDirection(-1, -1, board, start);
		
		return moves;
	}

	@Override
	protected void checkDirection(int rowOffset, int colOffset, ChessBoard board, ChessPosition start)
	{
		ChessPiece piece = board.getPiece(start);
		ChessGame.TeamColor color = piece.getTeamColor();

		int row = start.getRow() + rowOffset;
		int col = start.getColumn() + colOffset;

		if(validPieceMove(row, col, board, color))
		{
			ChessPosition end = new ChessPosition(row, col);

			moves.add(new ChessMove(start, end, null));
		}
	}
}
