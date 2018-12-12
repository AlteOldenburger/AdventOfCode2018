package main.java.adventofcode2018.tag12;

public class Blumentopf
{
	char pflanze;

	public Blumentopf(final char pflanze)
	{
		this.pflanze = pflanze;
	}

	public void wachse()
	{
		pflanze = '#';
	}

	public void verwelke()
	{
		pflanze = '.';
	}

	@Override
	public String toString()
	{
		return pflanze + "";
	}

}
