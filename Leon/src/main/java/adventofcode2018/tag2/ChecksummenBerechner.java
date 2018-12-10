package main.java.adventofcode2018.tag2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ChecksummenBerechner 
{
	public int berechneChecksumme(BufferedReader bufferedreader) throws IOException
	{
		String zeile; 
		int doppelteBuchstaben = 0;
		int dreifacheBuchstaben = 0;
		while((zeile = bufferedreader.readLine()) != null)
		{
			Map<Character, Integer> codes = new HashMap<>();
			for(char character : zeile.toCharArray())
			{
				codes.merge(character, 1, (a,b) -> a+b);
			}
			Set<Integer> einzigartigeCodes = new HashSet<>(codes.values());
			//System.out.println(einzigartigeCodes);
			if(einzigartigeCodes.contains(2)) 
			{
				doppelteBuchstaben++;
			}
			if(einzigartigeCodes.contains(3))
			{
				dreifacheBuchstaben++;
			}
		}
		bufferedreader.close();
		return doppelteBuchstaben * dreifacheBuchstaben;
	}
}
