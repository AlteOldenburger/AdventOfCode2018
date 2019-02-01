package de.harder.day05;

import java.util.ArrayList;
import java.util.List;

public class Polymer
{
	private List<Character> units = new ArrayList<>();

	public Polymer(String inhalt)
	{
		for (int i = 0; i < inhalt.length(); i++)
		{
			this.units.add(inhalt.charAt(i));
		}
	}

	public void reaction()
	{
		int i = 0;
		while (i < units.size() - 1)
		{
			char unitOne = units.get(i);
			char unitTwo = units.get(i + 1);
			if (areAbleToReact(unitOne, unitTwo))
			{
				units.remove(i + 1);
				units.remove(i);
				if (i > 0)
				{
					i--;
				}
			}
			else
			{
				i++;
			}
		}
	}

	private boolean areAbleToReact(char unitOne, char unitTwo)
	{
		// ASCII-Abstand zwischen Groß- und Kleinbuchstaben
		return unitOne - unitTwo == 32 || unitOne - unitTwo == -32;
	}

	public void removeUnits(char unitToRemoveUpperCase, char unitToRemoveLowerCase)
	{
		int i = 0;
		while (i < units.size() - 1)
		{
			if (units.get(i) == unitToRemoveUpperCase || units.get(i) == unitToRemoveLowerCase)
			{
				units.remove(i);
				if (i > 0)
				{
					i--;
				}
			}
			else
			{
				i++;
			}
		}
	}

	public List<Character> getUnits()
	{
		return units;
	}
}
