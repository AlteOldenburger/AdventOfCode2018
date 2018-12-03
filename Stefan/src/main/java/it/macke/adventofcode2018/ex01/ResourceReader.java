package it.macke.adventofcode2018.ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class ResourceReader
{
	public static List<String> readResource(String name) throws IOException
	{
		try (var is = ResourceReader.class.getResourceAsStream(name);
				var isr = new InputStreamReader(is);
				var br = new BufferedReader(isr))
		{
			return br.lines().collect(Collectors.toList());
		}
	}
}
