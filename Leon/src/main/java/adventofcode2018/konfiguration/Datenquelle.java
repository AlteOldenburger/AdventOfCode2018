package main.java.adventofcode2018.konfiguration;

import java.io.BufferedReader;
import java.io.IOException;

public interface Datenquelle 
{
	public BufferedReader leseTextDateiEin(String pfad) throws IOException;
}
