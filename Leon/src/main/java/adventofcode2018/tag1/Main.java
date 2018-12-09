package main.java.adventofcode2018.tag1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.java.adventofcode2018.konfiguration.Dateileser;

public class Main 
{
	public static void main(String[] args)
	{
		String pfad = "src/main/resources/adventofcode2018/tag1/Daten.txt";
		Dateileser dateileser = new Dateileser();
		List<Integer> frequenzen = new ArrayList<>();
		try 
		{
			frequenzen = befuelleListeMitWerten(dateileser.leseTextDateiEin(pfad));
		} catch (IOException e) 
		{
			System.out.println("Fehler beim Einlesen der Datei!");
		}
		Frequenzierer frequenzierer = new Frequenzierer();
		System.out.println(frequenzierer.stelleFrequenzEin(frequenzen));
		System.out.println(frequenzierer.pruefeAufDoppeltefrequenz(frequenzen));
	}
	
	private static List<Integer> befuelleListeMitWerten(BufferedReader bufferedreader) throws IOException
	{
		String zeile = "";
		List<Integer> dateiinhalt = new ArrayList<>();
		while((zeile = bufferedreader.readLine()) != null )
	    {
			dateiinhalt.add(Integer.parseInt(zeile));
	    }
			bufferedreader.close();
		return dateiinhalt;
	}
} 