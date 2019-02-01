package de.harder.day05;

public class Main
{
	public static void main(String[] args)
	{
		String dateipfad = "../AdventOfCode2018/Justin/de/harder/day05/input.txt";

		Dateileser dateileser = new Dateileser();
		String inhalt = dateileser.leseDateiEin(dateipfad).get(0);

		// Teil 1
		Polymer polymer = new Polymer(inhalt);
		polymer.reaction();
		System.out.println(polymer.getUnits().size());

		// Teil 2
		char upperCase = 'A';
		char lowerCase = 'a';
		int lengthOfShortestPolymer = polymer.getUnits().size();

		while (lowerCase <= 'z' && upperCase <= 'Z')
		{
			Polymer polymer2 = new Polymer(inhalt);
			polymer2.removeUnits(upperCase, lowerCase);
			polymer2.reaction();
			//			System.out.println("Polymer ohne " + upperCase + ", " + lowerCase + ": " + polymer2.getUnits().size());

			if (polymer2.getUnits().size() < lengthOfShortestPolymer)
			{
				lengthOfShortestPolymer = polymer2.getUnits().size();
			}

			upperCase++;
			lowerCase++;
		}

		System.out.println("Shortest Polymer: " + lengthOfShortestPolymer);
	}
}
