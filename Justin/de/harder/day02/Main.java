package de.harder.day02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
	public static List<String> leseDateiEin()
	{
		String dateipfad = "../AdventOfCode2018/Justin/de/harder/day02/input.txt";

		try
		{
			BufferedReader br = new BufferedReader(new FileReader(dateipfad));
			String zeile = null;
			List<String> letters = new ArrayList<>();

			try
			{
				while ((zeile = br.readLine()) != null)
				{
					letters.add(zeile);
				}
				br.close();
				return letters;
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args)
	{
		List<String> letters = leseDateiEin();
		int[] occurences = countLetters(letters);
		System.out.println(occurences[0] + " * " + occurences[1] + " = " + occurences[0] * occurences[1]);
	}

	public static int[] countLetters(List<String> letters)
	{
		int[] occurences = new int[2];
		for (int element : occurences)
		{
			element = 0;
		}

		int zeileInLetters = 0;
		while (zeileInLetters < letters.size())
		{
			String zeile = letters.get(zeileInLetters);

			int[] occurencesInZeile = new int[26];
			for (int element : occurencesInZeile)
			{
				element = 0;
			}

			for (int positionInLettersZeile = 0; positionInLettersZeile < zeile.length(); positionInLettersZeile++)
			{
				for (int positionInASCIITable = 97; positionInASCIITable <= 'z'; positionInASCIITable++)
				{
					if (zeile.charAt(positionInLettersZeile) == positionInASCIITable)
					{
						occurencesInZeile[positionInASCIITable - 97]++;
					}
				}
			}

			boolean alreadyTwo = false;
			boolean alreadyThree = false;
			for (int element : occurencesInZeile)
			{
				if (element == 2 && !alreadyTwo)
				{
					occurences[0]++;
					alreadyTwo = true;
				}
				if (element >= 3 && !alreadyThree)
				{
					occurences[1]++;
					alreadyThree = true;
				}
			}
			zeileInLetters++;
		}

		return occurences;
	}
}
