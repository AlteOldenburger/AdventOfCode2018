package main.java.adventofcode2018.tag02;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.java.adventofcode2018.konfiguration.Dateileser;

public class Main 
{
	public static void main(String[] args)
	{
		String pfad = "src/main/resources/adventofcode2018/tag2/Input.txt";
		ChecksummenBerechner rechner = new ChecksummenBerechner();
		Dateileser dateileser = new Dateileser();
		StringUnterschiedAgent agent = new StringUnterschiedAgent();
		try 
		{
			BufferedReader readerChecksumme = dateileser.leseTextDateiEin(pfad);
			BufferedReader readerAgent = dateileser.leseTextDateiEin(pfad);
			System.out.println(rechner.berechneChecksumme(readerChecksumme));
			System.out.println(agent.spuereUnterschiedlicheCharacterAuf(befuelleListeMitWerten(readerAgent)));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
			
			
	}
	private static List<String> befuelleListeMitWerten(BufferedReader bufferedReader) throws IOException
	{
		String zeile;
		List<String> dateiinhalt = new ArrayList<>();
		while((zeile = bufferedReader.readLine()) != null )
	    {
			dateiinhalt.add(zeile);
	    }
			bufferedReader.close();
		return dateiinhalt;
	}
}
