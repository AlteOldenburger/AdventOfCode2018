package main.java.adventofcode2018.tag01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dateileser 
{
	public List<Integer> leseTextdateiEin(String dateiname)
	{
		String zeile = "";
		List<Integer> dateiinhalt = new ArrayList<>();
		try {
		FileReader filereader = new FileReader(dateiname);
		BufferedReader bufferedreader = new BufferedReader(filereader);
		while((zeile = bufferedreader.readLine()) != null )
	    {
			dateiinhalt.add(Integer.parseInt(zeile));
	    }
			bufferedreader.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return dateiinhalt;
	}
}