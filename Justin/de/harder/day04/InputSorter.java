package de.harder.day04;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.harder.day03.Dateileser;

public class InputSorter
{
	public static Map<LocalDateTime, String> createMap(List<String> input)
	{
		Map<LocalDateTime, String> guardsSituationAtDateTime = new HashMap<>();
		for (int index = 0; index < input.size(); index++)
		{
			String line = input.get(index);

			String dateTimeString = line.substring(line.indexOf('[') + 1, line.indexOf(']'));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);

			guardsSituationAtDateTime.put(dateTime, line.substring(line.indexOf(']') + 2));
		}

		return guardsSituationAtDateTime;
	}

	public static Map<LocalDateTime, String> sort(Map<LocalDateTime, String> input)
	{
		Map<LocalDateTime, String> guardsInOrder = new HashMap<>();

		return guardsInOrder;
	}

	public static void main(String[] args)
	{
		Dateileser dateileser = new Dateileser();
		Map<LocalDateTime, String> inputAsMap =
				createMap(dateileser.leseDateiEin("../AdventOfCode2018/Justin/de/harder/day04/input.txt"));
		System.out.println(inputAsMap.toString());
	}
}
