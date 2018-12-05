package it.macke.adventofcode2018.ex04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import it.macke.adventofcode2018.ex04.SleepLogEntry.Builder;

public class SleepLogParser
{
	private static final Pattern DATE = Pattern.compile("\\[([0-9]{4}-[0-9]{2}-[0-9]{2}) [0-9]{2}:([0-9]{2})\\] .+");
	private static final Pattern NEW_GUARD = Pattern.compile(".+Guard #([0-9]+) begins shift.*");
	private static final Pattern FALLS_ASLEEP = Pattern.compile(".+falls asleep.*");
	private static final Pattern WAKES_UP = Pattern.compile(".+wakes up.*");

	private List<SleepLogEntry> entries;
	private String currentLine;
	private Builder currentEntry;
	private int currentGuardId;
	private LocalDate currentDate;
	private int currentMinute;

	public List<SleepLogEntry> parse(List<String> lines)
	{
		entries = new ArrayList<SleepLogEntry>();
		processLines(lines.stream().sorted().collect(Collectors.toList()));
		return entries;
	}

	private void processLines(List<String> sortedLines)
	{
		currentEntry = new SleepLogEntry.Builder();
		currentGuardId = 0;
		for (var currentLine : sortedLines)
		{
			this.currentLine = currentLine;
			processLine();
		}
		processCurrentEntry();
	}

	private void processLine()
	{
		extractDate();
		extractNewGuard();
		extractFallsAsleep();
		extractWakesUp();
	}

	private void extractDate()
	{
		var matcher = DATE.matcher(currentLine);
		if (!matcher.matches())
		{
			throw new IllegalArgumentException("Line does not contain date: " + currentLine);
		}
		currentDate = LocalDate.parse(matcher.group(1));
		currentMinute = Integer.parseInt(matcher.group(2));
	}

	private void extractNewGuard()
	{
		var matcher = NEW_GUARD.matcher(currentLine);
		if (matcher.matches())
		{
			processCurrentEntry();
			currentGuardId = Integer.parseInt(matcher.group(1));
			currentEntry = new SleepLogEntry.Builder()
					.withDate(currentDate)
					.withGuardId(currentGuardId);
		}
	}

	private void extractFallsAsleep()
	{
		if (FALLS_ASLEEP.matcher(currentLine).matches())
		{
			currentEntry = currentEntry
					.withAsleepFrom(currentMinute)
					.withDate(currentDate);
		}
	}

	private void extractWakesUp()
	{
		if (WAKES_UP.matcher(currentLine).matches())
		{
			currentEntry = currentEntry
					.withAsleepUntil(currentMinute - 1);
			processCurrentEntry();
		}
	}

	private void processCurrentEntry()
	{
		if (currentEntry.isValid())
		{
			entries.add(currentEntry.build());
			currentEntry = new SleepLogEntry.Builder()
					.withDate(currentDate)
					.withGuardId(currentGuardId);
		}
	}
}
