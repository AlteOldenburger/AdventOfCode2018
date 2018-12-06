package main.java.adventofcode2018.tag1;

import java.util.List;

public class Main 
{
	public static void main(String[] args)
	{
		String dateipfad = "src/main/resources/adventofcode2018/tag1/Daten.txt";
		Dateileser dateileser = new Dateileser();
		List<Integer> frequenzen = dateileser.leseTextdateiEin(dateipfad);
		Frequenzierer frequenzierer = new Frequenzierer();
		System.out.println(frequenzierer.stelleFrequenzEin(frequenzen));
		System.out.println(frequenzierer.pruefeAufDoppeltefrequenz(frequenzen));
	}
} 