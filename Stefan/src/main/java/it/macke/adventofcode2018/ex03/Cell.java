package it.macke.adventofcode2018.ex03;

public class Cell
{
	private int column;
	private int row;

	public Cell(int column, int row)
	{
		this.column = column;
		this.row = row;
	}

	public int getColumn()
	{
		return column;
	}

	public int getRow()
	{
		return row;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Cell other = (Cell) obj;
		if (column != other.column)
		{
			return false;
		}
		if (row != other.row)
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "Cell [column=" + column + ", row=" + row + "]";
	}
}
