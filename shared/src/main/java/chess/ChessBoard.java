package chess;

import java.util.Arrays;
import java.util.Objects;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard
{
    ChessPiece[][] board;

	public ChessBoard()
	{
		board = new ChessPiece[8][8];
	}

	/**
	 * Adds a chess piece to the chessboard
	 *
	 * @param position where to add the piece to
	 * @param piece    the piece to add
	 */
	public void addPiece(ChessPosition position, ChessPiece piece)
	{
		board[position.getRow() - 1][position.getColumn() - 1] = piece;
	}

	public boolean occupied(ChessPosition position)
	{
		return board[position.getRow() - 1][position.getColumn() - 1] != null;
	}

	public boolean containsEnemy(ChessPosition position, ChessGame.TeamColor color)
	{
		return occupied(position) && board[position.getRow() - 1][position.getColumn() - 1].getTeamColor() != color;
	}

	public boolean containsAlly(ChessPosition position, ChessGame.TeamColor color)
	{
		return occupied(position) && board[position.getRow() - 1][position.getColumn() - 1].getTeamColor() == color;
	}

	/**
	 * Gets a chess piece on the chessboard
	 *
	 * @param position The position to get the piece from
	 * @return Either the piece at the position, or null if no piece is at that
	 * position
	 */
	public ChessPiece getPiece(ChessPosition position)
	{
		return board[position.getRow() - 1][position.getColumn() - 1];
	}

	/**
	 * Sets the board to the default starting board
	 * (How the game of chess normally starts)
	 */
	public void resetBoard()
	{
		addPowerRow(8, ChessGame.TeamColor.BLACK);
		addPawnRow(7, ChessGame.TeamColor.BLACK);
		addPawnRow(2, ChessGame.TeamColor.WHITE);
		addPowerRow(1, ChessGame.TeamColor.WHITE);
	}

	private void addPawnRow(int row, ChessGame.TeamColor color)
	{
		for(int col = 1; col < 9; col++)
		{
			addPiece(new ChessPosition(row, col), new ChessPiece(color, ChessPiece.PieceType.PAWN));
		}
	}

	private void addPowerRow(int row, ChessGame.TeamColor color)
	{
		for(int col = 1; col < 9; col++)
		{
			ChessPosition position = new ChessPosition(row, col);

			switch(col)
			{
				case 1, 8:
					addPiece(position, new ChessPiece(color, ChessPiece.PieceType.ROOK));
					break;
				case 2, 7:
					addPiece(position, new ChessPiece(color, ChessPiece.PieceType.KNIGHT));
					break;
				case 3, 6:
					addPiece(position, new ChessPiece(color, ChessPiece.PieceType.BISHOP));
					break;
				case 4:
					addPiece(position, new ChessPiece(color, ChessPiece.PieceType.QUEEN));
					break;
				case 5:
					addPiece(position, new ChessPiece(color, ChessPiece.PieceType.KING));
					break;
			}
		}
	}

	@Override
	public boolean equals(Object o)
	{
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		ChessBoard that = (ChessBoard) o;
		return Objects.deepEquals(board, that.board);
	}

	@Override
	public int hashCode()
	{
		return Arrays.deepHashCode(board);
	}

	@Override
	public String toString()
	{
		String output = "";

		for(int row = 7; row > -1; row--)
		{
			output = output + "\n";
			for(int col = 0; col < 8; col++)
			{
				ChessPiece currentPiece = board[row][col];
				if(currentPiece == null)
				{
					output = output + "| ";
				}
				else
				{
					output = output + "|" + currentPiece.toString();
				}
			}
			output = output + "|";
		}
		output = output + "\n";

		return output;
	}
}