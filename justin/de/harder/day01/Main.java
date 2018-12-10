package de.harder.day01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
	public static void main(String[] args)
	{
		List<Integer> frequencyChanges = leseDateiEin();

		int currentFrequency = 0;

		for (int element : frequencyChanges)
		{
			currentFrequency += element;
		}

		System.out.println("The list of frequency changes:\n" +
				frequencyChanges.toString() + "\ngives back the result: " + currentFrequency);
	}

	public static List<Integer> leseDateiEin()
	{
		String dateipfad = "../AdventOfCode2018/Justin/de/harder/day01/input.txt";

		try
		{
			BufferedReader br = new BufferedReader(new FileReader(dateipfad));
			String zeile = null;
			List<Integer> numbers = new ArrayList<>();

			try
			{
				while ((zeile = br.readLine()) != null)
				{
					numbers.add(Integer.parseInt(zeile));
				}
				br.close();
				return numbers;
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
}
