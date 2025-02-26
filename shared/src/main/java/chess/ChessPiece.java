package chess;

import chess.MoveCalculators.*;

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
	private ChessGame.TeamColor color;
	private ChessPiece.PieceType type;
	private MoveCalculator calculator;

	public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type)
	{
		this.color = pieceColor;
		this.type = type;
		switch(type)
		{
			case PieceType.KING:
				calculator = new KingMoveCalculator();
				break;
			case PieceType.QUEEN:
				calculator = new QueenMoveCalculator();
				break;
			case PieceType.BISHOP:
				calculator = new BishopMoveCalculator();
				break;
			case PieceType.KNIGHT:
				calculator = new KnightMoveCalculator();
				break;
			case PieceType.ROOK:
				calculator = new RookMoveCalculator();
				break;
			case PieceType.PAWN:
				calculator = new PawnMoveCalculator();
				break;
		}
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
		return this.calculator.pieceMoves(board, myPosition);
	}

	@Override
	public boolean equals(Object o)
	{
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		ChessPiece that = (ChessPiece) o;
		return color == that.color && type == that.type && Objects.equals(calculator, that.calculator);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(color, type, calculator);
	}

	@Override
	public String toString()
	{
		if(color == ChessGame.TeamColor.BLACK)
		{
			return switch (type)
			{
				case KING -> "k";
				case QUEEN -> "q";
				case ROOK -> "r";
				case BISHOP -> "b";
				case KNIGHT -> "n";
				case PAWN -> "p";
			};
		}
		else
		{
			return switch (type)
			{
				case KING -> "K";
				case QUEEN -> "Q";
				case ROOK -> "R";
				case BISHOP -> "B";
				case KNIGHT -> "N";
				case PAWN -> "P";
			};
		}
	}
}
