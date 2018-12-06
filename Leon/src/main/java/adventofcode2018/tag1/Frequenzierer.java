package main.java.adventofcode2018.tag1;

import java.util.ArrayList;
import java.util.List;

public class Frequenzierer 
{
	public int stelleFrequenzEin(List<Integer> frequenzen)
	{
		int summe = 0;
		for(int frequenz:frequenzen)
		{
			summe += frequenz;
		}
		return summe;
	}

	public int pruefeAufDoppeltefrequenz(List<Integer> frequenzen) 
	{
		List<Integer> frequenzspeicher = new ArrayList<>();
		int summe = 0;
		boolean frequenzGefunden = false;
		while(frequenzGefunden == false)
		{
			for(int frequenz:frequenzen)
			{
				if(frequenzspeicher.contains(summe))
				{
					frequenzGefunden = true;
					break;
				}
				frequenzspeicher.add(summe);
				summe += frequenz;
			}
		}
		return summe;
	}
}