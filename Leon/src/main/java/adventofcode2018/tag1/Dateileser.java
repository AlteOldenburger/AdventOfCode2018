package main.java.adventofcode2018.tag1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dateileser 
{
	public List<String> leseTextdateiEin(String dateiname)
	{
		
		String zeile = "";
		List<String> dateiinhalt = new ArrayList<>();
		try {
		FileReader filereader = new FileReader(dateiname);
		BufferedReader bufferedreader = new BufferedReader(filereader);
		
		while( (zeile = bufferedreader.readLine()) != null )
	    {
			dateiinhalt.add(zeile);
	    }
			bufferedreader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateiinhalt;
	}
}
