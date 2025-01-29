package chess;

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
		throw new RuntimeException("Not implemented");
	}
}
