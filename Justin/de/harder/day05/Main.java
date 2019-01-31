package de.harder.day05;

public class Main
{
	public static void main(String[] args)
	{
		String dateipfad = "../AdventOfCode2018/Justin/de/harder/day05/input.txt";

		Dateileser dateileser = new Dateileser();
		String inhalt = dateileser.leseDateiEin(dateipfad).get(0);

		Polymer polymer = new Polymer(inhalt);
		polymer.reaction();
		System.out.println(polymer.getUnits().size());
	}
}
