package it.macke.adventofcode2018.ex03;

import java.util.ArrayList;
import java.util.List;

public class Claim
{
	private int id;
	private int topRow;
	private int leftColumn;
	private int width;
	private int height;

	public Claim(int id, int leftColumn, int topRow, int width, int height)
	{
		this.id = id;
		this.leftColumn = leftColumn;
		this.topRow = topRow;
		this.width = width;
		this.height = height;
	}

	public int getId()
	{
		return id;
	}

	public int getTopRow()
	{
		return topRow;
	}

	public int getLeftColumn()
	{
		return leftColumn;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + id;
		result = prime * result + leftColumn;
		result = prime * result + topRow;
		result = prime * result + width;
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
		Claim other = (Claim) obj;
		if (height != other.height)
		{
			return false;
		}
		if (id != other.id)
		{
			return false;
		}
		if (leftColumn != other.leftColumn)
		{
			return false;
		}
		if (topRow != other.topRow)
		{
			return false;
		}
		if (width != other.width)
		{
			return false;
		}
		return true;
	}

	public List<Cell> getCells()
	{
		var cells = new ArrayList<Cell>();
		for (var column = leftColumn; column < leftColumn + width; column++)
		{
			for (var row = topRow; row < topRow + height; row++)
			{
				cells.add(new Cell(column, row));
			}
		}
		return cells;
	}
}
