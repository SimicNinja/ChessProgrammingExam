package chess.MoveCalculators;

import chess.*;

import static java.lang.Math.abs;

import java.util.ArrayList;
import java.util.Collection;

public class PawnMoveCalculator extends MoveCalculator
{
	public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition)
	{
		int invert = 1;
		ChessGame.TeamColor color = board.getPiece(myPosition).getTeamColor();

		if(color == ChessGame.TeamColor.BLACK)
		{
			invert = -1;
		}

		checkPawnMove(board, myPosition, invert, 0, color);
		checkPawnMove(board, myPosition, 2 * invert, 0, color);
		checkPawnMove(board, myPosition, invert, 1, color);
		checkPawnMove(board, myPosition, invert, -1, color);

		for(int i = legalMoves.size() - 1; i > -1; i--)
		{
			if(legalMoves.get(i) == null)
			{
				legalMoves.remove(i);
			}
		}

		return legalMoves;
	}

	private void checkPawnMove(ChessBoard board, ChessPosition start, int rowOffset, int colOffset, ChessGame.TeamColor color)
	{
		ChessPosition end = start.offset(rowOffset, colOffset);

		if(!end.outOfBounds())
		{
			if(colOffset == 0 && !board.occupied(end))
			{
				if(abs(rowOffset) == 1)
				{
					legalMoves.addAll(promotePawn(start, end, color));
				}
				else if(abs(rowOffset) == 2 && !board.occupied(start.offset(rowOffset / 2, 0)))
				{
					if((color == ChessGame.TeamColor.WHITE && start.getRow() == 2)
							|| color == ChessGame.TeamColor.BLACK && start.getRow() == 7)
					{
						legalMoves.addAll(promotePawn(start, end, color));
					}
				}
			}
			else if(abs(colOffset) > 0 && board.containsEnemy(end, color))
			{
				legalMoves.addAll(promotePawn(start, end, color));
			}
		}
	}

	private Collection<ChessMove> promotePawn(ChessPosition start, ChessPosition end, ChessGame.TeamColor color)
	{
		ArrayList<ChessMove> legalMoves = new ArrayList<>();

		if((color == ChessGame.TeamColor.BLACK && end.getRow() == 1) || (color == ChessGame.TeamColor.WHITE && end.getRow() == 8))
		{
			legalMoves.add(new ChessMove(start, end, ChessPiece.PieceType.QUEEN));
			legalMoves.add(new ChessMove(start, end, ChessPiece.PieceType.BISHOP));
			legalMoves.add(new ChessMove(start, end, ChessPiece.PieceType.ROOK));
			legalMoves.add(new ChessMove(start, end, ChessPiece.PieceType.KNIGHT));
		}
		else
		{
			legalMoves.add(new ChessMove(start, end, null));
		}

		return  legalMoves;
	}
}
