package it.macke.adventofcode2018.ex04;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SleepLogParserShould
{
	@Test
	@DisplayName("parse example sleep log")
	public void parseSleepLog()
	{
		var log = new SleepLogParser().parse(List.of(
				"[1518-11-01 00:00] Guard #10 begins shift",
				"[1518-11-04 00:46] wakes up",
				"[1518-11-04 00:36] falls asleep",
				"[1518-11-01 23:58] Guard #99 begins shift",
				"[1518-11-01 00:25] wakes up",
				"[1518-11-05 00:55] wakes up",
				"[1518-11-01 00:55] wakes up",
				"[1518-11-02 00:50] wakes up",
				"[1518-11-03 00:05] Guard #10 begins shift",
				"[1518-11-03 00:24] falls asleep",
				"[1518-11-03 00:29] wakes up",
				"[1518-11-04 00:02] Guard #99 begins shift",
				"[1518-11-01 00:30] falls asleep",
				"[1518-11-05 00:03] Guard #99 begins shift",
				"[1518-11-01 00:05] falls asleep",
				"[1518-11-02 00:40] falls asleep",
				"[1518-11-05 00:45] falls asleep"));
		assertThat(log.size()).isEqualTo(6);
		assertThat(log).contains(new SleepLogEntry(LocalDate.of(1518, 11, 1), 10, 5, 24));
		assertThat(log).contains(new SleepLogEntry(LocalDate.of(1518, 11, 1), 10, 30, 54));
		assertThat(log).contains(new SleepLogEntry(LocalDate.of(1518, 11, 2), 99, 40, 49));
		assertThat(log).contains(new SleepLogEntry(LocalDate.of(1518, 11, 3), 10, 24, 28));
		assertThat(log).contains(new SleepLogEntry(LocalDate.of(1518, 11, 4), 99, 36, 45));
		assertThat(log).contains(new SleepLogEntry(LocalDate.of(1518, 11, 5), 99, 45, 54));
	}
}
