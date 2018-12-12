package main.java.adventofcode2018.tag12;

import java.util.List;
import java.util.stream.Collectors;

public class PflanzenAusbreitungHellseher
{

	public String prophezeieDieNaechsteGeneration(String pflanzentopfSaat)
	{
		final List<Blumentopf> prophezeiung =
				pflanzentopfSaat.chars()
						.mapToObj(i -> (char) i)
						.map(Blumentopf::new)
						.collect(Collectors.toList());

		return konvertiereZuString(prophezeiung);
	}

	private String konvertiereZuString(List<Blumentopf> prophezeiung)
	{
		final StringBuilder stringBuilder = new StringBuilder();
		prophezeiung.forEach(stringBuilder::append);
		return stringBuilder.toString();
	}

}
