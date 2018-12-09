package main.java.adventofcode2018.tag2;

import java.io.IOException;

import main.java.adventofcode2018.konfiguration.Dateileser;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		String pfad = "src/main/resources/adventofcode2018/tag2/Input.txt";
		ChecksummenBerechner rechner = new ChecksummenBerechner();
		Dateileser dateileser = new Dateileser();
		try 
		{
			System.out.println(rechner.berechneChecksumme(dateileser.leseTextDateiEin(pfad)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
