package main.java.adventofcode2018.tag1;

import java.util.List;
import java.util.stream.Collectors;

public class Main 
{
	public static void main(String[] args)
	{
		String dateipfad = "src/main/resources/adventofcode2018/tag1/Daten.txt";
		Dateileser dateileser = new Dateileser();
		List<String> frequenzen = dateileser.leseTextdateiEin(dateipfad);
		System.out.println(new Frequenzierer().stelleFrequenzEin(konvertiereFrequenzlisteInArray(frequenzen)));
	}
	
	private static String[] konvertiereFrequenzlisteInArray(List<String> frequenzen)
	{
		return frequenzen.stream()
				.collect(Collectors.joining(",")).split(",");
	}
}
