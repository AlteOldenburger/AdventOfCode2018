package de.harder.day05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dateileser
{
	public List<String> leseDateiEin(String dateipfad)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(dateipfad));
			String zeile = null;
			List<String> inhalte = new ArrayList<>();

			try
			{
				while ((zeile = br.readLine()) != null)
				{
					inhalte.add(zeile);
				}
				br.close();
				return inhalte;
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
