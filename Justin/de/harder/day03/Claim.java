package de.harder.day03;

import java.util.ArrayList;
import java.util.List;

public class Claim
{
	private int id;
	private int topEdge;
	private int leftEdge;
	private int height;
	private int width;

	public Claim(int id, int topEdge, int leftEdge, int height, int width)
	{
		this.id = id;
		this.topEdge = topEdge;
		this.leftEdge = leftEdge;
		this.height = height;
		this.width = width;
	}

	public int getId()
	{
		return id;
	}

	public int getTopEdge()
	{
		return topEdge;
	}

	public int getLeftEdge()
	{
		return leftEdge;
	}

	public int getHeight()
	{
		return height;
	}

	public int getWidth()
	{
		return width;
	}

	public List<Cell> getCells()
	{
		List<Cell> cells = new ArrayList<>();

		for (int heightPos = topEdge; heightPos < topEdge + height; heightPos++)
		{
			for (int widthPos = leftEdge; widthPos < leftEdge + width; widthPos++)
			{
				cells.add(new Cell(heightPos, widthPos));
			}
		}

		return cells;
	}
}
