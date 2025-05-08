package chess;

import java.util.Collection;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece
{
	ChessGame.TeamColor color;
	ChessPiece.PieceType type;

	public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type)
	{
		color = pieceColor;
		this.type = type;
	}

	/**
	 * @return Which team this chess piece belongs to
	 */
	public ChessGame.TeamColor getTeamColor()
	{
		return color;
	}

	/**
	 * @return which type of chess piece this piece is
	 */
	public PieceType getPieceType()
	{
		return type;
	}

	/**
	 * Calculates all the positions a chess piece can move to
	 * Does not take into account moves that are illegal due to leaving the king in
	 * danger
	 *
	 * @return Collection of valid moves
	 */
	public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition)
	{
		throw new RuntimeException("Not implemented");
	}

	/**
	 * The various different chess piece options
	 */
	public enum PieceType
	{
		KING,
		QUEEN,
		BISHOP,
		KNIGHT,
		ROOK,
		PAWN
	}

	@Override
	public boolean equals(Object o)
	{
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		ChessPiece piece = (ChessPiece) o;
		return color == piece.color && type == piece.type;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(color, type);
	}

	@Override
	public String toString()
	{
		String output;

		if(color == ChessGame.TeamColor.WHITE)
		{
			switch(type)
			{
				case KING -> output = "K";
				case QUEEN -> output = "Q";
				case BISHOP -> output = "B";
				case KNIGHT -> output = "N";
				case ROOK ->  output = "R";
				case PAWN -> output = "P";
				default -> output = " ";
			}
		}
		else if(color == ChessGame.TeamColor.BLACK)
		{
			switch(type)
			{
				case KING -> output = "k";
				case QUEEN -> output = "q";
				case BISHOP -> output = "b";
				case KNIGHT -> output = "n";
				case ROOK ->  output = "r";
				case PAWN -> output = "p";
				default -> output = " ";
			}
		}
		else
		{
			output = " ";
		}

		return output;
	}
}
