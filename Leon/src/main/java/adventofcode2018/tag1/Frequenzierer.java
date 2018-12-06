package main.java.adventofcode2018.tag1;

public class Frequenzierer 
{
	public int stelleFrequenzEin(String[] frequenzen)
	{
		Integer summe = 0;
		
			for(String frequenz:frequenzen)
			{
				summe += Integer.parseInt(frequenz);
			}
		return summe;
	}
}
