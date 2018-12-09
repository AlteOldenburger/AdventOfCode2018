package main.java.adventofcode2018.konfiguration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dateileser implements Datenquelle
{
	@Override
	public BufferedReader leseTextDateiEin(String pfad) throws IOException 
	{
		return new BufferedReader(new FileReader(pfad));
	}
}