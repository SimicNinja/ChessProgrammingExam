package chess;

import java.util.Objects;

/**
 * Represents a single square position on a chess board
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPosition
{
	private int row, col;

	public ChessPosition(int row, int col)
	{
		this.row = row;
		this.col = col;
	}

	/**
	 * @return which row this position is in
	 * 1 codes for the bottom row
	 */
	public int getRow()
	{
		return row;
	}

	/**
	 * @return which column this position is in
	 * 1 codes for the left row
	 */
	public int getColumn()
	{
		return  col;
	}

	public ChessPosition offset(int rowOffset, int colOffset)
	{
		return new ChessPosition(this.row + rowOffset, this.col + colOffset);
	}

	public boolean outOfBounds()
	{
		return row < 1 || row > 8 || col < 1 || col > 8;
	}

	@Override
	public boolean equals(Object o)
	{
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		ChessPosition that = (ChessPosition) o;
		return row == that.row && col == that.col;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(row, col);
	}

	@Override
	public String toString()
	{
		return "{" + row + ", " + col + '}';
	}
}
