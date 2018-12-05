package it.macke.adventofcode2018.ex04;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import it.macke.adventofcode2018.ex01.ResourceReader;

public class SleepLogAnalyzer
{
	public static void main(String[] args) throws IOException
	{
		var lines = ResourceReader
				.readResource("/it/macke/adventofcode2018/ex04/Input.txt");
		var log = new SleepLogParser().parse(lines);
		var guard = new SleepLogAnalyzer().analyze(log);
		System.out.println(String.format("Guard #%s with %s minutes most asleep in minute %s -> %s",
				guard.getId(), guard.getTotalSleepTime(), guard.getMostAsleepMinute(),
				guard.getId() * guard.getMostAsleepMinute()));
		// 39422
	}

	public Guard analyze(List<SleepLogEntry> entries)
	{
		var guards = new HashMap<Integer, Guard>();
		for (var entry : entries)
		{
			guards.computeIfAbsent(entry.getGuardId(),
					(id) -> new Guard(id));
			guards.computeIfPresent(entry.getGuardId(),
					(id, guard) -> guard.sleep(entry.getAsleepFrom(), entry.getAsleepUntil()));
		}
		return guards.values()
				.stream()
				.max(Comparator.comparing(Guard::getTotalSleepTime))
				.orElseThrow(() -> new IllegalArgumentException("No guard found"));
	}
}
