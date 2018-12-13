package de.harder.day03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main
{
	public static void main(String[] args)
	{
		String dateipfad = "../AdventOfCode2018/Justin/de/harder/day03/input.txt";
		Dateileser dateileser = new Dateileser();
		List<String> inhalte = dateileser.leseDateiEin(dateipfad);
		List<Claim> claims = erstelleClaimList(inhalte);
		findeUeberlappendeZellen(claims);
	}

	public static List<Claim> erstelleClaimList(List<String> inhalte)
	{

		List<Claim> claims = new ArrayList<>();

		for (int index = 0; index < inhalte.size(); index++)
		{
			String zeile = inhalte.get(index);

			int id = Integer.parseInt(zeile.substring(1, zeile.indexOf('@') - 1));
			int topEdge = Integer.parseInt(zeile.substring(zeile.indexOf('@') + 2, zeile.indexOf(',')));
			int leftEdge = Integer.parseInt(zeile.substring(zeile.indexOf(',') + 1, zeile.indexOf(':')));
			int height = Integer.parseInt(zeile.substring(zeile.indexOf(':') + 2, zeile.indexOf('x')));
			int width = Integer.parseInt(zeile.substring(zeile.indexOf('x') + 1));

			claims.add(new Claim(id, leftEdge, topEdge, width, height));
		}

		return claims;
	}

	public static int findeUeberlappendeZellen(List<Claim> claims)
	{
		Map<Cell, Integer> zelleMitAnzahlUeberlappungen = new HashMap<>();

		for (Claim claim : claims)
		{
			for (Cell cell : claim.getCells())
			{
				zelleMitAnzahlUeberlappungen.merge(cell, 1, (a, b) -> a + b);
			}
		}

		// Vergleichen von Zellen anhand der Koordination

		return 0;
	}
}
