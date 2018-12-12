package de.harder.day03;

import java.util.ArrayList;
import java.util.List;

public class Main
{
	public static void main(String[] args)
	{
		String dateipfad = "../AdventOfCode2018/Justin/de/harder/day03/input.txt";
		Dateileser dateileser = new Dateileser();
		List<String> inhalte = dateileser.leseDateiEin(dateipfad);
		List<Claim> claims = erstelleClaimList(inhalte);
	}

	public static List<Claim> erstelleClaimList(List<String> inhalte)
	{

		List<Claim> claims = new ArrayList<>();

		return claims;
	}
}
